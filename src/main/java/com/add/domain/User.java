package com.add.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
@Setter
public class User {
    private String name;
    private String email;
    private Long id;
    private String url;
    private String location;
    private Boolean morningClick;
    private Boolean noonClick;
    private Boolean summerClick;
    private Boolean sendEmail;
    private Date urlGenerateDate;


}
