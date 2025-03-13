package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class cabinaTelefonica {

        private int id;
        private int llamadasLocales = 0;
        private int llamadasLargaDistancia = 0;
        private int llamadasCelular = 0;
        private int minutosLocales = 0;
        private int minutosLargaDistancia = 0;
        private int minutosCelular = 0;
        private static final int tarifa_local = 50;
        private static final int tarifa_largaDistancia = 350;
        private static final int tarifa_celular = 150;

    public cabinaTelefonica() {
    }

    public cabinaTelefonica(int id, int llamadasLocales, int llamadasLargaDistancia, int llamadasCelular, int minutosLocales, int minutosLargaDistancia, int minutosCelular) {

        this.id = id;
        this.llamadasLocales = llamadasLocales;
        this.llamadasLargaDistancia = llamadasLargaDistancia;
        this.llamadasCelular = llamadasCelular;
        this.minutosLocales = minutosLocales;
        this.minutosLargaDistancia = minutosLargaDistancia;
        this.minutosCelular = minutosCelular;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLlamadasLocales() {
        return llamadasLocales;
    }

    public void setLlamadasLocales(int llamadasLocales) {
        this.llamadasLocales = llamadasLocales;
    }

    public int getLlamadasLargaDistancia() {
        return llamadasLargaDistancia;
    }

    public void setLlamadasLargaDistancia(int llamadasLargaDistancia) {
        this.llamadasLargaDistancia = llamadasLargaDistancia;
    }

    public int getLlamadasCelular() {
        return llamadasCelular;
    }

    public void setLlamadasCelular(int llamadasCelular) {
        this.llamadasCelular = llamadasCelular;
    }

    public int getMinutosLocales() {
        return minutosLocales;
    }

    public void setMinutosLocales(int minutosLocales) {
        this.minutosLocales = minutosLocales;
    }

    public int getMinutosLargaDistancia() {
        return minutosLargaDistancia;
    }

    public void setMinutosLargaDistancia(int minutosLargaDistancia) {
        this.minutosLargaDistancia = minutosLargaDistancia;
    }

    public int getMinutosCelular() {
        return minutosCelular;
    }

    public void setMinutosCelular(int minutosCelular) {
        this.minutosCelular = minutosCelular;
    }
    public int calcularCostoTotal() {
        return (minutosLocales * tarifa_local) + (minutosLargaDistancia * tarifa_largaDistancia) + (minutosCelular * tarifa_celular);
    }
    public cabinaTelefonica(int id) {
        this.id = id;
    }

    public int getTotalMinutos() {
        return minutosLocales + minutosLargaDistancia + minutosCelular;
    }

    public int getTotalLlamadas() {
        return llamadasLocales + llamadasLargaDistancia + llamadasCelular;
    }

    public void registrarLlamada(String tipo, int minutos) {
        switch (tipo.toLowerCase()) {
            case "local":
                llamadasLocales++;
                minutosLocales += minutos;
                break;
            case "larga distancia":
                llamadasLargaDistancia++;
                minutosLargaDistancia += minutos;
                break;
            case "celular":
                llamadasCelular++;
                minutosCelular += minutos;
                break;
            default:
                System.out.println("Tipo de llamada no válido.");
        }
    }
    public void mostrarInformacion() {
        System.out.println("Cabina #" + id);
        System.out.println("Llamadas locales: " + llamadasLocales + "\n Minutos: " + minutosLocales + "\nCosto: " + (minutosLocales * tarifa_local));
        System.out.println("Llamadas larga distancia: " + llamadasLargaDistancia + "\nMinutos: " + minutosLargaDistancia + "\nCosto: " + (minutosLargaDistancia * tarifa_largaDistancia));
        System.out.println("Llamadas celular: " + llamadasCelular + "\nMinutos: " + minutosCelular + "\nCosto: " + (minutosCelular * tarifa_celular));
        System.out.println("Costo total: " + calcularCostoTotal() + "\n");
    }



    public void reiniciarCabina() {
        llamadasLocales = 0;
        llamadasLargaDistancia = 0;
        llamadasCelular = 0;
        minutosLocales = 0;
        minutosLargaDistancia = 0;
        minutosCelular = 0;
    }

}