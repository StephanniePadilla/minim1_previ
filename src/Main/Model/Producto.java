package Main.Model;

public class Producto {

    //Declaro los atributos PRIVADOS
    private int id;
    private String name;
    private int cost;

    //Constructores (para inicializar con estas variables)
    public Producto(int id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public Producto() {
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

}
