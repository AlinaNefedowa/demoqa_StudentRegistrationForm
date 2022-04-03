package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentRegistrationFormTests {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        String FirstName = "Alisa";
        String LastName = "Berg";
        String Email = "alisa.berg@gmail.com";
        String Mobile = "9213332221";
        String CurrentAddress = "Operngasse 15, 7";

        open("/automation-practice-form");

        //Fill in the FirstName
        $("[id=firstName]").setValue(FirstName);
        //Fill in the LastName
        $("[id=lastName]").setValue(LastName);
        //Fill in the Email
        $("[id=userEmail]").setValue(Email);
        //Fill in the Gender
        $(byText("Female")).click();
        //Fill in the Mobile
        $("[id=userNumber]").setValue(Mobile);
        //Fill in the Date of Birth
        //Fill in the Subjects
        //Fill in the Hobbies
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        //Fill in the Picture
        //Fill in the Current address
        $("[id=currentAddress]").setValue(CurrentAddress);
        //Fill in the State and City

       // $("[id=submit]").click();
//        $("[id=submit]").shouldBe(visible).click();



        // Asserts
       // $("[id=output]").shouldHave(text(name), text("alex@egorov.com"),
              //  text("Some street 1"), text("Another street 2"));

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
