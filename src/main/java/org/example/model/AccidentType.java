package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "type")
public class AccidentType {
    @EqualsAndHashCode.Include
    // указывает на id таблицы Type
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;


}
