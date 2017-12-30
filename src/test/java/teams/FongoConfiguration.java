package teams;

import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@ComponentScan
@Profile("fongo")
public class FongoConfiguration extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "fongo-test-db";
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new Fongo("Fongo").getMongo();
    }

}