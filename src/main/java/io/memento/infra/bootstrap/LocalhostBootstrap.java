package io.memento.infra.bootstrap;

import org.springframework.context.annotation.Profile;

import javax.inject.Named;

@Named
@Profile("localhost")
public class LocalhostBootstrap extends ApplicationBootstrap {

    @Override
    void bootstrap() {
    }

}
