package io.memento.application;

import io.memento.domain.model.Note;

/**
 * User: OCTO-JBU
 * Date: 23/07/2014
 * Time: 11:11
 */
public interface NoteResource {
    Note getNote(Long id);

    Note saveNote(Note note);

    Note updateNote(Note note);

    void removeNote(Long id);
}
