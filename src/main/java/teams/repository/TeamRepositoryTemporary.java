package teams.repository;

import org.springframework.stereotype.Component;
import teams.domain.Player;
import teams.domain.Team;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Component
public class TeamRepositoryTemporary {

    private List<Team> teams;

    public TeamRepositoryTemporary() {
        teams = new ArrayList<>();

        init();
    }

    private void init() {

        teams.add(new Team(UUID.randomUUID(), "California", "Peanuts", new HashSet<Player>() {{
            add(new Player("Charlie Brown", "pitcher"));
            add(new Player("Snoopy", "shortstop"));
        }}));

        teams.add(new Team(UUID.randomUUID(), "Oklahoma", "ScoobyDoo", new HashSet<Player>() {{
            add(new Player("Scooby", "pitcher"));
            add(new Player("Salsicha", "shortstop"));
        }}));
    }

    public List<Team> findAll() {
        return teams;
    }

    public Team save(Team team) {
        teams.add(team);

        return teams.contains(team) ? team : null;
    }

    public Team findByName(String name) {
        for (Team team : teams) {
            if (team.getName().equals(name)) {
                return team;
            }
        }

        return null;
    }

    public boolean deleteByName(String name) {
        return teams.remove(findByName(name));
    }
}
