import org.figueroa.appFacturas.modelo.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNIT(125354);
        cliente.setNombre("Jose");

        Scanner scanner = new Scanner(System.in);
        System.out.printf("Ingrese la descripcion de la factura");
        String desc = scanner.nextLine();
        Factura factura = new Factura(desc,cliente);

        Producto producto;
        String nombre;
        float precio;
        int cantidadProducto;

        System.out.println();

        for (int i = 0; i < 2; i++){
        producto = new Producto();
            System.out.print("Ingrese producto Numero: "+ producto.getCodigo() + ": ");
            nombre = scanner.nextLine(); //next solo toma el primer parametro
            producto.setNombre(nombre);

            System.out.print("Ingrese el precio:" );
            //precio = scanner.nextFloat(); se elimina para optimizar codigo
            producto.setPrecio(scanner.nextFloat());

            System.out.print("Ingrese cantidad: ");
            //cantidadProducto = scanner.nextInt();

            ItemFactura item = new ItemFactura(scanner.nextInt(), producto);
            factura.addItemFacturas(item);

            System.out.println();
            scanner.nextLine();
        }

        //System.out.println(factura.generarDetalle());
        System.out.println(factura);

    }
}