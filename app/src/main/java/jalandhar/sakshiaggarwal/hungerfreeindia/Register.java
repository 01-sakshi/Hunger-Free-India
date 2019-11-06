package jalandhar.sakshiaggarwal.hungerfreeindia;

public class Register {
    public String type;
    public String name;
    public String address;
    public String state;
    public String city;
    public String phone;
    public String email;
    public String pass;
    public String id;

    public Register()
    {

    }


    public Register(String type, String name, String address, String state, String city, String phone) {
        this.type = type;
        this.name = name;
        this.address = address;
        this.state = state;
        this.city = city;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Register{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
