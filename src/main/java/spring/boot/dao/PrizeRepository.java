package spring.boot.dao;

import org.springframework.data.repository.CrudRepository;
import spring.boot.bo.Prize;

//CrudRepository takes the <object, primary key datatype>
public interface PrizeRepository extends CrudRepository<Prize, Integer> {
}
