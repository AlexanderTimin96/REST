package ru.netology.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class User {
    @Size(min = 2, max = 20)
    @NotBlank
    private final String user;
    @Size(min = 5, max = 20)
    @NotBlank
    private final String password;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user1 = (User) o;
        return Objects.equals(user, user1.user) && Objects.equals(password, user1.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, password);
    }

    @Override
    public String toString() {
        return user;
    }
}
