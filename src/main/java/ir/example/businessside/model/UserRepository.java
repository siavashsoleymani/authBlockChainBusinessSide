package ir.example.businessside.model;

import ir.example.businessside.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLid(String lid);
}
