package tw.cgm.integration;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tw.cgm.integration.controllers.MemberController;
import tw.cgm.integration.controllers.RelationController;
import tw.cgm.integration.dao.MemberDataDao;
import tw.cgm.integration.dao.RelationshipDao;
import tw.cgm.integration.model.MemberData;

/**
 * Project Application
 */
public class App extends Application<Config> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    private final HibernateBundle<Config> hibernateBundle =
            new HibernateBundle<Config>(MemberData.class) {
                @Override
                public DataSourceFactory getDataSourceFactory(Config configuration) {
                    return configuration.getDataSourceFactory();
                }
            };


    @Override
    public String getName() {
        return "Integration-App";
    }

    @Override
    public void initialize(Bootstrap<Config> bootstrap) {
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(
                        bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );

        bootstrap.addBundle(new AssetsBundle());
        bootstrap.addBundle(new MigrationsBundle<Config>() {
            @Override
            public DataSourceFactory getDataSourceFactory(Config configuration) {
                return configuration.getDataSourceFactory();
            }
        });
        bootstrap.addBundle(hibernateBundle);
    }

    public void run(Config config, Environment env) throws Exception {
        final MemberDataDao mDao = new MemberDataDao(hibernateBundle.getSessionFactory());
        final RelationshipDao rDao = new RelationshipDao(hibernateBundle.getSessionFactory());


        LOGGER.info("Register Integration REST API");
        env.jersey().register(new MemberController(mDao));
        env.jersey().register(new RelationController(mDao, rDao));
    }
}
