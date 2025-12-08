package PlayWright;

import com.microsoft.playwright.*;

public class InstallBrowsers {
    public static void main(String[] args) {
        Playwright.create().chromium().launch();

        System.out.println("Browsers installed successfully!");

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://playwright.dev/");
            System.out.println(page.title());
        }
    }
}