package ru.netology.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorities.Authorities;

import java.util.*;

@Repository
public class UserRepository {
    private final Map<String, Map<String, List<Authorities>>> authorizedUsers = new HashMap<>();

    {
        List<Authorities> allAuthorities = new ArrayList<>();
        allAuthorities.add(Authorities.READ);
        allAuthorities.add(Authorities.DELETE);
        allAuthorities.add(Authorities.WRITE);

        List<Authorities> onlyRead = new ArrayList<>();
        allAuthorities.add(Authorities.READ);

        Map<String, List<Authorities>> passwordAndAuthoritiesAlex = new HashMap<>();
        passwordAndAuthoritiesAlex.put("12345", allAuthorities);

        Map<String, List<Authorities>> passwordAndAuthoritiesOleg = new HashMap<>();
        passwordAndAuthoritiesOleg.put("54321", onlyRead);

        authorizedUsers.put("alex", passwordAndAuthoritiesAlex);
        authorizedUsers.put("Oleg", passwordAndAuthoritiesOleg);
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (authorizedUsers.containsKey(user)) {
            if (authorizedUsers.get(user).containsKey(password)) {
                return authorizedUsers.get(user).get(password);
            }
        }
        return Collections.emptyList();
    }
}
