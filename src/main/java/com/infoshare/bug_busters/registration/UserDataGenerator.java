package com.infoshare.bug_busters.registration;
import com.infoshare.bug_busters.random.RandomDataGenerator;

import java.io.IOException;

public class UserDataGenerator {

    private final RandomDataGenerator dataGenerator; // wyciagniety RandomDataGenerator na potrzeby mocka

    public UserDataGenerator(RandomDataGenerator dataGenerator) {
        this.dataGenerator = dataGenerator;
    }
    //konstruktor ktory trzeba stworzyc z polem dataGenerator typu RandomDataGenerator, zeby w metodzie prepareUserData() nie bylo
                // na sztywno RandomDataGenerator.prepareUserName()

    public UserData prepareUserData() throws IOException {
        String userName = dataGenerator.prepareUserName();
        String firstName = dataGenerator.prepareFirstName();
        String lastName = dataGenerator.prepareLastName() ;
        String email = dataGenerator.prepareEmail();
        String password = dataGenerator.preparePassword();

       return new UserData(userName,firstName,lastName,email,password);
    }



}
