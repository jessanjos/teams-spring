package teams.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StubController {

    @RequestMapping(value="/bla", method = RequestMethod.GET)
    public Map<String, String> getInvestmentPortfolio(@RequestParam("clientCode") String accountNumber){
        return new HashMap<String, String>(){{
            put("bla", "bla");
            put("ble", "ble");
            put("clientCode", accountNumber);
        }};
    }
}
