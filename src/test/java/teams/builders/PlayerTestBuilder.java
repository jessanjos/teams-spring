package teams.builders;

import teams.domain.Player;

public class PlayerTestBuilder {
    private String name = "Mickey";
    private String position = "sleep";

    public PlayerTestBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PlayerTestBuilder withPosition(String position) {
        this.position = position;
        return this;
    }

    public Player build() {
        return new Player(name, position);
    }
}
