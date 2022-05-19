package in.vaibhav.springbootmongodb.repository;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import in.vaibhav.springbootmongodb.model.Wolf;

@Repository
public interface WolfRepository extends MongoRepository<Wolf, String>{
@Query
Optional<Wolf> findByWolf(String wolf);
}