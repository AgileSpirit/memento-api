package io.memento.domain.model;

public enum DocumentType {

    BOOKMARK(Values.BOOKMARK), //
    NOTE(Values.NOTE), //
    FILE(Values.FILE), //
    TODO_LIST(Values.TODO_LIST);

    private final String value;

    private DocumentType(String value) {
        this.value = value;
    }

    public static class Values {
        public static final String BOOKMARK = "BOOKMARK";
        public static final String NOTE = "NOTE";
        public static final String FILE = "FILE";
        public static final String TODO_LIST = "TODO_LIST";
    }

}
