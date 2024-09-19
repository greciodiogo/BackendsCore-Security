package com.core.domain;

import jakarta.persistence.*;
import lombok.*;

// import java.util.List;

@Table(name="roles")
@Entity(name="roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String slug;
  
    // @ManyToMany(mappedBy = "roles")
    // private List<User> users;

    // @ManyToMany
    // @JoinTable(
    //     name = "permission_role",
    //     joinColumns = @JoinColumn(name = "role_id"),
    //     inverseJoinColumns = @JoinColumn(name = "permission_id")
    // )
    // private List<Permission> permissions;
}
