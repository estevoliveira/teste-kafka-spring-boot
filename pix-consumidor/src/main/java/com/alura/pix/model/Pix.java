package com.alura.pix.model;

import com.alura.pix.dto.PixDTO;
import com.alura.pix.dto.PixStatus;

import java.time.LocalDateTime;

public class Pix {

    private Integer id;
    private String identifier;
    private String chaveOrigem;
    private String chaveDestino;
    private Double valor;
    private LocalDateTime dataTransferencia;

    private PixStatus status;

    public static Pix toEntity(PixDTO pixDTO) {
        Pix pix = new Pix();
        pix.setIdentifier(pixDTO.getIdentifier());
        pix.setChaveDestino(pixDTO.getChaveDestino());
        pix.setStatus(pixDTO.getStatus());
        pix.setValor(pixDTO.getValor());
        pix.setDataTransferencia(pixDTO.getDataTransferencia());
        pix.setChaveOrigem(pixDTO.getChaveOrigem());
        return pix;
    }

    public Pix() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getChaveOrigem() {
        return chaveOrigem;
    }

    public void setChaveOrigem(String chaveOrigem) {
        this.chaveOrigem = chaveOrigem;
    }

    public String getChaveDestino() {
        return chaveDestino;
    }

    public void setChaveDestino(String chaveDestino) {
        this.chaveDestino = chaveDestino;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(LocalDateTime dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }

    public PixStatus getStatus() {
        return status;
    }

    public void setStatus(PixStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pix{" +
                "identifier='" + identifier + '\'' +
                ", chaveOrigem='" + chaveOrigem + '\'' +
                ", chaveDestino='" + chaveDestino + '\'' +
                ", valor=" + valor +
                ", dataTransferencia=" + dataTransferencia +
                ", status=" + status +
                '}';
    }
}
