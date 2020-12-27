package com.person.identity.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
public class IDCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "person_id")
    @MapsId
    private Person person;

    @Column(unique = true, nullable = false)
    private String code = UUID.randomUUID().toString();
}
