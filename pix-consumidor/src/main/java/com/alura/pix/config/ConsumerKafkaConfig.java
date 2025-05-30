package com.alura.pix.config;

import com.alura.pix.dto.PixDTO;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafkaStreams
public class ConsumerKafkaConfig {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Bean
    public ConsumerFactory<String, PixDTO> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapAddress);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,JsonDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES,"*");
        // -> Essa config me permite escolher a quantidade de mensagens que quero processar de uma vez
        //props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG,100);
        //props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        // -> Essa config permite informar para o kafka se ele pode criar automaticamente o topic q estou escutando
        // ou se eu crio manualmente
        //props.put(ConsumerConfig.ALLOW_AUTO_CREATE_TOPICS_CONFIG,false);

        // -> Essa config serve para manipular o commit de mensagem processada pelo consumer para o kafka
        //props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,false);
        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, PixDTO>
        kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, PixDTO> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

//    @Bean(name = kafkaStreamDefaultConfiguration DEFAULT_STREAMS_CONFIG_BEAN_NAME)
//    public kafkaStreamsConfiguration kafkaStreamConfig() {
//        Map props = new HashMap<>();
//        props.put(APPLICATION_ID_CONFIG , "kafka-streams-demo-6");
//        props.put(BOOSTSTRAP_SERVERS_CONFIG, bootstrapAddress);
//        props.put)DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
//        props.put(DEFAULT_VALUE_SERDE_CLASS_CONFIG, PixSerdes.class);
//        return new kafkaStreamsConfiguration(props);
//    }


}
