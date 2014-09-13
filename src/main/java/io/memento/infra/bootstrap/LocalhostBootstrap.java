package io.memento.infra.bootstrap;

import io.memento.infra.repository.bookmark.BookmarkRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@Profile("localhost")
public class LocalhostBootstrap extends ApplicationBootstrap {

    @Inject
    private BookmarkRepository bookmarkRepository;

    @Value("${mail.message.to}")
    private String mailTo;

    @Override
    void bootstrap() {
    }

}
