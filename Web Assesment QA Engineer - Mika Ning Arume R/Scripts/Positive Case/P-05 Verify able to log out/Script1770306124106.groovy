import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

// === 1. Setup ChromeOptions untuk disable pop-up password manager ===
ChromeOptions options = new ChromeOptions()

options.addArguments('--disable-save-password-bubble' // Disable pop-up save password
    )

options.addArguments('--incognito' // Opsional: pakai incognito
    )

options.addArguments('--start-maximized' // Maksimalkan browser
    )

// === 2. Inisialisasi ChromeDriver sendiri ===
WebDriver driver = new ChromeDriver(options)

DriverFactory.changeWebDriver(driver // Daftarkan driver ke Katalon
    )

// === 3. Script test case kamu ===
driver.get('https://www.saucedemo.com/')

WebUI.waitForElementVisible(findTestObject('Page_Swag Labs/input_Swag Labs_user-name'), 10)

WebUI.setText(findTestObject('Page_Swag Labs/input_Swag Labs_user-name'), 'standard_user')

WebUI.setText(findTestObject('Page_Swag Labs/input_Swag Labs_password'), 'secret_sauce')

WebUI.click(findTestObject('Page_Swag Labs/input_Swag Labs_login-button'))

WebUI.click(findTestObject('Page_Swag Labs/button_Open Menu'))

WebUI.click(findTestObject('Page_Swag Labs/a_Logout'))

// === 4. Tutup browser ===
driver.quit()

