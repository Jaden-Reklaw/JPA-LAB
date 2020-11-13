package spring.boot.dao;

import org.springframework.data.repository.CrudRepository;
import spring.boot.bo.Game;

//CrudRepository takes the <object, primary key datatype>
public interface GameRepository extends CrudRepository<Game, Integer> {
}
