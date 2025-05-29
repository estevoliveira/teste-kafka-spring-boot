package com.alura.pix.dto;

import java.time.LocalDateTime;


public class PixDTO {
    private String identifier;
    private String chaveOrigem;
    private String chaveDestino;
    private Double valor;
    private LocalDateTime dataTransferencia;
    private PixStatus status;

    public PixDTO() {
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getChaveOrigem() {
        return chaveOrigem;
    }

    public String getChaveDestino() {
        return chaveDestino;
    }

    public Double getValor() {
        return valor;
    }

    public LocalDateTime getDataTransferencia() {
        return dataTransferencia;
    }

    public PixStatus getStatus() {
        return status;
    }
}
