package Main.Model;

import java.util.ArrayList;
import java.util.List;

public class Orden {
    //Declaro los atributos PRIVADOS
    private List<Producto> products;
    private int userId;

    //Constructores (para inicializar con estas variables)
    public Orden(int userId, boolean served, List<Producto> products) {
        this.userId = userId;
        this.products = products;
    }

    public Orden () {
        this.products = new ArrayList<>();
    }

    //Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Producto> getProducts() {
        return products;
    }

    public void setProducts(List<Producto> products) {
        this.products = products;
    }

    public Producto getProduct(int id) {
        return this.products.get(id);
    }

    public void setProduct(Producto product) {
        this.products.add(product);
    }
}
