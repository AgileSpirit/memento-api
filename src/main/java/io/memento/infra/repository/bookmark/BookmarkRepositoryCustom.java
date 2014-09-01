package io.memento.infra.repository.bookmark;

import io.memento.domain.model.Bookmark;

public interface BookmarkRepositoryCustom {

    long count(String pattern);

    Iterable<Bookmark> findLastBookmarksOrderByCreationDateDesc(int number);

    Iterable<Bookmark> findBookmarks(int offset, int size);

    Iterable<Bookmark> findBookmarks(String pattern, int offset, int size);
}
