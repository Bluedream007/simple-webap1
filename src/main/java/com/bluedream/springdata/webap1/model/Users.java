package com.bluedream.springdata.webap1.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "t_users")
public class Users {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Size(min = 3, max = 20)
    private String name;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Role> roles;

    public Users() {
    }

    public Users(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


}
