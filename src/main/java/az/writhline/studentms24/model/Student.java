package az.writhline.studentms24.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
     String name;
     Boolean active;
     Integer age;

     @OneToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "address_id")
     Address address;

     @OneToMany(cascade = CascadeType.ALL,mappedBy = "student")
     Set<Phone> phones = new HashSet<>();
}
