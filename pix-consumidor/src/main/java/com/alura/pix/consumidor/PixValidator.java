package com.alura.pix.consumidor;

import com.alura.pix.dto.PixDTO;
import com.alura.pix.exception.KeyNotFoundException;
import com.alura.pix.model.Pix;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

@Service
public class PixValidator {

    @KafkaListener(topics = "pix-topic", groupId = "grupo")
    @RetryableTopic(
            backoff = @Backoff(value = 3000L),
            attempts = "5",
            autoCreateTopics = "true",
            include = KeyNotFoundException.class
    )
    public void processaPix(PixDTO pixDTO) {
    //public void processaPix(PixDTO pixDTO, Acknowledgment acknowledgment) {
        System.out.println(Pix.toEntity(pixDTO).toString());

        //esse comando envia para o kafka o commit de confirmação de que a mensagem foi processada
        //acknowledgment.acknowledge();
    }

}
