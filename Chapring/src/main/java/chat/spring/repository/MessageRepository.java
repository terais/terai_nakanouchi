package chat.spring.repository;
import java.util.List;

import org.springframework.stereotype.Repository;

import chat.spring.entity.Message;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

    List<Message> findByOrderByIdDesc(Pageable pageable);

}