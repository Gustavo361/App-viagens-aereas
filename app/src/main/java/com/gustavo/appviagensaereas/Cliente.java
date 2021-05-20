package com.gustavo.appviagensaereas;

import java.io.Serializable;

public class Cliente implements Serializable {

    private String etNomeCadastro;
    private String etIdade;
    private String etEmail;
    private String etSenha;
    private String etCpf;

    private String viagem;
    private String etDate;
    private String etDate2;
    private String etPesoKg;

    private String lugar; //raddiobutton do lugar
    private String hotel; // spinner do hotel


    public String getEtNomeCadastro() {
        return etNomeCadastro;
    }

    public void setEtNomeCadastro(String etNomeCadastro) {
        this.etNomeCadastro = etNomeCadastro;
    }

    public String getEtIdade() {
        return etIdade;
    }

    public void setEtIdade(String etIdade) {
        this.etIdade = etIdade;
    }

    public String getEtEmail() {
        return etEmail;
    }

    public void setEtEmail(String etEmail) {
        this.etEmail = etEmail;
    }

    public String getEtSenha() {
        return etSenha;
    }

    public void setEtSenha(String etSenha) {
        this.etSenha = etSenha;
    }

    public String getEtCpf() {
        return etCpf;
    }

    public void setEtCpf(String etCpf) {
        this.etCpf = etCpf;
    }

    public String getEtDate() {
        return etDate;
    }

    public void setEtDate(String etDate) {
        this.etDate = etDate;
    }

    public String getEtDate2() {
        return etDate2;
    }

    public void setEtDate2(String etDate2) {
        this.etDate2 = etDate2;
    }

    public String getEtPesoKg() {
        return etPesoKg;
    }

    public void setEtPesoKg(String etPesoKg) {
        this.etPesoKg = etPesoKg;
    }

    public String getViagem() {
        return viagem;
    }

    public void setViagem(String viagem) {
        this.viagem = viagem;
    }

    public  String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "etNomeCadastro='" + etNomeCadastro + '\'' +
                ", etIdade='" + etIdade + '\'' +
                ", etEmail='" + etEmail + '\'' +
                ", etSenha='" + etSenha + '\'' +
                ", etCpf='" + etCpf + '\'' +
                ", lugar='" + lugar + '\'' +
                ", hotel='" + hotel + '\'' +
                '}';
    }
}
