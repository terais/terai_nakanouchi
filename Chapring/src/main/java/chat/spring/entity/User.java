package chat.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private int pass;
    
    @Column(nullable = false)
    private String name;
    

    // JPA requirement
    protected User() {}

    public User(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getPass() {
        return pass;
    }
    
    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public void setName(String name) {
        this.name = name;
    }
}