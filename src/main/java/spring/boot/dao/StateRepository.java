package spring.boot.dao;

import org.springframework.data.repository.CrudRepository;
import spring.boot.bo.State;

//CrudRepository takes the <object, primary key datatype>
public interface StateRepository extends CrudRepository<State, Integer> {
}
