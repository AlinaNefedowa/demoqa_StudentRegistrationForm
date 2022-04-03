package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentRegistrationFormTests {

    String firstName = "Alisa";
    String lastName = "Berg";
    String email = "alisa.berg@gmail.com";
    String mobile = "9213332221";
    String currentAddress = "Operngasse 15, 7";

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.browserSize = "1436×732";
    }

    @Test
    void fillFormTest() {

        open("/automation-practice-form");

        //Hide the footer and banner
        Selenide.executeJavaScript("document.querySelector(\"footer\").hidden = 'true';" +
                "document.querySelector(\"#fixedban\").hidden = 'true'");

        //Filling in the form

        //Fill in the FirstName
        $("#firstName").setValue(firstName);
        //Fill in the LastName
        $("#lastName").setValue(lastName);
        //Fill in the Email
        $("#userEmail").setValue(email);
        //Fill in the Gender
        $(byText("Female")).click();
        //Fill in the Mobile
        $("#userNumber").setValue(mobile);
        //Fill in the Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1992");
        $("[aria-label$='April 12th, 1992']").click();
        //Fill in the Subjects
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        //Fill in the Hobbies
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        //Fill in the Picture
        $("#uploadPicture").uploadFromClasspath("img/Picture.jpeg");
        //Fill in the Current address
        $("#currentAddress").setValue(currentAddress);

        //Scroll the page
        $("#stateCity-wrapper").scrollIntoView(true);

        //Fill in the State and City
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        //$("#state").click();
        $("#city").$(byText("Karnal")).click();
        //Click "Submit" button
        //executeJavaScript("document.body.style.zoom='0.75';document.getElementById(\"submit\").click()");
        //$("#id=submit").click();
        //$("#id=submit").shouldBe(visible).click();

        //Assertions

        //$("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
       // $(".modal-body").shouldHave(
        //  text(firstName + " " + lastName),
        //  text(email),
        //  text("Female"),
        //  text(mobile),
        //  text("12 April,2022"),
        //  text("Sports,"Reading"),
        //  text(hobby),
        //  text(imgPath.substring(4)),
        //  text(currentAddress),
        //  text(state + " " + city)
       // );


//        $("[id=output] [id=name]").shouldHave(text(name));
//        $("[id=output]").$("[id=name]").shouldHave(text(name));
//        $("[id=name]").shouldHave(text(name));
//
//        $("[id=permanentAddress]").shouldHave(text("Permananet Address :Another street 2")); // wrong
//        $("[id=permanentAddress]", 1).shouldHave(text("Permananet Address :Another street 2"));
//        $("p[id=permanentAddress]").shouldHave(text("Permananet Address :Another street 2"));
//
//        String expectedPermanentAddress = "Another street 2";
//        String actualPermanentAddress = $("p[id=permanentAddress]").text();
//        assertEquals(expectedPermanentAddress, actualPermanentAddress);
    }
}
