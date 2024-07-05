package az.writhline.studentms24.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
public class Phone {
    @Id
    Long id;
    String number;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    Student student;
}
