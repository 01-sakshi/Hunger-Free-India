package jalandhar.sakshiaggarwal.hungerfreeindia;

public class Rest {
    public String email;
    public String id;
    public String password;
    public String name;
    public String city;
    public String phone;

    public Rest()
    {

    }

    public Rest(String email, String id, String password, String name, String city, String phone) {
        this.email = email;
        this.id = id;
        this.password = password;
        this.name = name;
        this.city = city;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Rest{" + "email='" + email + '\'' + ", id='" + id + '\'' + ", password='" + password + '\'' + ", name='" + name + '\'' + ", city='" + city + '\'' + ", phone='" + phone + '\'' + '}';
    }
}
