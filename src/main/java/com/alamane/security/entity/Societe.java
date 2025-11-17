package com.alamane.security.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="societes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Societe {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String raisonSociale;
    @Column(unique = true)
    private String ice;
    private String telephone;
    private String adresse;
    @OneToMany(mappedBy = "societe")
    private List<User> users;
}
