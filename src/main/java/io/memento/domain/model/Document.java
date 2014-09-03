package io.memento.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@JsonIgnoreProperties({"new", "owner"})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType = DiscriminatorType.STRING)
public abstract class Document extends PersistableEntity {

    /*
     * ATTRIBUTES
     */

    @ManyToOne(fetch=FetchType.LAZY)
    private Account owner;

    @Column(nullable = true, length = 1024)
    private String title;

    @Lob
    @Column(nullable = true, length = Integer.MAX_VALUE)
    private String content;

    /*
     * GETTERS & SETTERS
     */

    public abstract String getType();

   public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }
}
