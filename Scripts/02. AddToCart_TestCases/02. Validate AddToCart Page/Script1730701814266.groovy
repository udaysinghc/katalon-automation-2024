import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def bagText = 'Driven Backpack'

WebUI.navigateToUrl(GlobalVariable.lumaUrl)

CustomKeywords.'customCommands.AllCustomCommands.selectBag'()

WebUI.executeJavaScript('window.scrollBy(0, 500);', null)

CustomKeywords.'customCommands.AllCustomCommands.clickOnBagByTextEle'(bagText)

WebUI.click(findTestObject('02. AddToCartPage_Locators/addToCartCTA'))

WebUI.verifyElementVisible(findTestObject('02. AddToCartPage_Locators/successMsg'))

WebUI.click(findTestObject('02. AddToCartPage_Locators/myCart'))

WebUI.waitForElementVisible(findTestObject('02. AddToCartPage_Locators/proceedToCheckout'), 10)

WebUI.click(findTestObject('02. AddToCartPage_Locators/proceedToCheckout'))

WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('02. AddToCartPage_Locators/orderSummary'), 10)

WebUI.closeBrowser()

