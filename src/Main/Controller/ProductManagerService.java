package Main.Controller;

import Main.Model.Orden;
import Main.Model.Producto;
import Main.Model.Usuario;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static Main.Controller.ProductManagerImpl.*;

@Path("/orders")
@Singleton //Lo necesitamos para decirle a jerser que use una unica instancia

public class ProductManagerService {

    //Testing purposes "/products"
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    //1-Listado de productos ordenado (ascendiente) por precio
    @GET
    @Path("/products/getAllSortedByCost")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> getAllProductsSortedByCostService() {
        return getInstance().getAllServedProductsSortedByCost();
    }

    //2-Realizar un pedido (de diferentes productos y diferentes cantidades) por parte de un usuario identificado
    @POST
    @Path("/{id}/makeOrder")
    public Boolean makeOrderService(@PathParam("id") int userId, List<Producto> products) {
        return getInstance().makeOrder(userId, products);
    }

    //3-Servir pedido. Los servicios se realizan en orden de llegadas.
    @GET
    @Path("/serve")
    public boolean serveOrder()  {
        return getInstance().serveOrder();
    }

    //4-Listado de pedidos de un usuario que ya hayan sido realizados
    @GET
    @Path("/products/{id}/getAllUserOrders")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Orden> getAllServedUserOrders(@PathParam("id") int userId){
        return getInstance().getAllServedUserOrders(userId);
    }

    //5-Listado de productos ordenado (descendiente) por número de ventas
    @GET
    @Path("/products/getAllSortedBySales")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> getAllSortedBySalesService(){
        return getInstance().getAllProductsSortedByNoSales();
    }

    //6-El usuario se registra
    @POST
    @Path("/userLogin")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario loginService(Usuario u) {
        return getInstance().login(u);
    }
}
