package com.cloudera.se.flume;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.*;

import io.confluent.kafka.serializers.KafkaAvroDecoder;
import kafka.utils.VerifiableProperties;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.util.Utf8;
import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.conf.ConfigurationException;
import org.apache.flume.serialization.EventSerializer;
import org.apache.kafka.common.errors.SerializationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jholoman on 5/27/15.
 */
public class RegistryPayloadSerializer implements EventSerializer {

    private final static Logger logger =
            LoggerFactory.getLogger(RegistryPayloadSerializer.class);

    // for legacy reasons, by default, append a newline to each event written out
    private final String APPEND_NEWLINE = "appendNewline";
    private final boolean APPEND_NEWLINE_DFLT = true;
    protected static final byte MAGIC_BYTE = 0x0;
    protected static final int idSize = 4;
    public static final String KAFKA_SCHEMA_REGISTRY_URL = "schemaRegistryUrl";
    private String STRING_FIELD = "payload";
    private final OutputStream out;
    private final boolean appendNewline;
    private VerifiableProperties VProps;

    private RegistryPayloadSerializer(OutputStream out, Context ctx) {
        this.appendNewline = ctx.getBoolean(APPEND_NEWLINE, APPEND_NEWLINE_DFLT);
        this.out = out;
        String schemaRegistryURL =
                ctx.getString(KAFKA_SCHEMA_REGISTRY_URL);
        if (schemaRegistryURL == null || schemaRegistryURL.isEmpty()) {
            logger.debug("Bad Schema Registry URL");
            throw new ConfigurationException("Schema Registry URL must be specified");
        }
        Properties props = new Properties();
        props.put("schema.registry.url", schemaRegistryURL);

        VProps = new VerifiableProperties(props);
    }

    private Utf8 getStringField(GenericRecord record) {
        return (Utf8)record.get(STRING_FIELD);
    }

    @Override
    public void write(Event event) throws IOException {
        if (!(event.getBody() == null)) {
            Schema schema = null;
            Object o = new Object();
            //ByteBuffer buffer = getByteBuffer(event.getBody());
            //byte[] b = buffer.array();
            byte[] b = event.getBody();
            KafkaAvroDecoder d = new KafkaAvroDecoder(VProps);
            GenericRecord message = (GenericRecord) d.fromBytes(b);
            //logger.info(message.getSchema().toString());
            //logger.info(message.toString());
                Utf8 payload = getStringField(message);
            //logger.info("The payload is " + payload.toString());
                out.write(payload.getBytes());
        }
        if (appendNewline) {
            out.write('\n');
        }

    }

    @Override
    public boolean supportsReopen() {
        return true;
    }

    @Override
    public void afterCreate() {
        // noop
    }

    @Override
    public void afterReopen() {
        // noop
    }

    @Override
    public void beforeClose() {
        // noop
    }


    @Override
    public void flush() throws IOException {
        // noop
    }


    public static class Builder implements EventSerializer.Builder {

        @Override
        public EventSerializer build(Context context, OutputStream out) {
            RegistryPayloadSerializer s = new RegistryPayloadSerializer(out, context);
            return s;
        }

    }



}



