package br.com.alura.mvc.mudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.Users;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<Users, String> {

	Users findByUsername(String username);
}
