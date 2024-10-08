package com.mycompany.cg22079.poo.guia02;

import java.util.Scanner;

public class PackagedProduct extends Product {
    private String packagingDate;
    private String expiryDate;
    private boolean needsRefrigeration;

    public PackagedProduct(String name, String lotNumber, String packagingDate, String expiryDate, boolean needsRefrigeration) {
        super(ProductManager.nextId++, name, "Envasado", lotNumber);
        this.packagingDate = packagingDate;
        this.expiryDate = expiryDate;
        this.needsRefrigeration = needsRefrigeration;
    }

    public String getPackagingDate() {
        return packagingDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }
    public boolean isNeedsRefrigeration() {
        return needsRefrigeration;
    }

    public String getNeedsRefrigerationAsString() {
        return needsRefrigeration ? "Sí" : "No";
    }

    // Método para capturar la entrada del usuario
    public void captureRefrigerationStatus() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Requiere refrigeración después de abierto? (Sí/No): ");
        String input = scanner.nextLine();

        // Convertir la entrada a booleano
        if (input.equalsIgnoreCase("Sí")) {
            this.needsRefrigeration = true;
        } else if (input.equalsIgnoreCase("No")) {
            this.needsRefrigeration = false;
        } else {
            System.out.println("Entrada inválida, se espera 'Sí' o 'No'.");
        }
    }

    @Override
    public void displayInfo() {
        String refrigerationStatus = getNeedsRefrigerationAsString(); 
        System.out.println("==** PRODUCTOS ENVASADOS **==");
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getName());
        System.out.println("Lote: " + getLotNumber());
        System.out.println("Fecha de Envasado: " + packagingDate);
        System.out.println("Fecha de Caducidad: " + expiryDate);
        System.out.println("Requiere Refrigeración después de abierto: " + refrigerationStatus);
       


    }

}
