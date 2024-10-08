package com.mycompany.cg22079.poo.guia02;
// Clase abstracta

public abstract class FrozenProduct extends Product {
    protected String packagingDate;
    protected double recommendedTemp;

    public FrozenProduct(int id, String name, String lotNumber, String packagingDate, double recommendedTemp) {
        super(id, name, "Congelado", lotNumber);
        this.packagingDate = packagingDate;
        this.recommendedTemp = recommendedTemp;
    }

    // Metodos de getters y setters

    public String getPackagingDate() {
        return packagingDate;
    }

    public double getRecommendedTemp() {
        return recommendedTemp;
    }

    @Override
    public abstract void displayInfo(); // queda abstracto y debera se implementados por las subclases
}
