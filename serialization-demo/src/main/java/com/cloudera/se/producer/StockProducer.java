package com.cloudera.se.producer;

import com.cloudera.se.avro.TickerExplicit;
import com.cloudera.se.avro.TickerInline;
import com.cloudera.se.util.DemoUtils;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

/**
 * Created by jholoman on 8/23/15.
 */
public class StockProducer {


    public static void main(String[] args) {
        if (args.length < 5) {
            System.out.println("USAGE: Example <BrokerList> <Topic> <SchemaRegistry> <num_records> <explicit|inline>>");
            System.exit(1);

        }

        String brokerList = args[0];
        String topic = args[1];
        String schemaRegistry = args[2];
        Long iterations = Long.parseLong(args[3]);
        String messageType = args[4];

        if (!(messageType.equals("explicit") || messageType.equals("inline"))) {
            throw new IllegalArgumentException("Message type must be 'explict' or 'inline'");
        }

        Properties props = new Properties();
        props.put("bootstrap.servers", brokerList);
        props.put("client.id", "DemoProducer");
        props.put("key.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
        props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
        props.put("schema.registry.url", schemaRegistry);
        props.put("acks", "all");
        props.put("retries", 3);

        DemoUtils utils = new DemoUtils();

        if (messageType.equals("explicit")) {
            KafkaProducer<String, TickerExplicit> producer = new KafkaProducer<String, TickerExplicit>(props);
            TickerExplicit ticker = new TickerExplicit();
            for (int i = 0; i < iterations; i++) {
                long startTime = System.currentTimeMillis();
                utils.setTickerExplicitFields(ticker);
                producer.send(new ProducerRecord<String, TickerExplicit>(topic, null, ticker), new StockCallback(startTime, ticker));
            }
        producer.close();
        } else if (messageType.equals("inline")) {
            KafkaProducer<String, TickerInline> producer = new KafkaProducer<String, TickerInline>(props);
            TickerInline ticker = new TickerInline();
            for (int i = 0; i < iterations; i++) {
                long startTime = System.currentTimeMillis();
                utils.setTickerInlineFields(ticker);
                producer.send(new ProducerRecord<String, TickerInline>(topic, null, ticker), new StockCallback(startTime, ticker));
                System.out.println(ticker.getSource());
            }
        producer.close();
        }
    }
}
    class StockCallback implements Callback {
        private long startTime;

        public StockCallback(Long startTime, GenericRecord data) {
            this.startTime = startTime;
        }
        public void onCompletion(RecordMetadata metadata, Exception exception) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            if (metadata != null) {
                System.out.println(metadata.partition() + "-" + metadata.offset() +" complete in " + elapsedTime + " ms");
            } else {
                exception.printStackTrace();
            }
        }
    }
