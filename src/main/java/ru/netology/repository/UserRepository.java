package ru.netology.repository;

import org.springframework.stereotype.Repository;
import ru.netology.model.User;
import ru.netology.model.authorities.Authorities;

import java.util.*;

@Repository
public class UserRepository {
    private final Map<User, List<Authorities>> authorizedUsers = new HashMap<>();

    {
        List<Authorities> allAuthorities = new ArrayList<>();
        allAuthorities.add(Authorities.READ);
        allAuthorities.add(Authorities.DELETE);
        allAuthorities.add(Authorities.WRITE);

        List<Authorities> onlyRead = new ArrayList<>();
        onlyRead.add(Authorities.READ);

        User userAlex = new User("Alex", "12345");
        User userOleg = new User("Oleg", "54321");

        authorizedUsers.put(userAlex, allAuthorities);
        authorizedUsers.put(userOleg, onlyRead);
    }

    public List<Authorities> getUserAuthorities(User user) {
        if (authorizedUsers.containsKey(user)) {
            return authorizedUsers.get(user);
        }

        return Collections.emptyList();
    }
}
