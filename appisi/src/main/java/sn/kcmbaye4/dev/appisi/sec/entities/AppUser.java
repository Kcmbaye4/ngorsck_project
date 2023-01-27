package sn.kcmbaye4.dev.appisi.sec.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class AppUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private boolean active;
    @ManyToMany(mappedBy = "appUsers", fetch = FetchType.EAGER)
    private List<AppRole> appRoles = new ArrayList<>();
}
