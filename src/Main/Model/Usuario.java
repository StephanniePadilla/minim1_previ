package Main.Model;

public class Usuario {

    //Declaro los atributos PRIVADOS
    private static int num = 0;     //Cantidad de usuarios registrados
    private int id;
    private String username;

    private String password;

    //Constructores (para inicializar con estas variables)
    public Usuario () {
    }

    public Usuario(String username) {
        this.id = ++num;
        this.username = username;
    }

    public Usuario(String username, String password) {
        this.id = ++num;
        this.username = username;
        this.password = password;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
