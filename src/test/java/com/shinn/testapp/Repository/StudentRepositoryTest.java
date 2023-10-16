package com.shinn.testapp.Repository;

import com.shinn.testapp.Model.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckWhenStudentExistsByEmail() {
        // give
        String email = "phamtanlambe@gmail.com";
        Student student = new Student(email, "Lam Pham", "Quang Nam");
        underTest.save(student);

        // when
        boolean expected = underTest.existsByEmail(email);

        // then
        assertThat(expected).isTrue();
    }

    @Test
    void itShouldCheckWhenStudentDoesNotExistsByEmail() {
        // give
        String email = "phamtanlambe@gmail.com";

        // when
        boolean expected = underTest.existsByEmail(email);

        // then
        assertThat(expected).isFalse();
    }
}