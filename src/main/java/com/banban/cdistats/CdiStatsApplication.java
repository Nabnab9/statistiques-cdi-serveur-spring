package com.banban.cdistats;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@EnableSwagger2
public class CdiStatsApplication {

    private static final Logger log = LoggerFactory.getLogger(CdiStatsApplication.class);


    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(CdiStatsApplication.class);
        Environment env = app.run(args).getEnvironment();
        logApplicationStartup(env);
    }

    private static void logApplicationStartup(Environment env) throws UnknownHostException {
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }

        log.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\t{}://localhost:{}\n\t" +
                        "External: \t{}://{}:{}\n\t" +
                        "Swagger: \t{}://{}:{}{}\n\t" +
                        "Profile(s): \t{}\n\t"+
                        "Datasource: \t{}"+
                        "\n----------------------------------------------------------"
                , env.getProperty("spring.application.name")
                , protocol
                , env.getProperty("server.port")
                , protocol
                , InetAddress.getLocalHost().getHostAddress()
                , env.getProperty("server.port")
                , protocol
                , env.getProperty("server.host")
                , env.getProperty("server.port")
                , "/swagger-ui.html"
                , env.getActiveProfiles()
                , env.getProperty("spring.datasource.url")
        );
    }
}
