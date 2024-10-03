import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import tests.TestBase;


public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillAllFieldsTest() {
        textBoxPage.openPage()
                .setName("Anna")
                .setEmail("anna@googl.com")
                .setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1")
                .submit()
                .checkResultName("Anna")
                .checkResultEmail("anna@googl.com")
                .checkResultCurrentAddress("Some street 1")
                .checkResultPermanentAddress("Another street 1");
    }
}