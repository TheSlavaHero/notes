package com.example.notesStorage.addingNote;

import com.example.notesStorage.BaseEntity;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notes")
public class Note implements BaseEntity<String> {

    private static final long serialVersionUID = 4044714827569083806L;

    @Id
    @NotNull
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Size(min = 8, max = 100, message = "shout be more then 8 and not more that 100")
    private String id;

    @NotNull
//    @Pattern(regexp = "regular")
    @Size(min = 5, max = 100, message = "shout be more then 5 and not more that 100")
    private String name;

    @NotNull
//    @Pattern(regexp = "20 rowes,regular")
    private String message;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private AccessType accessType;

    public String getId() {
        //return UUID.randomUUID().toString();
        return id;
    }

    public Note(String name, String message, AccessType accessType) {
        this.name = name;
        this.message = message;
        this.accessType = accessType;
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
