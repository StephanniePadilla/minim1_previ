package Main.Controller;

import Main.Model.*;
import org.apache.log4j.Logger;


import java.util.*;



public class ProductManagerImpl implements ProductManager { //Implementada como "Singletone"

    //Declaro las variables
    private static ProductManagerImpl instance = null;
    final static Logger logger = Logger.getLogger(ProductManagerImpl.class);

    private Queue<Orden> ordenes;
    private List<Orden> servedOrdenes;

    //Singleton Pattern
    public static ProductManagerImpl getInstance() {
        if (instance == null) instance = new ProductManagerImpl();
        return instance;
    }

    //Constructors
    public ProductManagerImpl() {
        this.ordenes = new ArrayDeque<>();
        this.servedOrdenes = new ArrayList<>();
    }

    //Getters and Setters
    public Queue<Orden> getOrders() {
        return ordenes;
    }

    public List<Orden> getServedOrders() {
        return servedOrdenes;
    }

    //Public functions
    public List<Producto> getAllServedProductsSortedByCost() {
        logger.info("getAllProducts: Retreiving All user products ordered by cost...");
        return sortProductsByCost(getAllServedProducts());
    }

    public boolean makeOrder (int userId, List<Producto> products) {
        logger.info("serveOrder: Making an order...");
        this.ordenes.add(new Orden(userId, false, products));

        logger.info("serveOrder: Order sent");
        return true;
    }

    public boolean serveOrder() {
        logger.info("serveOrder: Serving an order..");

        if(!ordenes.isEmpty()) {
            this.servedOrdenes.add(this.ordenes.element());
            this.ordenes.remove();

            logger.info("serveOrder: An order has been served");
            return true;
        }
        else {
            logger.warn("serveOrder: No orders to serve");
            return false;
        }
    }

    public List<Orden> getAllServedUserOrders(int userId) {
        List<Orden> temp = new ArrayList<>();
        if (isUserOnQueue(userId)) {
            logger.info("getAllServedUserOrders: Getting all ordered products from userId: "+userId);
            for(Orden o : this.servedOrdenes) {
                if (o.getUserId() == userId)
                    temp.add(o);
            }
            logger.info("getAllServedUserOrders: Historic from userId: "+userId+" retreived");
            return temp;
        }
        else {
            logger.warn("getAllServedUserOrders: There is no historic from id: "+userId);
            return temp;
        }
    }

    public List<Producto> getAllProductsSortedByNoSales() {
        if (!servedOrdenes.isEmpty()) {
            logger.info("sortProductsByNoSales: Sorting all products by no. sales, if no null It's okay");
            return sortProductsByNoSales(getAllServedProducts());
        }
        else {
            logger.warn("sortProductsByNoSales: There are no products yet");
            return null;
        }

    }

    //Private functions
    private List<Producto> sortProductsByCost(List<Producto> products) {
        products.sort(Comparator.comparing(Producto::getCost));
        return products;
    }

    private boolean isUserOnQueue (int userId) {
        for(Orden o : servedOrdenes) {
            if(o.getUserId() == userId)
                return true;
        }
        return false;
    }

    private List<Producto> sortProductsByNoSales(List<Producto> products) {
        int noCoffee = 0;
        int noSandwiches = 0;
        List<Producto> temp = new ArrayList<>();
        for (Producto p : products) {
            switch(p.getId()) {
                case 1:
                    noCoffee++;
                    break;
                case 2:
                    noSandwiches++;
                    break;
            }
        }
        int result = Integer.compare(noCoffee, noSandwiches);
        if (result == 0) {
            for (Producto p : products) {
                if (!(temp.contains(p)))
                    temp.add(p);
            }
        }
        if (result < 0) {
            for (Producto p : products) {
                if(!(temp.contains(p)) && p.getId() ==2)
                    temp.add(p);
            }
            for (Producto p : products) {
                if(!(temp.contains(p)) && p.getId() ==1)
                    temp.add(p);
            }
        }
        if (result > 0) {
            for (Producto p : products) {
                if(!(temp.contains(p)) && p.getId() ==1)
                    temp.add(p);
            }
            for (Producto p : products) {
                if(!(temp.contains(p)) && p.getId() ==2)
                    temp.add(p);
            }
        }
        return temp;
    }

    private List<Producto> getAllServedProducts() {
        List<Producto> temp = new ArrayList<>();
        if (!servedOrdenes.isEmpty()) {
            logger.info("getAllProducts: Getting all products from:");
            for(Orden o : this.servedOrdenes) {
                temp.addAll(o.getProducts());
            }
            logger.info("getAllProducts: All products retreived");
            return temp;
        }
        else {
            logger.info("getAllProducts: There are no products that have been ordered yet");
            return temp;
        }

    }

    public Usuario login(Usuario u) {
        return u;
    }
}
