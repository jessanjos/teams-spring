package teams.service;

import org.junit.Before;
import org.junit.Test;
import teams.domain.Team;
import teams.repository.TeamRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TeamServiceTest {
    private TeamService teamService;

    @Before
    public void setUp() throws Exception {
        teamService = new TeamService(new TeamRepository());
    }

    @Test
    public void getCaliforniaTeamByName() throws Exception {
        assertThat(teamService.getTeamByName("California").getName(), is(equalTo("California")));
        assertThat(teamService.getTeamByName("California").getLocation(), is(equalTo("Peanuts")));
        assertThat(teamService.getTeamByName("California").getPlayers().size(), is(equalTo(2)));
    }

    @Test
    public void getTeamsList() throws Exception {
        assertThat(teamService.getTeams().size(), is(equalTo(2)));
    }

    @Test
    public void shouldCreateTeamBasedOnMap() throws Exception {
        Map<String, Object> teamToCreate = new HashMap<String, Object>() {{
            put("name", "Florida");
            put("location", "Universe");
            put("mascott", "Lion");
            put("players", new ArrayList<Map<String, String>>() {{
                add(new HashMap<String, String>() {{
                    put("name", "Steven");
                    put("position", "pitcher");
                }});
                add(new HashMap<String, String>() {{
                    put("name", "Garnet");
                    put("position", "catcher");
                }});
            }});
        }};

        Team newTeam = teamService.createTeam(teamToCreate);

        assertThat(newTeam.getName(), is(equalTo("Florida")));
        assertThat(newTeam.getLocation(), is(equalTo("Universe")));
        assertThat(newTeam.getMascott(), is(equalTo("Lion")));
        assertThat(newTeam.getPlayers().size(), is(equalTo(2)));
    }
}