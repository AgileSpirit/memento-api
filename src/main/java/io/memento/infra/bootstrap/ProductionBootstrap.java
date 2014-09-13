package io.memento.infra.bootstrap;

import org.springframework.context.annotation.Profile;

import javax.inject.Named;

@Named
@Profile("production")
public class ProductionBootstrap extends ApplicationBootstrap {

    @Override
    void bootstrap() {
    }
}
