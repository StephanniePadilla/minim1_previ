package Main.Model;

public class Usuario {

    //Declaro los atributos PRIVADOS
    private int id;
    private String username;

    private String password;

    //Constructores (para inicializar con estas variables)
    public Usuario () {
    }

    public Usuario(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public Usuario(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
