package olutopas.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author ninbarlu
 */

@Entity
public class User {

    private String name;
    
    @Id
    private Integer id;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }

    
}
