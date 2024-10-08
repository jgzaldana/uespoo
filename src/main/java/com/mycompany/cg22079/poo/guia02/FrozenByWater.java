package com.mycompany.cg22079.poo.guia02;

// Esta es una subclase de Frozen product

import java.time.format.DateTimeFormatter;



public class FrozenByWater extends FrozenProduct {
    private double waterSalinity;

    public FrozenByWater(String name, String lotNumber, String packagingDate, double recommendedTemp, double waterSalinity) {
        super(ProductManager.nextId++,, name, lotNumber, packagingDate, recommendedTemp);
        this.waterSalinity = waterSalinity;
    }

    public double getWaterSalinity() {
        return waterSalinity;
    }

    @Override
    public void displayInfo() {
        System.out.println("==** PRODUCTOS CONGELADOS POR AGUA **==");
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getName());
        System.out.println("Lote: " + getLotNumber());
        System.out.println("Fecha de Envasado: " + packagingDate);
        System.out.println("Temperatura Recomendada: " + recommendedTemp + "°C");
        System.out.println("Salinidad del Agua: " + waterSalinity + " gramos de sal/litro");
        System.out.println("-------------------------");
    }
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "ID: " + id + ", Nombre: " + name + ", Lote: " + lotNumber +
               ", Fecha de Envasado: " + packagingDate +
               ", Temperatura Recomendada: " + recommendedTemp+ "°C" + 
                ", Salinidad del Agua: " + waterSalinity + " gramos de sal/litro";
    }
}
