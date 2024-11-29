package org.figueroa.appFacturas.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {
    private int folio;
    private String descripcion;
    private Date fecha;

    private Cliente cliente;

    private ItemFactura[] items;

    private int IndiceItems;

    public static final int MAX_ITEM = 2;

    private static int ultimoFolio;
    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.items = new ItemFactura[MAX_ITEM];
        this.folio = ++ultimoFolio;
        this.fecha = new Date();
    }

    public int getFolio() {
        return folio;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemFactura[] getItems() {
        return items;
    }

    public void setItems(ItemFactura[] items) {
        this.items = items;
    }

    public int getIndiceItems() {
        return IndiceItems;
    }

    public void addItemFacturas(ItemFactura item){
        if (IndiceItems < MAX_ITEM) {
            this.items[IndiceItems++] = item;
        }
    }

    public float calcularTotal(){
        float total = 0.0f;


        for (ItemFactura item :this.items  ) {
            if (items == null){
                continue;
            }
            total += item.CalcularImporte();


        }
        return total;
    }

    public String generarDetalle(){
        StringBuilder sb =new StringBuilder("Facturas N : ");
        sb.append(folio)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\t NIT : ")
                .append(this.cliente.getNIT())
                .append(this.descripcion)
                .append("\n");

         SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        sb.append("Fecha de Emision: ")
                .append(df.format(this.fecha))
                .append("\n")
                .append("\n#\t Nombre:\tCant.\tTotal\n");

        for (ItemFactura item:this.items) {
            if (item == null){
                continue;
            }

           /*
           Se comenta porque ya se tiene el toString() en ItemFactura y producto se deja solo item
           sb.append(item.getProducto().getCodigo())
                    .append("\t")
                    .append(item.getProducto().getNombre())
                    .append(item.getProducto().getPrecio())
                    .append(item.getCantidad())
                    .append(item.CalcularImporte())
                    .append("\n");*/
            sb.append(item)
                    .append("\n");
        }

        sb.append("\nGran Total: ")
                .append(calcularTotal());

        return sb.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }
}

