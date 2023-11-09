package com.forza.forzafit.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="registros")
@Data
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",length = 30, nullable = false)
    private String name;


    @Column(name = "cantidad",length =40, nullable = false)
    private String cantidad;

    @Column(name = "date")
    private Date date;

}
