package teams.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import teams.domain.Player;
import teams.domain.Team;
import teams.repository.TeamRepositoryFake;

import java.util.HashSet;
import java.util.UUID;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamServiceTest {

    private TeamService teamService;

    @Before
    public void setUp() throws Exception {
        teamService = new TeamService(new TeamRepositoryFake());
    }

    @Test
    public void getCaliforniaTeamByName() throws Exception {
        assertThat(teamService.getTeamByName("California").getName(), is(equalTo("California")));
        assertThat(teamService.getTeamByName("California").getLocation(), is(equalTo("Peanuts")));
        assertThat(teamService.getTeamByName("California").getPlayers().size(), is(equalTo(2)));
    }

    @Test
    public void getTeamsList() throws Exception {
        assertThat(teamService.getTeams().size(), is(equalTo(3)));
    }

    @Test
    public void shouldCreateTeamBasedOnMap() throws Exception {
        Team teamToCreate = new Team(UUID.randomUUID(), "Florida", "Universe", "Lion",
                new HashSet<Player>() {{
                    add(new Player("Steve", "pitcher"));
                    add(new Player("Garnet", "catcher"));
                }});

        Team newTeam = teamService.createTeam(teamToCreate);

        assertThat(newTeam.getName(), is(equalTo("Florida")));
        assertThat(newTeam.getLocation(), is(equalTo("Universe")));
        assertThat(newTeam.getMascott(), is(equalTo("Lion")));
        assertThat(newTeam.getPlayers().size(), is(equalTo(2)));
    }

    @Test
    public void shouldDeleteTeamByName() throws Exception {
        teamService.deleteTeam("California");

        assertThat(teamService.getTeams().size(), is(equalTo(2)));
    }
}