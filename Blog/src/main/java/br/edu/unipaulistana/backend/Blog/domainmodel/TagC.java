package br.edu.unipaulistana.backend.Blog.domainmodel;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "TBL_TAGS")
public class TagC {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    private @Getter @Setter UUID id;

    @Column(name = "Name", nullable = false)
    private @Getter @Setter String name;

    @ManyToMany(mappedBy = "tagCs")
    private @Getter @Setter Set<Post> posts;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TagC tagC = (TagC) o;
        return Objects.equals(id, tagC.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
