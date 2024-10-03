package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationDemoqaTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Anna")
                .setLastName("Jen")
                .setEmail("anna@googl.com")
                .setGender("Female")
                .setUserNumber("9000000001")
                .setDateOfBirth("30", "October", "1997")
                .setSubjects("History")
                .setHobby("Music")
                .setPicture("photo.jpg")
                .setAddress("Some street 1")
                .setState("Haryana")
                .setCity("Karnal")
                .pressSubmit();

        registrationPage.checkResult("Student Name", "Anna Jen")
                .checkResult("Student Email", "anna@googl.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "9000000001")
                .checkResult("Date of Birth", "30 October,1997")
                .checkResult("Subjects", "History")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "photo.jpg")
                .checkResult("Address", "Some street 1")
                .checkResult("State and City", "Haryana Karnal");
    }

    @Test
    void minRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Anna")
                .setLastName("Jen")
                .setGender("Female")
                .setUserNumber("9000000001")
                .setDateOfBirth("30", "October", "1997")
                .pressSubmit();
        registrationPage.checkResult("Student Name", "Anna Jen")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "9000000001")
                .checkResult("Date of Birth", "30 October,1997");

    }
    @Test
    void FailedRegistrationTest () {
        registrationPage.openPage()
                .removeBanner()
                .pressSubmit();
        registrationPage.checkNoResult();
    }
}
