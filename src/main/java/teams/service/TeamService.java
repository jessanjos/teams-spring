package teams.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teams.domain.Team;
import teams.repository.TeamRepository;

import java.util.List;
import java.util.UUID;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Team getTeamByName(String name) {
        return teamRepository.findByName(name);
    }

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    public Team createTeam(Team teamToCreate) {
        Team team = new Team(UUID.randomUUID(),
                teamToCreate.getName(),
                teamToCreate.getLocation(),
                teamToCreate.getMascott(),
                teamToCreate.getPlayers());

        return teamRepository.save(team);
    }

    public Team deleteTeam(String name) {
        return teamRepository.deleteByName(name);
    }
}
