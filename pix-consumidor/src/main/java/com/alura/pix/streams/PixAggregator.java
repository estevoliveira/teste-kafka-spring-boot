package com.alura.pix.streams;

import org.springframework.stereotype.Service;

@Service
public class PixAggregator {

//    @Autowired
//    public void aggregator(StreamBuilder streamBuilder) {
//
//        KTable<String, Double> messageStream = streamBuilder
//                .stream("pix-topic", Consumed.with(Serdes.String(), PixSerdes.serdes()))
//                .peek((key, value) -> System.out.println("Pix recebido de: " + value.getChaveOrigem()))
//                .groupBy(key, value) -> value.getChaveOrigem()) KGRroupedStream<String, PixDTO>
//                        .aggregate(
//                () -> 0.0
//        (key, value, aggregate) -> (aggregate + value.getValor()),
//                Materialized.with(Serdes.String(), Serdes.Double())
//
//
//                      );
//
//        messageStream.toStream().print(Printed.toSysOut());
//        messageStream.toStream.to( s: "pix-topic-agregacao",  Produced.with(Serdes.String(), Serdes.Double()));
//
//    }
}
