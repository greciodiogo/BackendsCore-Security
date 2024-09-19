package com.core.domain;

import jakarta.persistence.*;
import lombok.*;

@Table(name="role_user")
@Entity(name="role_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class RoleUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

      @ManyToOne
    @JoinColumn(name="role_id", referencedColumnName = "id")
    private Role role_id;

      @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user_id;

}
