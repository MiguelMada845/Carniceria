/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carniceria;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Carne {
    private String nombre;
    private double precioPorKilo;
    private double cantidadDisponible; // en kilos

    public Carne(String nombre, double precioPorKilo, double cantidadDisponible) {
        this.nombre = nombre;
        this.precioPorKilo = precioPorKilo;
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioPorKilo() {
        return precioPorKilo;
    }

    public double getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(double cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
}

class Inventario {
    private Map<String, Carne> carnes = new HashMap<>();

    public void agregarCarne(String nombre, double precioPorKilo, double cantidadDisponible) {
        Carne nuevaCarne = new Carne(nombre, precioPorKilo, cantidadDisponible);
        carnes.put(nombre, nuevaCarne);
    }

    public boolean actualizarCantidad(String nombre, double cantidad) {
        Carne carne = carnes.get(nombre);
        if (carne != null) {
            if (carne.getCantidadDisponible() >= cantidad) {
                carne.setCantidadDisponible(carne.getCantidadDisponible() - cantidad);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No hay suficiente cantidad de " + nombre + " en el inventario.");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Carne no encontrada en el inventario.");
            return false;
        }
    }

    public void solicitarCarne(String nombre, double cantidad) {
        Carne carne = carnes.get(nombre);
        if (carne != null) {
            carne.setCantidadDisponible(carne.getCantidadDisponible() + cantidad);
            JOptionPane.showMessageDialog(null, "Se han solicitado " + cantidad + " kg de " + nombre + ". Inventario actualizado.");
        } else {
            JOptionPane.showMessageDialog(null, "Carne no encontrada en el inventario.");
        }
    }

    public void mostrarInventario() {
        StringBuilder inventario = new StringBuilder("Inventario:\n");
        for (Carne carne : carnes.values()) {
            inventario.append("Nombre: ").append(carne.getNombre()).append(", Precio por Kilo: $")
                    .append(carne.getPrecioPorKilo()).append(", Cantidad Disponible: ")
                    .append(carne.getCantidadDisponible()).append(" kg\n");
        }
        JOptionPane.showMessageDialog(null, inventario.toString());
    }

    public double obtenerPrecio(String nombre) {
        Carne carne = carnes.get(nombre);
        if (carne != null) {
            return carne.getPrecioPorKilo();
        } else {
            JOptionPane.showMessageDialog(null, "Carne no encontrada en el inventario.");
            return -1;
        }
    }
}

class Venta {
    private String nombreCarne;
    private double cantidadVendida;
    private double total;

    public Venta(String nombreCarne, double cantidadVendida, double precioPorKilo) {
        this.nombreCarne = nombreCarne;
        this.cantidadVendida = cantidadVendida;
        this.total = cantidadVendida * precioPorKilo;
    }

    public String getNombreCarne() {
        return nombreCarne;
    }

    public double getCantidadVendida() {
        return cantidadVendida;
    }

    public double getTotal() {
        return total;
    }
}

class SistemaVentas {
    private ArrayList<Venta> ventas = new ArrayList<>();

    public void registrarVenta(String nombreCarne, double cantidad, double precioPorKilo) {
        Venta nuevaVenta = new Venta(nombreCarne, cantidad, precioPorKilo);
        ventas.add(nuevaVenta);
    }

    public void mostrarVentas() {
        StringBuilder ventasStr = new StringBuilder("Ventas:\n");
        for (Venta venta : ventas) {
            ventasStr.append("Carne: ").append(venta.getNombreCarne()).append(", Cantidad Vendida: ")
                    .append(venta.getCantidadVendida()).append(" kg, Total: $").append(venta.getTotal()).append("\n");
        }
        JOptionPane.showMessageDialog(null, ventasStr.toString());
    }
}

class Proveedor {
    private String nombre;
    private String contacto;

    public Proveedor(String nombre, String contacto) {
        this.nombre = nombre;
        this.contacto = contacto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContacto() {
        return contacto;
    }
}

class Empleado {
    private String nombre;
    private String rol;
    private double salario;

    public Empleado(String nombre, String rol, double salario) {
        this.nombre = nombre;
        this.rol = rol;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return rol;
    }

    public double getSalario() {
        return salario;
    }
}

class Gestion {
    private ArrayList<Proveedor> proveedores = new ArrayList<>();
    private ArrayList<Empleado> empleados = new ArrayList<>();

    public void agregarProveedor(String nombre, String contacto) {
        Proveedor nuevoProveedor = new Proveedor(nombre, contacto);
        proveedores.add(nuevoProveedor);
    }

    public void mostrarProveedores() {
        StringBuilder proveedoresStr = new StringBuilder("Proveedores:\n");
        for (Proveedor proveedor : proveedores) {
            proveedoresStr.append("Proveedor: ").append(proveedor.getNombre()).append(", Contacto: ").append(proveedor.getContacto()).append("\n");
        }
        JOptionPane.showMessageDialog(null, proveedoresStr.toString());
    }

    public void agregarEmpleado(String nombre, String rol, double salario) {
        Empleado nuevoEmpleado = new Empleado(nombre, rol, salario);
        empleados.add(nuevoEmpleado);
    }

    public void mostrarEmpleados() {
        StringBuilder empleadosStr = new StringBuilder("Empleados:\n");
        double nominaTotal = 0;
        for (Empleado empleado : empleados) {
            empleadosStr.append("Empleado: ").append(empleado.getNombre()).append(", Rol: ").append(empleado.getRol()).append(", Salario: $").append(empleado.getSalario()).append("\n");
            nominaTotal += empleado.getSalario();
        }
        empleadosStr.append("Nómina Total: $").append(nominaTotal);
        JOptionPane.showMessageDialog(null, empleadosStr.toString());
    }
}

public class Main {
    private static Inventario inventario = new Inventario();
    private static SistemaVentas sistemaVentas = new SistemaVentas();
    private static Gestion gestion = new Gestion();

    public static void main(String[] args) {
        agregarDatosIniciales();

        JFrame frame = new JFrame("Sistema de Gestión de Carnicería");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuCarnes = new JMenu("Carnes");
        JMenuItem menuVaca = new JMenuItem("Carnes de Vaca");
        JMenuItem menuPollo = new JMenuItem("Carnes de Pollo");

        menuVaca.addActionListener(e -> mostrarMenuCarnesVaca());
        menuPollo.addActionListener(e -> mostrarMenuCarnesPollo());

        menuCarnes.add(menuVaca);
        menuCarnes.add(menuPollo);
        menuBar.add(menuCarnes);

        JMenu menuEmpleados = new JMenu("Empleados");
        JMenuItem asignarTareas = new JMenuItem("Asignación de Tareas");
        JMenuItem agregarEmpleado = new JMenuItem("Agregar Empleado");

        asignarTareas.addActionListener(e -> gestion.mostrarEmpleados());
        agregarEmpleado.addActionListener(e -> agregarNuevoEmpleado());

        menuEmpleados.add(asignarTareas);
        menuEmpleados.add(agregarEmpleado);
        menuBar.add(menuEmpleados);

        JMenu menuVentas = new JMenu("Ventas");
        JMenuItem registrarVenta = new JMenuItem("Registrar Venta");

        registrarVenta.addActionListener(e -> registrarVenta());

        menuVentas.add(registrarVenta);
        menuBar.add(menuVentas);

        JMenu menuInventario = new JMenu("Inventario");
        JMenuItem mostrarInventario = new JMenuItem("Mostrar Inventario");
        JMenuItem solicitarCarne = new JMenuItem("Solicitar Carne");

        mostrarInventario.addActionListener(e -> inventario.mostrarInventario());
        solicitarCarne.addActionListener(e -> solicitarCarne());

        menuInventario.add(mostrarInventario);
        menuInventario.add(solicitarCarne);
        menuBar.add(menuInventario);

        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }

    private static void agregarDatosIniciales() {
        // Agregar carnes de vaca
        inventario.agregarCarne("Ribeye (Entrecot)", 90000, 100);
        inventario.agregarCarne("Solomillo (Filet Mignon)", 110000, 80);
        inventario.agregarCarne("Costillas de Res", 45000, 150);
        inventario.agregarCarne("Asado de Tira", 70000, 120);
        inventario.agregarCarne("Pecho (Brisket)", 45000, 130);
        inventario.agregarCarne("Paleta", 35000, 140);
        inventario.agregarCarne("Aguja", 30000, 160);
        inventario.agregarCarne("Hígado", 20000, 170);
        inventario.agregarCarne("Riñones", 15000, 180);
        inventario.agregarCarne("Lengua", 25000, 110);
        inventario.agregarCarne("Corazón", 20000, 120);
        inventario.agregarCarne("Mollejas", 45000, 100);

        // Agregar carnes de pollo
        inventario.agregarCarne("Pechuga sin Piel y sin Hueso", 25000, 200);
        inventario.agregarCarne("Filete de Pechuga", 30000, 180);
        inventario.agregarCarne("Muslo Entero", 10000, 250);
        inventario.agregarCarne("Contramuslo", 15000, 220);
        inventario.agregarCarne("Pierna Entera", 10000, 240);
        inventario.agregarCarne("Pernil (Pata)", 10000, 230);
        inventario.agregarCarne("Alitas Enteras", 10000, 210);
        inventario.agregarCarne("Mollejas de Pollo", 15000, 200);
        inventario.agregarCarne("Corazón de Pollo", 10000, 190);
        inventario.agregarCarne("Hígado de Pollo", 7000, 260);

        // Agregar empleados iniciales
        gestion.agregarEmpleado("Dani Peralta", "Carnicero", 1600000);
        gestion.agregarEmpleado("Miguel Pérez", "Carnicero", 1600000);
        gestion.agregarEmpleado("Mónica Vélez", "Cajera", 1300000);
        gestion.agregarEmpleado("Rosa Ortega", "Cajera", 1300000);
        gestion.agregarEmpleado("Pedro Gómez", "Camionero", 1500000);
    }

    private static void mostrarMenuCarnesVaca() {
        String mensaje = "Carnes de Vaca:\n";
        mensaje += "1. Ribeye (Entrecot): $90,000\n";
        mensaje += "2. Solomillo (Filet Mignon): $110,000\n";
        mensaje += "3. Costillas de Res: $45,000\n";
        mensaje += "4. Asado de Tira: $70,000\n";
        mensaje += "5. Pecho (Brisket): $45,000\n";
        mensaje += "6. Paleta: $35,000\n";
        mensaje += "7. Aguja: $30,000\n";
        mensaje += "8. Hígado: $20,000\n";
        mensaje += "9. Riñones: $15,000\n";
        mensaje += "10. Lengua: $25,000\n";
        mensaje += "11. Corazón: $20,000\n";
        mensaje += "12. Mollejas: $45,000\n";
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void mostrarMenuCarnesPollo() {
        String mensaje = "Carnes de Pollo:\n";
        mensaje += "1. Pechuga sin Piel y sin Hueso: $25,000\n";
        mensaje += "2. Filete de Pechuga: $30,000\n";
        mensaje += "3. Muslo Entero: $10,000\n";
        mensaje += "4. Contramuslo: $15,000\n";
        mensaje += "5. Pierna Entera: $10,000\n";
        mensaje += "6. Pernil (Pata): $10,000\n";
        mensaje += "7. Alitas Enteras: $10,000\n";
        mensaje += "8. Mollejas de Pollo: $15,000\n";
        mensaje += "9. Corazón de Pollo: $10,000\n";
        mensaje += "10. Hígado de Pollo: $7,000\n";
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void agregarNuevoEmpleado() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del nuevo empleado:");
        String rol = JOptionPane.showInputDialog("Ingrese el rol del nuevo empleado:");
        String salarioStr = JOptionPane.showInputDialog("Ingrese el salario del nuevo empleado:");
        double salario = Double.parseDouble(salarioStr);

        gestion.agregarEmpleado(nombre, rol, salario);
        JOptionPane.showMessageDialog(null, "Nuevo empleado agregado: " + nombre);
    }

    private static void registrarVenta() {
        String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");

        ArrayList<Venta> ventasCliente = new ArrayList<>();

        boolean agregarMas = true;

        while (agregarMas) {
            mostrarMenuCarnesVaca();
            mostrarMenuCarnesPollo();

            String tipoCarne = JOptionPane.showInputDialog("Ingrese el tipo de carne (vaca/pollo):").toLowerCase();
            String nombreCarne = JOptionPane.showInputDialog("Ingrese el nombre de la carne:");
            String cantidadStr = JOptionPane.showInputDialog("Ingrese la cantidad en kilos:");
            double cantidad = Double.parseDouble(cantidadStr);

            double precioPorKilo = inventario.obtenerPrecio(nombreCarne);
            if (precioPorKilo == -1) return;

            if (inventario.actualizarCantidad(nombreCarne, cantidad)) {
                Venta venta = new Venta(nombreCarne, cantidad, precioPorKilo);
                ventasCliente.add(venta);
                sistemaVentas.registrarVenta(nombreCarne, cantidad, precioPorKilo);
            }

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea agregar otra carne?", "Agregar Carne", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.NO_OPTION) {
                agregarMas = false;
            }
        }

        double totalCompra = 0;
        StringBuilder detalleCompra = new StringBuilder("Factura:\nCliente: " + nombreCliente + "\n");

        for (Venta venta : ventasCliente) {
            detalleCompra.append("Carne: ").append(venta.getNombreCarne()).append(", Cantidad: ")
                    .append(venta.getCantidadVendida()).append(" kg, Total: $").append(venta.getTotal()).append("\n");
            totalCompra += venta.getTotal();
        }

        double iva = totalCompra * 0.19;
        double totalConIva = totalCompra + iva;

        detalleCompra.append("Total sin IVA: $").append(totalCompra).append("\n");
        detalleCompra.append("IVA: 19% (").append(iva).append(")\n");
        detalleCompra.append("Total con IVA: $").append(totalConIva).append("\n");

        JOptionPane.showMessageDialog(null, detalleCompra.toString());

        String pagoStr = JOptionPane.showInputDialog("Ingrese el monto dado por el cliente:");
        double pagoCliente = Double.parseDouble(pagoStr);
        double cambio = pagoCliente - totalConIva;

        if (cambio < 0) {
            JOptionPane.showMessageDialog(null, "El monto dado por el cliente es insuficiente.");
            return;
        }

        detalleCompra.append("Pago del Cliente: $").append(pagoCliente).append("\n");
        detalleCompra.append("Cambio: $").append(cambio).append("\n");

        JOptionPane.showMessageDialog(null, detalleCompra.toString());
    }

    private static void solicitarCarne() {
        String[] opciones = {"Vaca", "Pollo"};
        int tipoCarne = JOptionPane.showOptionDialog(null, "¿Qué tipo de carne desea solicitar?", "Solicitar Carne", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        String tipoCarneStr = (tipoCarne == 0) ? "Vaca" : "Pollo";
        String nombreCarne = JOptionPane.showInputDialog("Ingrese el nombre de la carne de " + tipoCarneStr + " que desea solicitar:");
        String cantidadStr = JOptionPane.showInputDialog("Ingrese la cantidad en kilos a solicitar:");
        double cantidadSolicitada = Double.parseDouble(cantidadStr);

        inventario.solicitarCarne(nombreCarne, cantidadSolicitada);
    }
}







