package com.mycompany.cg22079.poo.guia02;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.stream.Collectors;

// Atributos

public class ProductManager {
    private ArrayList<Product> products; // Enlista los productos
    private Scanner scanner;             // Lee la entrada del usuario
    private DateTimeFormatter formatter; // Formato para fechas
    private PrintWriter writer;
    public static int nextId = 1; 

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
            
            System.out.print("Nombre: ");
            String name = scanner.nextLine();
            System.out.print("Lote: ");
            String lotNumber = scanner.nextLine();

            LocalDate entryDate = obtenerFecha("Fecha de ingreso (dd/mm/aaaa): ");
            if (entryDate.isAfter(LocalDate.now())) {
                System.out.println("Error: La fecha de ingreso no puede ser futura.");
                i--;
                nextId--;
                continue;
            }

            LocalDate expiryDate = obtenerFecha("Fecha de caducidad (dd/mm/aaaa): ");
            if (expiryDate.isBefore(entryDate)) {
                System.out.println("Error: La fecha de caducidad no puede ser anterior a la fecha de ingreso.");
                i--;
                nextId--;
                continue;
            }

            FreshProduct product = new FreshProduct(name, lotNumber, entryDate, expiryDate);
            addProduct(product);
        }
    }

    // Metodo para agregar productos refrigerados
    public void addRefrigeratedProducts(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("Ingrese los datos del producto refrigerado #" + (i + 1));
            
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

            
            RefrigeratedProduct product = new RefrigeratedProduct(name, lotNumber, packagingDate.format(formatter), recommendedTemp, originCountry);
            addProduct(product);
        }
    }

    // Metodo para agregar productos congelados por agua
    public void addFrozenByWaterProducts(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("Ingrese los datos del producto congelado por agua #" + (i + 1));
           
            System.out.print("Nombre: ");
            String name = scanner.nextLine();
            System.out.print("Lote: ");
            String lotNumber = scanner.nextLine();

            LocalDate packagingDate = obtenerFecha("Fecha de envasado (dd/mm/aaaa): ");
            if (packagingDate.isAfter(LocalDate.now())) {
                System.out.println("Error: La fecha de envasado no puede ser futura.");
                i--;
                nextId--;
                continue;
            }

            double recommendedTemp = obtenerDouble("Temperatura recomendada en centígrados: ");
            double waterSalinity = obtenerDouble("Salinidad del agua (gramos de sal por litro): ");

            FrozenByWater product = new FrozenByWater(name, lotNumber, packagingDate.format(formatter), recommendedTemp, waterSalinity);
            addProduct(product);
        }
    }

    // Metodo para agregar productos congelados por aire
    public void addFrozenByAirProducts(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("Ingrese los datos del producto congelado por aire #" + (i + 1));
            System.out.print("Nombre: ");
            String name = scanner.nextLine();
            System.out.print("Lote: ");
            String lotNumber = scanner.nextLine();

            LocalDate packagingDate = obtenerFecha("Fecha de envasado (dd/mm/aaaa): ");
            if (packagingDate.isAfter(LocalDate.now())) {
                System.out.println("Error: La fecha de envasado no puede ser futura.");
                i--;
                nextId--;
                continue;
            }

            double recommendedTemp = obtenerDouble("Temperatura recomendada en centígrados: ");
            double nitrogenPercentage = obtenerDouble("% de nitrógeno: ");
            double oxygenPercentage = obtenerDouble("% de oxígeno: ");
            double carbonDioxidePercentage = obtenerDouble("% de dióxido de carbono: ");
            double waterVapourPercentage = obtenerDouble("% de vapor de agua: ");

            FrozenByAir product = new FrozenByAir(name, lotNumber, packagingDate.format(formatter), recommendedTemp,
                    nitrogenPercentage, oxygenPercentage, carbonDioxidePercentage, waterVapourPercentage);
                    addProduct(product);
        }
    }

    // Metodo para agregar productos congelados por nitrogeno
    public void addFrozenByNitrogenProducts(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("Ingrese los datos del producto congelado por nitrógeno #" + (i + 1));            
            System.out.print("Nombre: ");
            String name = scanner.nextLine();
            System.out.print("Lote: ");
            String lotNumber = scanner.nextLine();

            LocalDate packagingDate = obtenerFecha("Fecha de envasado (dd/mm/aaaa): ");
            if (packagingDate.isAfter(LocalDate.now())) {
                System.out.println("Error: La fecha de envasado no puede ser futura.");
                i--;
                nextId--;
                continue;
            }

            double recommendedTemp = obtenerDouble("Temperatura recomendada en centígrados: ");
            System.out.print("Método de congelación: ");
            String freezingMethod = scanner.nextLine();
            int exposureTime = obtenerEntero("Tiempo de exposición al nitrógeno (segundos): ");

            FrozenByNitrogen product = new FrozenByNitrogen(name, lotNumber, packagingDate.format(formatter), recommendedTemp, freezingMethod, exposureTime);
            addProduct(product);
        }
        
    }

    // Metodo para agregar productos envasados
    public void addPackagedProducts(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("Ingrese los datos del producto envasado #" + (i + 1));            
            System.out.print("Nombre: ");
            String name = scanner.nextLine();
            System.out.print("Lote: ");
            String lotNumber = scanner.nextLine();

            LocalDate packagingDate = obtenerFecha("Fecha de envasado (dd/mm/aaaa): ");
            if (packagingDate.isAfter(LocalDate.now())) {
                System.out.println("Error: La fecha de envasado no puede ser futura.");
                i--;
                nextId--; 
                continue;
            }

            LocalDate expiryDate = obtenerFecha("Fecha de caducidad (dd/mm/aaaa): ");
            if (expiryDate.isBefore(packagingDate)) {
                System.out.println("Error: La fecha de caducidad no puede ser anterior a la fecha de envasado.");
                i--;
                nextId--;
                continue;
            }

            System.out.print("¿Requiere refrigeración después de abierto? (si/no): ");
            boolean needsRefrigeration = scanner.nextBoolean();
            scanner.nextLine();

            PackagedProduct product = new PackagedProduct(name, lotNumber, packagingDate.format(formatter), expiryDate.format(formatter), needsRefrigeration);
            addProduct(product);
        }
    }

    // Metodo para mostrar todos los productos
    public void showAllProducts() {
    File file = new File("products.txt");  // Asumiendo que los productos están guardados en products.txt
    if (!file.exists() || file.length() == 0) {
        System.out.println("No hay productos registrados.");
        return;
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = reader.readLine()) != null) {
            Product product = parseProduct(line);
            if (product != null) {
                product.displayInfo();
                System.out.println("-------------------------");
            }
        }
    } catch (IOException e) {
        System.out.println("Error al leer el archivo: " + e.getMessage());
    }
}

    // Metodo para eliminar un producto
    public void deleteProduct(int id) {
    File file = new File("products.txt");
    if (!file.exists()) {
        System.out.println("Archivo no encontrado.");
        return;
    }

    try {
        List<String> outLines = Files.readAllLines(Paths.get("products.txt")).stream()
                                    .filter(line -> !line.contains("ID: " + id + ","))
                                    .collect(Collectors.toList());

        if (outLines.size() < Files.readAllLines(Paths.get("products.txt")).size()) {
            Files.write(Paths.get("products.txt"), outLines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Producto con ID " + id + " eliminado.");
        } else {
            System.out.println("Producto con ID " + id + " no encontrado.");
        }
    } catch (IOException e) {
        System.out.println("Error al leer o escribir en el archivo: " + e.getMessage());
    }
}

    // Metodo para modificar un producto
    public void updateProduct(int id, Scanner scanner) {
        List<String> lines;
        String productLine = null;
        int lineIndex = -1;
    
        try {
            lines = Files.readAllLines(Paths.get("products.txt"));
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).contains("ID: " + id + ",")) {
                    productLine = lines.get(i);
                    lineIndex = i;
                    break;
                }
            }
    
            if (productLine == null) {
                System.out.println("Producto con ID " + id + " no encontrado.");
                return;
            }
    
            System.out.println("Seleccione el campo que desea modificar:");
            System.out.println("1. Nombre");
            System.out.println("2. Lote");
    
            int option = obtenerEntero("Opción: ");
            String[] parts = productLine.split(", ");
            switch (option) {
                case 1:
                    System.out.print("Ingrese el nuevo nombre: ");
                    String newName = scanner.nextLine();
                    parts[1] = "Nombre: " + newName;
                    break;
                case 2:
                    System.out.print("Ingrese el nuevo número de lote: ");
                    String newLot = scanner.nextLine();
                    parts[2] = "Lote: " + newLot;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    return;
            }
    
            // Reconstruir la línea actualizada
            productLine = String.join(", ", parts);
            lines.set(lineIndex, productLine);
    
            // Escribir todas las líneas de vuelta al archivo
            Files.write(Paths.get("products.txt"), lines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Producto actualizado.");
    
        } catch (IOException e) {
            System.out.println("Error al leer o escribir en el archivo: " + e.getMessage());
        }
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

    private Product parseProduct(String line) {
        String[] parts = line.split(", ");
        if (parts.length < 5) {
            System.out.println("Error de formato en la línea: " + line);
            return null;
        }
        try {
            int id = Integer.parseInt(parts[0].split(": ")[1].trim());
            String name = parts[1].split(": ")[1].trim();
            String lotNumber = parts[2].split(": ")[1].trim();
            LocalDate entryDate = LocalDate.parse(parts[3].split(": ")[1].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            LocalDate expiryDate = LocalDate.parse(parts[4].split(": ")[1].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            
            // Aquí, se debe manejar según el tipo de producto, ej: FreshProduct, etc.
            // Deberías tener un identificador en la línea o manejarlo de acuerdo al número de partes o una clave específica
            return new FreshProduct(id, name, lotNumber, entryDate, expiryDate); // Ajustar según constructor
        } catch (NumberFormatException | DateTimeParseException e) {
            System.out.println("Error al parsear la línea: " + line + " Error: " + e.getMessage());
            return null;
        }
    }
}
