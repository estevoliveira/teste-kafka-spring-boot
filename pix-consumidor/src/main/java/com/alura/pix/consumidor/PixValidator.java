package com.alura.pix.consumidor;

import com.alura.pix.dto.PixDTO;
import com.alura.pix.model.Pix;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PixValidator {

    @KafkaListener(topics = "pix-topic", groupId = "grupo")
    public void processaPix(PixDTO pixDTO) {
        System.out.println(Pix.toEntity(pixDTO).toString());
    }

}
