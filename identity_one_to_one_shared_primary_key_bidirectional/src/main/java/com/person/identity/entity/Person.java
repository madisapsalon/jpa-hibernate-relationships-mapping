package com.person.identity.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private IDCard idCard;

    public Person(String name, IDCard idCard) {
        this.name = name;
        this.idCard = idCard;
        this.idCard.setPerson(this);
    }
}
