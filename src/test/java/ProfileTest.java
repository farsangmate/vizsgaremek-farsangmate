import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class ProfileTest extends TestUtilities {

    String profName = "Vagasi Ferenc";
    String profPassword = "VagasiFeri123";
    String profEmail = "vagasiferenc@gmail.com";
    String profBio = "beszálltam az internetbe";
    String profPhoneNumber = "1233456";

    @Test
    @Order(1)
    @DisplayName("A profil adatainak módosítása")
    @Description("Felhasználó adatainak módosításának tesztelése")
    @Severity(SeverityLevel.NORMAL)
    public void testEditProfile() throws InterruptedException {
        basePage.navigate();
        basePage.acceptTAC();
        basePage.login(VALIDUSERNAME, VALIDPASSWORD);
        profilePage.navigateToProfilePage();
        profilePage.modifyProfile(profName, profBio, profPhoneNumber);
        Thread.sleep(150);
        boolean actual = profilePage.isEditSuccessful();
        Assertions.assertTrue(actual);
    }

    @Test
    @Order(2)
    @DisplayName("A profil adatainak módosítása,beviteli mezők tesztelése")
    @Description("Beviteli mezők tesztelése. Adatok megadása, törlése majd újbóli megadása")
    @Severity(SeverityLevel.NORMAL)
    public void testModify() throws InterruptedException {
        basePage.navigate();
        basePage.acceptTAC();
        basePage.login(VALIDUSERNAME, VALIDPASSWORD);
        profilePage.navigateToProfilePage();
        profilePage.modifyProfile(profPhoneNumber, profBio, profName);
        Thread.sleep(150);
        profilePage.deleteFields();
        Thread.sleep(150);
        profilePage.modifyProfile(profName, profBio, profPhoneNumber);
        boolean actual = profilePage.isEditSuccessful();
        Assertions.assertTrue(actual);
    }
    @Test
    @Order(3)
    @DisplayName("Adatok törlése")
    @Description("Adatok bevitele majd törlése")
    @Severity(SeverityLevel.NORMAL)
    public void testDeleteData() {
        basePage.navigate();
        basePage.acceptTAC();
        basePage.login(VALIDUSERNAME, VALIDPASSWORD);
        profilePage.navigateToProfilePage();
        profilePage.modifyProfile(profName, profBio, profPhoneNumber);
        profilePage.deleteFields();
        String[] expectedResult = expectedEmptyArray();
        String[] actualResult = profilePage.inputFieldsList();
        Assertions.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    @Order(4)
    @DisplayName("Profil törlése")
    @Description("Profil törlésének tesztelése")
    @Severity(SeverityLevel.NORMAL)
    public void testDeleteProfile() {
        basePage.navigate();
        basePage.acceptTAC();
        basePage.login(VALIDUSERNAME, VALIDPASSWORD);
        profilePage.deleteProfile();
        String wrongURL = "https://lennertamas.github.io/roxo/profile";
        String actualResult = driver.getCurrentUrl();
        Assertions.assertNotEquals(wrongURL, actualResult);
    }

    @Test
    @Order(5)
    @DisplayName("Profil törlése és belépés")
    @Description("Profil törlése, majd azzal való bejelentkezés tesztelése")
    @Severity(SeverityLevel.NORMAL)
    public void testDeleteProfileAndLogin() {
        basePage.navigate();
        basePage.acceptTAC();
        basePage.register(profName, profPassword, profEmail, profBio);
        basePage.navigate();
        basePage.login(profName, profPassword);
        profilePage.deleteProfile();
        basePage.navigate();
        basePage.login(profName, profPassword);
        String actual = basePage.getLoginText();
        String expected = "Username or Password\n" + "is not correct!";
        Assertions.assertEquals(expected, actual);

    }


}
