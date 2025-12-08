package PlayWright;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class ExamplePlaywrightTest {
    @org.junit.jupiter.api.Test
    void openExampleSite() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );
            Page page = browser.newPage();
            page.navigate("https://example.com");
            System.out.println("Page title: " + page.title());
            page.click("#login");
            page.fill("#username", "kwesi");
            assert page.title().contains("Dashboard");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("shot.png")));
        }
    }
}

class EAHomePageTest {

    @Test
    void openEAHomePage() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false)
                            .setSlowMo(50) // Adds a 50ms delay between each action (e.g., click, fill)
                            .setTimeout(8000000)
            );
            Page page = browser.newPage();
            page.navigate("https://www.ea.com");
            page.waitForLoadState();

            System.out.println("Page title: " + page.title());
        }
    }
}








