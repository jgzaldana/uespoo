package com.mycompany.cg22079.poo.guia02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FreshProduct extends Product {
   // private static int nextId = 1;
    private int id;
    //private String entryDate;
    //private String expiryDate;
     private LocalDate entryDate;
    private LocalDate expiryDate;

    public FreshProduct(int id, String name, String lotNumber, LocalDate entryDate, LocalDate expiryDate) {
        super(id, name, "Fresco", lotNumber);
        this.entryDate = entryDate;
        this.expiryDate = expiryDate;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public void displayInfo() {
        System.out.println("==** PRODUCTOS FRESCOS **==");
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getName());
        System.out.println("Lote: " + getLotNumber());
        System.out.println("Fecha de Ingreso: " + entryDate);
        System.out.println("Fecha de Caducidad: " + expiryDate);
    }
    
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "ID: " + id + ", Nombre: " + name + ", Lote: " + lotNumber +
               ", Fecha de ingreso: " + entryDate.format(formatter) +
               ", Fecha de caducidad: " + expiryDate.format(formatter)+
                ", Tipo: "+ "Fresco";
    }
}
