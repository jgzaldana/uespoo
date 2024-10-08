package com.mycompany.cg22079.poo.guia02;

import java.time.format.DateTimeFormatter;

public class FrozenByNitrogen extends FrozenProduct {
    private String freezingMethod;
    private int exposureTime;

    public FrozenByNitrogen(String name, String lotNumber, String packagingDate, double recommendedTemp, String freezingMethod, int exposureTime) {
        super(ProductManager.nextId++, name, lotNumber, packagingDate, recommendedTemp);
        this.freezingMethod = freezingMethod;
        this.exposureTime = exposureTime;
    }

    @Override
    public void displayInfo() {
        System.out.println("==** PRODUCTOS CONGELADOS POR NITRÓGENO **==");
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getName());
        System.out.println("Lote: " + getLotNumber());
        System.out.println("Fecha de Envasado: " + packagingDate);
        System.out.println("Temperatura Recomendada: " + recommendedTemp + "°C");
        System.out.println("Método de Congelación: " + freezingMethod);
        System.out.println("Tiempo de Exposición: " + exposureTime + " segundos");
        System.out.println("-------------------------");
    }
     public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "ID: " + id + ", Nombre: " + name + ", Lote: " + lotNumber +
               ", Fecha de Envasado: " + packagingDate +
               ", Temperatura Recomendada: " + recommendedTemp+ "°C" + 
                ", Método de Congelación: " + freezingMethod + 
               ", Tiempo de Exposición: " + exposureTime + " segundos";
    }
}
