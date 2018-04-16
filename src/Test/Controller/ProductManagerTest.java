package Controller;

import Main.Model.Orden;
import Main.Model.Producto;
import Main.Model.Usuario;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static Main.Controller.ProductManagerImpl.getInstance;

public class ProductManagerTest {//Realizo los 4 métodos

    // Inicializo las Variables
    private final static Logger logger = Logger.getLogger(ProductManagerTest.class);

    private Usuario usr1;
    private Usuario usr2;

    private Producto item1;
    private Producto item2;

    Orden userOrder1;
    Orden userOrder2;

    private List<Producto> products;
    private List<Producto> products2;

    //1-método setUp que inicializa la estructura de datos
    @Before //Junit4
    public void setUp() throws Exception {

        usr1 = new Usuario ("Marc");
        usr2 = new Usuario("Gerard");

        item1 = new Producto("Sandwich",3);
        item2 = new Producto("Coffee", 1);

        products = new ArrayList<>();
        products2 = new ArrayList<>();

        products.add(item1);
        products.add(item2);

        products2.add(item1);
        products2.add(item1);
        products2.add(item1);

        userOrder1 = new Orden(usr1.getId(),false, products);
        userOrder2 = new Orden(usr2.getId(),false, products2);

        // usr_2 has no items
    }

    //2-método tearDown que libera los recursos
    @After //Junit4
    public void tearDown(){

        usr1 = null;
        usr2 = null;
        item1 = null;
        item2 = null;
        products = null;
        products2 = null;
        getInstance().getOrders().clear();
        getInstance().getServedOrders().clear();
    }

    //3-método de test para realizar un pedido
    @Test
    public void makeOrderTest(){
        logger.info("Starting makeOrderTest...");
        Assert.assertTrue(getInstance().makeOrder(usr1.getId(),products));
        logger.info("Finishing setOrderTest...");
    }

    //4-método de test para servir un pedido
    @Test
    public void serveOrderTest() {
        logger.info("Starting serveOrderTest()...");
        getInstance().makeOrder(usr2.getId(), products2);
        getInstance().serveOrder();
        Assert.assertEquals(0, getInstance().getOrders().size());
        logger.info("Ending serveOrderTest()...");
    }
}
