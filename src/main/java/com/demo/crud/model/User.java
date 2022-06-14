package com.demo.crud.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.github.dozermapper.core.Mapping;

@Data
@NoArgsConstructor
public class User {
    @Mapping("name")
    private String name;

    @Mapping("username")
    private String username;

    @Mapping("email")
    private String email;

    @Mapping("phonenumber")
    private String phonenumber;

    @Mapping("website")
    private String website;
}
