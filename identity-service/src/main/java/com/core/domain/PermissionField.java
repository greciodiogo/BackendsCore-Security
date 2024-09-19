package com.core.domain;


import jakarta.persistence.*;
import lombok.*;

@Table(name="permission_fields")
@Entity(name="permission_fields")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PermissionField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String slug;
    private Boolean is_deleted;
}
