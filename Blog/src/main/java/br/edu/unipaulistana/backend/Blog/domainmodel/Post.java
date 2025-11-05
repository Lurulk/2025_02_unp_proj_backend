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
@Table(name = "TBL_POSTS")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    private @Getter @Setter UUID id;

    @Column(name = "Title", nullable = false)
    private @Getter @Setter String title;

    @Column(name = "Content", nullable = false)
    private @Getter @Setter String content;

    @ManyToOne
    private @Getter @Setter User user;

    @ManyToMany
    @JoinTable(name = "TBL_POSTS_TAGS", joinColumns = @JoinColumn(name = "Post_Id"), inverseJoinColumns = @JoinColumn(name = "Tag_Id"))
    private @Getter @Setter Set<TagC> tagCs;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
