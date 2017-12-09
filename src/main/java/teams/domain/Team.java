package teams.domain;

import java.util.Set;

public class Team {
    private String name;
    private String location;
    private String mascott;

    private Set<Player> players;

    public Team() {
        super();
    }

    public Team(String name, String location, Set<Player> players) {
        this(name, location, "", players);
    }

    public Team(String name, String location, String mascott, Set<Player> players) {
        this();
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
