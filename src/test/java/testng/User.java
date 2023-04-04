package testng;

import lombok.Getter;
import lombok.Setter;
import lombok.*; // imports all methods from Lombok library;


@Getter
@Setter
@Data // contains all constructors and methods from Lombok library!;
public class User {

    private String name;

    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHi(){
        System.out.println("Hello from " + name);
    }

    public void login(String username, String password) {
        System.out.println("login");
    }
}
