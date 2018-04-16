package Main.Model;

public class Producto {

    //Declaro los atributos PRIVADOS
    private static int num = 0;     //Cantidad de usuarios registrados
    private int id;
    private String name;
    private int cost;

    //Constructores (para inicializar con estas variables)
    public Producto() {
    }

    public Producto(String name, int cost) {
        this.id = ++num;
        this.name = name;
        this.cost = cost;
    }

    //Getters and Setters
    public int getId() {
        return id;
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
