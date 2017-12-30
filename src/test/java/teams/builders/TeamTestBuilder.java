package teams.builders;

import teams.domain.Player;
import teams.domain.Team;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class TeamTestBuilder {
    private UUID id = UUID.randomUUID();
    private String name = "Orlando";
    private String location = "Disney";
    private String mascott = "Pluto";
    private Set<Player> players = new HashSet<>();

    public TeamTestBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public TeamTestBuilder withLocation(String location) {
        this.location = location;
        return this;
    }

    public TeamTestBuilder withMascott(String mascott) {
        this.mascott = mascott;
        return this;
    }

    public TeamTestBuilder withPlayers(Set<Player> players) {
        this.players = players;
        return this;
    }

    public Team build() {
        return new Team(id, name, location, mascott, players);
    }
}
