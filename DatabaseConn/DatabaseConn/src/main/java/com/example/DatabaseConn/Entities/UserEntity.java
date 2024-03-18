package com.example.DatabaseConn.Entities;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "users")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserEntity {
    // To set the properties of the userEntity
    //Create the attribute of the userEntity class
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;
}
