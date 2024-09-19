package com.core.domain;


import jakarta.persistence.*;
import lombok.*;

@Table(name="permissions")
@Entity(name="permissions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String slug;
    private Boolean is_deleted;

    // @ManyToMany(mappedBy = "permissions")
    // private List<Role> roles;
}
