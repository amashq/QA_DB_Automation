package ru.tinkoff.hibernate.test.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "animal")
public class Animal {
    @Id
    private int id;

    @Column(name = "\"name\"")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "\"type\"")
    private int type;

    @Column(name = "sex")
    private int sex;

    @Column(name = "place")
    private int place;

    public final int getId() {
        return id;
    }

    public final String getName() {
        return name;
    }

    public final int getAge() {
        return age;
    }

    public final int getPlace() {
        return place;
    }

    public final int getSex() {
        return sex;
    }

    public final int getType() {
        return type;
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

    public final void setSex(final int sex) {
        this.sex = sex;
    }

    public final void setType(final int type) {
        this.type = type;
    }

    public final void setPlace(final int place) {
        this.place = place;
    }
}
