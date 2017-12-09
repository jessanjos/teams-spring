package teams.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import teams.domain.Team;
import teams.service.TeamService;

import java.util.List;
import java.util.Map;

@RestController
public class TeamsController {

    @Autowired
    private TeamService teamService;

    @RequestMapping(value="/teams", method = RequestMethod.GET)
    public List<Team> getTeams() {

        return teamService.getTeams();
    }

    @RequestMapping(value="/teams/{name}", method = RequestMethod.GET)
    public Team getTeamByName(@PathVariable String name) {

        return teamService.getTeamByName(name);
    }

    @RequestMapping(value="/teams/{name}", method = RequestMethod.POST)
    public Team createTeam(@RequestBody Map<String, Object> teamToCreate) {
        return teamService.createTeam(teamToCreate);
    }
}
