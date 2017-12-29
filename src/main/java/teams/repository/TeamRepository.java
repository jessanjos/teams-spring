package teams.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import teams.domain.Team;

import java.util.List;
import java.util.UUID;

public interface TeamRepository extends MongoRepository<Team, UUID> {

    Team findByName(String name);
    List<Team> findAll();
    Team deleteByName(String name);
}
