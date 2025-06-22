//package com.bookStore;
//
//import com.bookStore.model.User;
//import com.bookStore.repository.UserRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.annotation.Rollback;
//
//import java.util.List;
//import java.util.Optional;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(false)
//public class UserRepositoryTests {
//    @Autowired
//    private UserRepository repo;
//
//    @Test
//    public void testAddNew() {
//        User user = new User();
//        user.setEmail("b@a.a");
//        user.setPassword("1234");
//        user.setFirstName("Ann");
//        user.setLastName("Ann");
//        User savedUser = repo.save(user);
//        Assertions.assertThat(savedUser).isNotNull();
//        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
//    }
//
//    @Test
//    public void testListAll() {
//        List<User> users = repo.findAll();
//        Assertions.assertThat(users).hasSizeGreaterThan(0);
//        for (User user : users) {
//            System.out.println(user);
//        }
//    }
//
//    @Test
//    public void testUpdate() {
//        Integer userId = 1;
//        Optional<User> optionalUser = repo.findById(userId);
//        User user = optionalUser.get();
//        user.setPassword("asd");
//        repo.save(user);
//        User updatedUser = repo.findById(userId).get();
//        Assertions.assertThat(updatedUser.getPassword()).isEqualTo("asd");
//    }
//
//    @Test
//    public void testGet() {
//        Integer userId = 3;
//        Optional<User> optionalUser = repo.findById(userId);
//        User user = optionalUser.get();
//        Assertions.assertThat(optionalUser).isPresent();
//        System.out.println(optionalUser.get());
//    }
//    @Test
//    public void testDelete(){
//        Integer userId=2;
//        repo.deleteById(userId);
//        Optional<User> optionalUser = repo.findById(userId);
//        Assertions.assertThat(optionalUser).isNotPresent();
//    }
//
//}
