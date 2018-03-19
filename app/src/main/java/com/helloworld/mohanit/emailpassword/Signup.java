package com.helloworld.mohanit.emailpassword;

/**
 * Created by Mohan IT on 11-03-2018.
 */

public class Signup {
    String id;
    String name;
    String list;
    String number;
    public Signup(){

    }

    public Signup(String id,String name, String list,String number) {
        this.id=id;
        this.name = name;
        this.list = list;
        this.number=number;
    }

    public String getName() {
        return name;
    }

    public String getList() {
        return list;
    }
}
