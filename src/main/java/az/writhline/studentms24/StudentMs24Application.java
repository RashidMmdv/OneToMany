package az.writhline.studentms24;

import az.writhline.studentms24.model.Address;
import az.writhline.studentms24.model.Phone;
import az.writhline.studentms24.model.Student;
import az.writhline.studentms24.repository.AddressRepository;
import az.writhline.studentms24.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class StudentMs24Application {

    private final StudentRepository studentRepository;
    private final AddressRepository addressRepository;


    public static void main(String[] args) {
        SpringApplication.run(StudentMs24Application.class, args);
    }

    @Component
    class MyCommandLineRunner implements CommandLineRunner {

        @Transactional
        @Override
        public void run(String... args) throws Exception {

            Student student = studentRepository.findById(4L).get();
            student.getPhones().removeIf((phone)->phone.getNumber().equals("+994 50 636 67 60"));
            studentRepository.save(student);
            log.info("Student is {}", student);

//            student.getPhones().add(Phone.builder()
//                    .number("+994 50 636 67 60")
//                    .student(student)
//                    .build());
//
//            student.getPhones().add(Phone.builder()
//                    .number("+994 50 111 67 60")
//                    .student(student)
//                    .build());
//            student.getPhones().add(Phone.builder()
//                    .number("+994 50 333 67 60")
//                    .student(student)
//                    .build());
//            student.getPhones().add(Phone.builder()
//                    .number("+994 50 444 67 60")
//                    .student(student)
//                    .build());


        }
    }

//


    public void create(){
        Address address = Address.builder()
                .city("Baku")
                .country("AZ")
                .street("C. Cabbarli 45")
                .build();
        Student student = Student.builder()
                .name("Rashid")
                .age(21)
                .active(true)
                .address(address)
                .build();
        studentRepository.save(student);
    }
}
