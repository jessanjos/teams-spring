package teams.service;

import org.springframework.stereotype.Service;
import teams.domain.Player;
import teams.domain.Team;
import teams.repository.TeamRepository;

import java.util.*;

@Service
public class TeamService {
    private TeamRepository teamRepository;

    TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team getTeamByName(String name) {
        return teamRepository.findByName(name);
    }

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    public Team createTeam(Map<String, Object> teamToCreate) {
        String name = (String) teamToCreate.get("name");
        String location = (String) teamToCreate.get("location");
        String mascott = (String) teamToCreate.get("mascott");
        Set<Player> players = new HashSet<>();

        for (Map<String, String> player : (List<Map<String, String>>) teamToCreate.get("players")) {
            String playerName = player.get("name");
            String playerPosition = player.get("position");

            players.add(new Player(playerName, playerPosition));
        }

        return teamRepository.save(new Team(name, location, mascott, players));
    }
}
