package com.mycompany.cg22079.poo.guia02;

public class RefrigeratedProduct extends Product {
    private String packagingDate;
    private double recommendedTemp;
    private String countryOfOrigin;

    public RefrigeratedProduct(int id, String name, String lotNumber, String packagingDate, double recommendedTemp, String countryOfOrigin) {
        super(id, name, "Refrigerado", lotNumber);
        this.packagingDate = packagingDate;
        this.recommendedTemp = recommendedTemp;
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getPackagingDate() {
        return packagingDate;
    }

    public double getRecommendedTemp() {
        return recommendedTemp;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    @Override
    public void displayInfo() {
        System.out.println("==** PRODUCTOS REFRIGERADOS **==");
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getName());
        System.out.println("Lote: " + getLotNumber());
        System.out.println("Fecha de Envasado: " + packagingDate);
        System.out.println("Temperatura Recomendada: " + recommendedTemp + "°C");
        System.out.println("País de Origen: " + countryOfOrigin);
    }
}
