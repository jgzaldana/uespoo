package com.mycompany.cg22079.poo.guia02;

public class Product {
    protected int id;
    protected String name;
    protected String type;
    protected String lotNumber;

    public Product(int id, String name, String type, String lotNumber) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.lotNumber = lotNumber;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    // Meetodo para mostrar informacion basica **- se aplica el polimorfismo -**
    public void displayInfo() {
        System.out.println("==** PRODUCTO " + type.toUpperCase() + " **==");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + name);
        System.out.println("Lote: " + lotNumber);
    }
}
