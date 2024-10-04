package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomDataUtils;


public class RegistrationWithFakerTests extends TestBase {
    private final RegistrationPage registrationPage = new RegistrationPage();

    String firstName = RandomDataUtils.getRandomFirstName(),
            lastName = RandomDataUtils.getRandomLastName(),
            userEmail = RandomDataUtils.getRandomEmail(),
            gender = RandomDataUtils.getRandomGender(),
            userNumber = RandomDataUtils.getRandomNumber(),
            yearOfBirth = RandomDataUtils.getRandomYearOfBirth(),
            monthOfBirth = RandomDataUtils.getRandomMonthOfBirth(),
            dayOfBirth = RandomDataUtils.getRandomDayOfBirth(monthOfBirth, yearOfBirth),
            subjects = RandomDataUtils.getRandomSubject(),
            hobbies = RandomDataUtils.getRandomHobbies(),
            picture = RandomDataUtils.getRandomPicture(),
            address = RandomDataUtils.getRandomAddress(),
            state = RandomDataUtils.getRandomState(),
            city = RandomDataUtils.getRandomCity(state);



    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjects)
                .setHobby(hobbies)
                .setPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .pressSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", picture)
                .checkResult("Address", address)
                .checkResult("State and City",  state + " " + city);
    }
    @Test
    void minRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .pressSubmit();
        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth);

    }
}
