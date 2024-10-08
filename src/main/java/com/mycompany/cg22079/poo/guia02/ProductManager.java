package com.mycompany.cg22079.poo.guia02;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

// Atributos

public class ProductManager {
    private ArrayList<Product> products; // Enlista los productos
    private Scanner scanner;             // Lee la entrada del usuario
    private DateTimeFormatter formatter; // Formato para fechas
    private PrintWriter writer;

    public ProductManager() {
        products = new ArrayList<>();
        scanner = new Scanner(System.in);
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            writer = new PrintWriter(new FileWriter("products.txt", true));  // Abrir el archivo en modo append
        } catch (IOException e) {
            System.out.println("Error al abrir o crear el archivo.");
        }
    }
    public void closeWriter() {
        if (writer != null) {
            writer.close();
        }
    }

    public void addProduct(Product product) {
        products.add(product);
        writer.println(product.toString());  // Asumiendo que cada producto tiene un método toString adecuado
        writer.flush();  // Asegurarse de que la data se escribe en el archivo
    }

    // Metodo para agregar productos frescos
    public void addFreshProducts(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("Ingrese los datos del producto fresco #" + (i + 1));
            int id = obtenerEntero("ID: ");
            System.out.print("Nombre: ");
            String name = scanner.nextLine();
            System.out.print("Lote: ");
            String lotNumber = scanner.nextLine();

            LocalDate entryDate = obtenerFecha("Fecha de ingreso (dd/mm/aaaa): ");
            if (entryDate.isAfter(LocalDate.now())) {
                System.out.println("Error: La fecha de ingreso no puede ser futura.");
                i--;
                continue;
            }

            LocalDate expiryDate = obtenerFecha("Fecha de caducidad (dd/mm/aaaa): ");
            if (expiryDate.isBefore(entryDate)) {
                System.out.println("Error: La fecha de caducidad no puede ser anterior a la fecha de ingreso.");
                i--;
                continue;
            }

            FreshProduct product = new FreshProduct(id, name, lotNumber, entryDate, expiryDate);
            addProduct(product);
        }
    }

    // Metodo para agregar productos refrigerados
    public void addRefrigeratedProducts(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("Ingrese los datos del producto refrigerado #" + (i + 1));
            int id = obtenerEntero("ID: ");
            System.out.print("Nombre: ");
            String name = scanner.nextLine();
            System.out.print("Lote: ");
            String lotNumber = scanner.nextLine();

            LocalDate packagingDate = obtenerFecha("Fecha de envasado (dd/mm/aaaa): ");
            if (packagingDate.isAfter(LocalDate.now())) {
                System.out.println("Error: La fecha de envasado no puede ser futura.");
                i--;
                continue;
            }

            double recommendedTemp = obtenerDouble("Temperatura recomendada en centígrados: ");
            System.out.print("País de origen: ");
            String originCountry = scanner.nextLine();

            
            RefrigeratedProduct product = new RefrigeratedProduct(id, name, lotNumber, packagingDate.format(formatter), recommendedTemp, originCountry);
            addProduct(product);
        }
    }

    // Metodo para agregar productos congelados por agua
    public void addFrozenByWaterProducts(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("Ingrese los datos del producto congelado por agua #" + (i + 1));
            int id = obtenerEntero("ID: ");
            System.out.print("Nombre: ");
            String name = scanner.nextLine();
            System.out.print("Lote: ");
            String lotNumber = scanner.nextLine();

            LocalDate packagingDate = obtenerFecha("Fecha de envasado (dd/mm/aaaa): ");
            if (packagingDate.isAfter(LocalDate.now())) {
                System.out.println("Error: La fecha de envasado no puede ser futura.");
                i--;
                continue;
            }

            double recommendedTemp = obtenerDouble("Temperatura recomendada en centígrados: ");
            double waterSalinity = obtenerDouble("Salinidad del agua (gramos de sal por litro): ");

            FrozenByWater product = new FrozenByWater(id, name, lotNumber, packagingDate.format(formatter), recommendedTemp, waterSalinity);
            addProduct(product);
        }
    }

    // Metodo para agregar productos congelados por aire
    public void addFrozenByAirProducts(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("Ingrese los datos del producto congelado por aire #" + (i + 1));
            int id = obtenerEntero("ID: ");
            System.out.print("Nombre: ");
            String name = scanner.nextLine();
            System.out.print("Lote: ");
            String lotNumber = scanner.nextLine();

            LocalDate packagingDate = obtenerFecha("Fecha de envasado (dd/mm/aaaa): ");
            if (packagingDate.isAfter(LocalDate.now())) {
                System.out.println("Error: La fecha de envasado no puede ser futura.");
                i--;
                continue;
            }

            double recommendedTemp = obtenerDouble("Temperatura recomendada en centígrados: ");
            double nitrogenPercentage = obtenerDouble("% de nitrógeno: ");
            double oxygenPercentage = obtenerDouble("% de oxígeno: ");
            double carbonDioxidePercentage = obtenerDouble("% de dióxido de carbono: ");
            double waterVapourPercentage = obtenerDouble("% de vapor de agua: ");

            FrozenByAir product = new FrozenByAir(id, name, lotNumber, packagingDate.format(formatter), recommendedTemp,
                    nitrogenPercentage, oxygenPercentage, carbonDioxidePercentage, waterVapourPercentage);
                    addProduct(product);
        }
    }

    // Metodo para agregar productos congelados por nitrogeno
    public void addFrozenByNitrogenProducts(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("Ingrese los datos del producto congelado por nitrógeno #" + (i + 1));
            int id = obtenerEntero("ID: ");
            System.out.print("Nombre: ");
            String name = scanner.nextLine();
            System.out.print("Lote: ");
            String lotNumber = scanner.nextLine();

            LocalDate packagingDate = obtenerFecha("Fecha de envasado (dd/mm/aaaa): ");
            if (packagingDate.isAfter(LocalDate.now())) {
                System.out.println("Error: La fecha de envasado no puede ser futura.");
                i--;
                continue;
            }

            double recommendedTemp = obtenerDouble("Temperatura recomendada en centígrados: ");
            System.out.print("Método de congelación: ");
            String freezingMethod = scanner.nextLine();
            int exposureTime = obtenerEntero("Tiempo de exposición al nitrógeno (segundos): ");

            FrozenByNitrogen product = new FrozenByNitrogen(id, name, lotNumber, packagingDate.format(formatter), recommendedTemp, freezingMethod, exposureTime);
            addProduct(product);
        }
        
    }

    // Metodo para agregar productos envasados
    public void addPackagedProducts(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("Ingrese los datos del producto envasado #" + (i + 1));
            int id = obtenerEntero("ID: ");
            System.out.print("Nombre: ");
            String name = scanner.nextLine();
            System.out.print("Lote: ");
            String lotNumber = scanner.nextLine();

            LocalDate packagingDate = obtenerFecha("Fecha de envasado (dd/mm/aaaa): ");
            if (packagingDate.isAfter(LocalDate.now())) {
                System.out.println("Error: La fecha de envasado no puede ser futura.");
                i--;
                continue;
            }

            LocalDate expiryDate = obtenerFecha("Fecha de caducidad (dd/mm/aaaa): ");
            if (expiryDate.isBefore(packagingDate)) {
                System.out.println("Error: La fecha de caducidad no puede ser anterior a la fecha de envasado.");
                i--;
                continue;
            }

            System.out.print("¿Requiere refrigeración después de abierto? (si/no): ");
            boolean needsRefrigeration = scanner.nextBoolean();
            scanner.nextLine();

            PackagedProduct product = new PackagedProduct(id, name, lotNumber, packagingDate.format(formatter), expiryDate.format(formatter), needsRefrigeration);
            addProduct(product);
        }
    }

    // Metodo para mostrar todos los productos
    public void showAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (Product product : products) {
                product.displayInfo();
                System.out.println("-------------------------");
            }
        }
    }

    // Metodo para eliminar un producto
    public void deleteProduct(int id) {
        boolean removed = products.removeIf(product -> product.getId() == id);
        if (removed) {
            System.out.println("Producto con ID " + id + " eliminado.");
        } else {
            System.out.println("Producto con ID " + id + " no encontrado.");
        }
    }

    // Metodo para modificar un producto
    public void updateProduct(int id, Scanner scanner) {
        Product productToModify = null;
        for (Product product : products) {
            if (product.getId() == id) {
                productToModify = product;
                break;
            }
        }

        if (productToModify == null) {
            System.out.println("Producto con ID " + id + " no encontrado.");
            return;
        }

        System.out.println("Seleccione el campo que desea modificar:");
        System.out.println("1. Nombre");
        System.out.println("2. Lote");

        int option = obtenerEntero("Opción: ");

        switch (option) {
            case 1:
                System.out.print("Ingrese el nuevo nombre: ");
                String newName = scanner.nextLine();
                productToModify.setName(newName);
                break;
            case 2:
                System.out.print("Ingrese el nuevo número de lote: ");
                String newLot = scanner.nextLine();
                productToModify.setLotNumber(newLot);
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        System.out.println("Producto actualizado.");
    }

    // Metodo para obtener una fecha con validacion
    private LocalDate obtenerFecha(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String dateStr = scanner.nextLine();
            try {
                LocalDate date = LocalDate.parse(dateStr, formatter);
                return date;
            } catch (DateTimeParseException e) {
                System.out.println("Error: Formato de fecha inválido. Utilice dd/MM/yyyy.");
            }
        }
    }

    // Metodo para obtener un entero con validacion
    private int obtenerEntero(String mensaje) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                scanner.nextLine(); // Consumir la línea restante
                break;
            } else {
                System.out.println("Error: Ingrese un número entero válido.");
                scanner.nextLine(); // Consumir la entrada inválida
            }
        }
        return valor;
    }

    // Metodo para obtener un double con validacion
    private double obtenerDouble(String mensaje) {
        double valor;
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextDouble()) {
                valor = scanner.nextDouble();
                scanner.nextLine(); // Consumir la línea restante
                break;
            } else {
                System.out.println("Error: Ingrese un valor numérico válido.");
                scanner.nextLine(); // Consumir la entrada inválida
            }
        }
        return valor;
    }
}
