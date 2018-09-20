package chat.spring.repository;

import org.springframework.stereotype.Repository;
import chat.spring.entity.User;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface LoginRepository extends CrudRepository<User, Long> {

	//SELECT id,pass FROM user WHERE user.id = id AND user.pass = pass; 
    User findByIdEqualsAndPassEquals(int id,int pass);

}