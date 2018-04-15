package Main.Controller;

import Main.Model.*;

import java.util.List;

public interface ProductManager { //Me hace las 5 funciones:

    Usuario login(Usuario u);

    //1-Listado de productos ordenado (ascendiente) por precio
    List<Producto> getAllServedProductsSortedByCost();

    //2-Realizar un pedido (de diferentes productos y diferentes cantidades) por parte de un usuario identificado
    boolean makeOrder (int userId, List<Producto> products);

    //3-Servir pedido. Los servicios se realizan en orden de llegadas.
    boolean serveOrder();

    //4-Listado de pedidos de un usuario que ya hayan sido realizados
    List<Orden> getAllServedUserOrders(int userId);

    //5-Listado de productos ordenado (descendiente) por número de ventas
    List<Producto> getAllProductsSortedByNoSales();

}
