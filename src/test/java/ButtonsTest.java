import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.MethodName.class)

public class ButtonsTest extends TestUtilities {

    @BeforeEach
    public void beforeTestButtons() {
        basePage.navigate();
        basePage.acceptTAC();
        basePage.login(VALIDUSERNAME, VALIDPASSWORD);
    }

    @Test
    @Order(1)
    @DisplayName("Home gomb teszt")
    @Description("A 'Home' gomb megfelelő oldalra vezet")
    @Severity(SeverityLevel.NORMAL)
    public void testHomeButton() {
        String expectedHomePage = "https://lennertamas.github.io/roxo/landing.html";
        String homePage = basePage.homeButtonURL();
        Assertions.assertEquals(expectedHomePage, homePage);
    }

    @Test
    @Order(2)
    @DisplayName("About gomb teszt")
    @Description("Az 'About' gomb megfelelő oldalra vezet")
    @Severity(SeverityLevel.NORMAL)
    public void testAboutButton() {
        String expectedAboutPage = "https://lennertamas.github.io/roxo/about/";
        String aboutPage = basePage.aboutButtonURL();
        Assertions.assertEquals(expectedAboutPage, aboutPage);
    }

    @Test
    @Order(3)
    @DisplayName("Portfolio gomb teszt")
    @Description("A 'Portfolio' gomb megfelelő oldalra vezet")
    @Severity(SeverityLevel.NORMAL)
    public void testPortfolioButton() {
        String expectedPortfolioPage = "https://lennertamas.github.io/roxo/portfolio/";
        String portfolioPage = basePage.portfolioButtonURL();
        Assertions.assertEquals(expectedPortfolioPage, portfolioPage);
    }

    @Test
    @Order(4)
    @DisplayName("Blog gomb teszt")
    @Description("A 'Blog' gomb megfelelő oldalra vezet")
    @Severity(SeverityLevel.NORMAL)
    public void testBlogButton() {
        String expectedBlogPage = "https://lennertamas.github.io/roxo/blog/";
        String blogPage = basePage.blogButtonURL();
        Assertions.assertEquals(expectedBlogPage, blogPage);
    }

    @Test
    @Order(5)
    @DisplayName("Get in touch gomb teszt")
    @Description("A 'Get in touch' gomb megfelelő oldalra vezet")
    @Severity(SeverityLevel.NORMAL)
    public void testContactButton() {
        String expectedContactPage = "https://lennertamas.github.io/roxo/contact/";
        String contactPage = basePage.contactButtonURL();
        Assertions.assertEquals(expectedContactPage, contactPage);
        basePage.goToMainPage();
    }

    @Test
    @Order(6)
    @DisplayName("Profile gomb teszt")
    @Description("A 'Profile' gomb megfelelő oldalra vezet")
    @Severity(SeverityLevel.NORMAL)
    public void testProfileButton() {
        String expectedProfilePage = "https://lennertamas.github.io/roxo/profile";
        String profilePage = basePage.profileButtonURL();
        Assertions.assertEquals(expectedProfilePage, profilePage);
    }

    @Test
    @Order(7)
    @DisplayName("Connect With Us gomb teszt")
    @Description("A 'Connect With Us' gomb megfelelő oldalra vezet")
    @Severity(SeverityLevel.NORMAL)
    public void testConnectWithUs() {
        String expectedContactPage = "https://lennertamas.github.io/roxo/contact/";
        String contactPage = basePage.connectWithUsButtonURL();
        Assertions.assertEquals(expectedContactPage, contactPage);
        basePage.goToMainPage();
    }

    @Test
    @Order(8)
    @DisplayName("See Our Work button teszt")
    @Description("A 'See Our Work' gomb megfelelő oldalra vezet")
    @Severity(SeverityLevel.NORMAL)
    public void testSeeOurWorkButton() {
        String expectedPortfolioPage = "https://lennertamas.github.io/roxo/portfolio/";
        String portfolioPage = basePage.seeOurWorksButtonURL();
        Assertions.assertEquals(expectedPortfolioPage, portfolioPage);
    }

}
