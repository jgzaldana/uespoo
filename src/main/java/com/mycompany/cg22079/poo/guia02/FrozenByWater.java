package com.mycompany.cg22079.poo.guia02;

// Esta es una subclase de Frozen product


public class FrozenByWater extends FrozenProduct {
    private double waterSalinity;

    public FrozenByWater(int id, String name, String lotNumber, String packagingDate, double recommendedTemp, double waterSalinity) {
        super(id, name, lotNumber, packagingDate, recommendedTemp);
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
}
