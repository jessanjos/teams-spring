package teams.domain;

public class Player {

    private Long id;
    private String name;
    private String position;

    public Player() {
        super();
    }

    public Player(String name, String position) {
        this();
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }
}
