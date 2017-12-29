package teams.domain;

import org.springframework.data.annotation.Id;

import java.util.Set;
import java.util.UUID;

public class Team {

    @Id
    private UUID id;
    private String name;
    private String location;
    private String mascott;

    private Set<Player> players;

    public Team() {
        super();
    }

    public Team(UUID id, String name, String location, Set<Player> players) {
        this(id, name, location, "", players);
    }

    public Team(UUID id, String name, String location, String mascott, Set<Player> players) {
        this();
        this.id = id;
        this.name = name;
        this.location = location;
        this.players = players;
        this.mascott = mascott;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getMascott() {
        return mascott;
    }

    public Set<Player> getPlayers() {
        return players;
    }
}
