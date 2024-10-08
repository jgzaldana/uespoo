package com.mycompany.cg22079.poo.guia02;

public class FrozenByAir extends FrozenProduct {
    private double nitrogenPercentage;
    private double oxygenPercentage;
    private double carbonDioxidePercentage;
    private double waterVapourPercentage;

    public FrozenByAir(int id, String name, String lotNumber, String packagingDate, double recommendedTemp,
                       double nitrogenPercentage, double oxygenPercentage, double carbonDioxidePercentage, double waterVapourPercentage) {
        super(id, name, lotNumber, packagingDate, recommendedTemp);
        this.nitrogenPercentage = nitrogenPercentage;
        this.oxygenPercentage = oxygenPercentage;
        this.carbonDioxidePercentage = carbonDioxidePercentage;
        this.waterVapourPercentage = waterVapourPercentage;
    }

    @Override
    public void displayInfo() {
        System.out.println("==** PRODUCTOS CONGELADOS POR AIRE **==");
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getName());
        System.out.println("Lote: " + getLotNumber());
        System.out.println("Fecha de Envasado: " + packagingDate);
        System.out.println("Temperatura Recomendada: " + recommendedTemp + "°C");
        System.out.println("Composición del Aire:");
        System.out.println(" - Nitrógeno: " + nitrogenPercentage + "%");
        System.out.println(" - Oxígeno: " + oxygenPercentage + "%");
        System.out.println(" - Dióxido de Carbono: " + carbonDioxidePercentage + "%");
        System.out.println(" - Vapor de Agua: " + waterVapourPercentage + "%");
        System.out.println("-------------------------");
    }
}
