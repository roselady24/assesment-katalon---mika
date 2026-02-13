import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import java.text.SimpleDateFormat

// === 1. Fungsi bantu untuk screenshot otomatis ===
def takeScreenshot(stepName) {
	def timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())
	WebUI.takeScreenshot("Screenshots/${timestamp}_${stepName}.png")
}

// === 2. Setup ChromeOptions untuk disable pop-up password manager ===
ChromeOptions options = new ChromeOptions()
options.addArguments("--disable-save-password-bubble")
options.addArguments("--incognito")
options.addArguments("--start-maximized")

// === 3. Inisialisasi ChromeDriver sendiri ===
WebDriver driver = new ChromeDriver(options)
DriverFactory.changeWebDriver(driver)

// === 4. Script test case dengan screenshot di setiap action ===
driver.get("https://www.saucedemo.com/")
takeScreenshot("open_url")

WebUI.waitForElementVisible(findTestObject('Page_Swag Labs/input_Swag Labs_user-name'), 10)
takeScreenshot("login_page_visible")

WebUI.setText(findTestObject('Page_Swag Labs/input_Swag Labs_user-name'), 'standard_user')
takeScreenshot("username_filled")

WebUI.setText(findTestObject('Page_Swag Labs/input_Swag Labs_password'), 'secret_sauce')
takeScreenshot("password_filled")

WebUI.click(findTestObject('Page_Swag Labs/input_Swag Labs_login-button'))
takeScreenshot("clicked_login")

WebUI.click(findTestObject('Page_Swag Labs/select_Name (A to Z)Name (Z to A)Price (low to high)Price (high to low)'))
takeScreenshot("clicked_sort_dropdown")

// === 5. Tutup browser ===
driver.quit()
