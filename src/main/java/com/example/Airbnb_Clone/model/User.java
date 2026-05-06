package com.example.Airbnb_Clone.model;

import com.example.Airbnb_Clone.model.enums.Gender;
import com.example.Airbnb_Clone.model.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Table(name = "users_details")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true, nullable = true)
    private String email;
    @Column(nullable = true)
    private String password;

    private String name;
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    Set<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority>  getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_"+role.name()))
                .collect(Collectors.toSet());
    }
    @Override
    public String getUsername(){
        return email;
    }
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof User))
            return false;
        return Objects.equals(id, ((User)o).id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
