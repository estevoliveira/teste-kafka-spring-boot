package com.alura.pix.serders;

import com.alura.pix.dto.PixDTO;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

//public class PixSerder extends Serdes.wrapperSerde<PixDTO>{
//
//    public PixSerdes() {
//        super(new JsonSerializer<>(), new JsonDeserializer<>(PixDTO.class));
//    }
//
//    public Serde<PixDTO> serdes() {
//        JsonSerializer<PixDTO> serializer = new JsonSerializer<>();
//        JsonSerializer<PixDTO> deserializer = new JsonDeserializer<>(PixDTO.class);
//        return Serdes.SerdeFrom(serializer, deserializer);
//    }
//}
