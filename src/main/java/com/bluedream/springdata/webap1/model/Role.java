package com.bluedream.springdata.webap1.model;

import javax.persistence.*;

@Entity
@Table(name = "t_roles")
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;

    //Getter and Setters removed for brevity

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}