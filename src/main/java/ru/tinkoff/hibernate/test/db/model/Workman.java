package ru.tinkoff.hibernate.test.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "workman")
public class Workman {
    @Id
    private int id;

    @Column(name = "\"name\"", nullable = false)
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "\"position\"")
    private int position;

    public final int getId() {
        return id;
    }

    public final String getName() {
        return name;
    }

    public final int getAge() {
        return age;
    }

    public final int getPosition() {
        return position;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public final void setAge(final int age) {
        this.age = age;
    }

    public final void setPosition(final int position) {
        this.position = position;
    }
}
