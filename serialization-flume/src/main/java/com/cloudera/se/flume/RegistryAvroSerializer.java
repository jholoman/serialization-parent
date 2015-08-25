package com.cloudera.se.flume;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.*;

import io.confluent.kafka.serializers.KafkaAvroDecoder;
import org.apache.avro.AvroRuntimeException;
import kafka.utils.VerifiableProperties;
import org.apache.avro.Schema;
import org.apache.avro.file.CodecFactory;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;
import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.conf.Configurable;
import org.apache.flume.conf.ConfigurationException;
import org.apache.flume.serialization.EventSerializer;
import org.apache.kafka.common.errors.SerializationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.apache.flume.serialization.AvroEventSerializerConfigurationConstants.*;

/**
 * Created by jholoman on 5/21/15.
 */
public class RegistryAvroSerializer implements EventSerializer, Configurable {

    protected static final byte MAGIC_BYTE = 0x0;
    protected static final int idSize = 4;

    private static final Logger logger =
            LoggerFactory.getLogger(RegistryAvroSerializer.class);

    public static final String KAFKA_SCHEMA_REGISTRY_URL = "schemaRegistryUrl";

 //   SchemaRegistryClient schemaRegistry;
    private final OutputStream out;
    private DatumWriter<Object> writer = null;
    private DataFileWriter<Object> dataFileWriter = null;

    private int syncIntervalBytes;
    private String compressionCodec;
    private Map<Integer, Schema> schemaCache = new HashMap<Integer, Schema>();
    private VerifiableProperties VProps;


    private RegistryAvroSerializer(OutputStream out) {
        this.out = out;
    }

    @Override
    public void configure(Context context) {
        syncIntervalBytes =
                context.getInteger(SYNC_INTERVAL_BYTES, DEFAULT_SYNC_INTERVAL_BYTES);
        compressionCodec =
                context.getString(COMPRESSION_CODEC, DEFAULT_COMPRESSION_CODEC);
        String schemaRegistryURL =
                context.getString(KAFKA_SCHEMA_REGISTRY_URL);
        if (schemaRegistryURL == null || schemaRegistryURL.isEmpty()) {
            logger.debug("Bad Schema Registry URL");
            throw new ConfigurationException("Schema Registry URL must be specified");
        }
        Properties props = new Properties();
        props.put("schema.registry.url", schemaRegistryURL);

        VProps = new VerifiableProperties(props);
    }

    @Override
    public void afterCreate() throws IOException {
        // no-op
    }

    @Override
    public void afterReopen() throws IOException {
        // impossible to initialize DataFileWriter without writing the schema?
        throw new UnsupportedOperationException("Avro API doesn't support append");
    }

    @Override
    public void write(Event event) throws IOException {
        if (dataFileWriter == null) {
            initialize(event);
        }
        ByteBuffer buf = getByteBuffer(event.getBody());
        buf.getInt();
        //dataFileWriter.appendEncoded(ByteBuffer.wrap(event.getBody()));
        dataFileWriter.appendEncoded(buf);
    }

    private void initialize(Event event) throws IOException {
        if (!(event.getBody() == null)) {
            Schema schema = null;
            Object o = new Object();
            //ByteBuffer buffer = getByteBuffer(event.getBody());
            //byte[] b = buffer.array();
            byte[] b = event.getBody();
            KafkaAvroDecoder d = new KafkaAvroDecoder(VProps);

            GenericRecord message = (GenericRecord) d.fromBytes(b);

            schema = message.getSchema();
            writer = new GenericDatumWriter<Object>(schema);

            logger.debug("Initiating DataFile Writer for schema:");
            logger.debug(schema.toString());

            dataFileWriter = new DataFileWriter<Object>(writer);
            dataFileWriter.setSyncInterval(syncIntervalBytes);

            try {
                CodecFactory codecFactory = CodecFactory.fromString(compressionCodec);
                dataFileWriter.setCodec(codecFactory);
                } catch (AvroRuntimeException e) {
                logger.warn("Unable to instantiate avro codec with name (" +
                        compressionCodec + "). Compression disabled. Exception follows.", e);
                }
            dataFileWriter.create(schema, out);
        }
    }

    private ByteBuffer getByteBuffer(byte[] payload) {
        ByteBuffer buffer = ByteBuffer.wrap(payload);
        if (buffer.get() != MAGIC_BYTE) {
            throw new SerializationException("Unknown magic byte!");
        }
        return buffer;
    }

    @Override
    public void flush() throws IOException {
        dataFileWriter.flush();
    }

    @Override
    public void beforeClose() throws IOException {
        // no-op
    }

    @Override
    public boolean supportsReopen() {
        return false;
    }

    public static class Builder implements EventSerializer.Builder {
        @Override
        public EventSerializer build(Context context, OutputStream out) {
            RegistryAvroSerializer writer = new RegistryAvroSerializer(out);
            logger.debug("In the builder");
            writer.configure(context);
            return writer;
        }

    }
}
