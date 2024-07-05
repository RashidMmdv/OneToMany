package az.writhline.studentms24.repository;

import az.writhline.studentms24.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
