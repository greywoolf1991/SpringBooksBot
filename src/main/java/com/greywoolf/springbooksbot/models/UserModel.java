package com.greywoolf.springbooksbot.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "telegram_user")
@Data
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "username")
    String username;
    @Column(name = "telegram_id")
    String tgId;
    @Column(name = "user_name")
    String name;
}
