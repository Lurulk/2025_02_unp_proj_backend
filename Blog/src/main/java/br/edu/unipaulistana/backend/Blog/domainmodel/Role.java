package br.edu.unipaulistana.backend.Blog.domainmodel;

import lombok.*;

import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role {
    private @Getter @Setter Long id;
    private @Getter @Setter String bio;
    private @Getter @Setter String pictureUrl;
    private @Getter @Setter Set<User> user;
}
