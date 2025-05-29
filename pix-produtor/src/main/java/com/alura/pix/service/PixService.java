package com.alura.pix.service;

import com.alura.pix.dto.PixDTO;
import com.alura.pix.dto.PixStatus;
import com.alura.pix.model.Pix;
import com.alura.pix.repository.PixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
//@RequiredArgsConstructor
public class PixService {

    @Autowired
    private PixRepository pixRepository;

    @Autowired
    private KafkaTemplate<String, PixDTO>  kafkaTemplate;

    public PixDTO salvarPix(PixDTO pixDTO) {
        pixDTO.setIdentifier(UUID.randomUUID().toString());
        pixDTO.setDataTransferencia(LocalDateTime.now());
        pixDTO.setStatus(PixStatus.EM_PROCESSAMENTO);

        pixRepository.save(Pix.toEntity(pixDTO));

        kafkaTemplate.send("pix-topic", pixDTO.getIdentifier(), pixDTO);

        return pixDTO;
    }

}
