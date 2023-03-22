package org.example.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
// к какой таблице будет привязан этот класс
@Table(name = "rule")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Rule {
    @EqualsAndHashCode.Include
    @Id
    //стратегия генерациии id нового для конкретной сущности
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

}
