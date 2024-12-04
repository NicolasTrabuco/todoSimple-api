package com.nicolastrabuco.todosimple.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = Task.TABLE_NAME)
public class Task {
    public static final String TABLE_NAME = "task";

    //Cria um valor aleatorio unico
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    //Referencia o user com o seu id
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    @Column(name = "description", length = 255, nullable = false)
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String description;

    public Task(){}

    public Task(Long id, User user, String description) {
        this.id = id;
        this.user = user;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription(String description) {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public Task id(Long id){
        setId(id);
        return this;
    }

    public Task user(User user){
        setUser(user);
        return this;
    }

    public Task description(String description){
        setDescription(description);
        return this;
    }

    @Override
    public boolean equals(Object objeto) {
        if (objeto == this){
            return true;
        }
        if (!(objeto instanceof Task)){
            return false;
        }
        if (objeto == null) {
            return false;
        }
        Task other = (Task) objeto;

        if (this.id == null){
            if(other.id != null){
                return false;
            } else if (!this.id.equals(other.id)){
                return false;
            }
        }
        return Objects.equals(this.id, other.id)
                && Objects.equals(this.user, other.user)
                && Objects.equals(this.description, other.description);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());

        return result;
    }
}
