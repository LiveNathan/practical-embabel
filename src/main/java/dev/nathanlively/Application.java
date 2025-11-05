package dev.nathanlively;

import com.embabel.agent.config.annotation.EnableAgents;
import com.embabel.agent.config.annotation.LoggingThemes;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAgents(loggingTheme = LoggingThemes.STAR_WARS)
@SpringBootApplication
@NpmPackage(value = "@fontsource/mountains-of-christmas", version = "4.5.0")
@Theme(value = "practical-embabel", variant = Lumo.DARK)
public class Application implements AppShellConfigurator {

    static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
