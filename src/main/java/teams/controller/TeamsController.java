package teams.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import teams.domain.Team;
import teams.service.TeamService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TeamsController {

    @Autowired
    private TeamService teamService;

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public List<Team> getTeams() {

        return teamService.getTeams();
    }

    @RequestMapping(value = "/teams/{name}", method = RequestMethod.GET)
    public Team getTeamByName(@PathVariable String name) {

        return teamService.getTeamByName(name);
    }

    @RequestMapping(value = "/teams", method = RequestMethod.POST)
    public Team createTeam(@RequestBody Team teamToCreate) {
        return teamService.createTeam(teamToCreate);
    }

    @RequestMapping(value = "/teams/{name}", method = RequestMethod.DELETE)
    public Map<String, String> deleteTeamByName(@PathVariable String name) {

        long isTeamDeleted = teamService.deleteTeam(name);

        if (isTeamDeleted == 0) {
            return new HashMap<String, String>() {{
                put("message", "Team could not be deleted");
            }};
        }
        return new HashMap<String, String>() {{
            put("message", "team deleted");
        }};
    }
}
