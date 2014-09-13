package io.memento.domain.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = DocumentType.Values.NOTE)
public class Note extends Document {

    @Override
    public String getType() {
        return DocumentType.Values.NOTE;
    }

}
