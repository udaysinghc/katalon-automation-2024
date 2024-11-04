package customCommands

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject


import org.openqa.selenium.WebElement
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class AllCustomCommands {

	@Keyword
	def lumaLogin() {

		WebUI.navigateToUrl(GlobalVariable.lumaUrl)

		WebUI.waitForElementVisible(findTestObject('01. LoginPage_Locators/signInCTA'), 10)

		WebUI.click(findTestObject('01. LoginPage_Locators/signInCTA'))

		WebUI.setText(findTestObject('01. LoginPage_Locators/email'), GlobalVariable.lumaEmail)

		WebUI.setText(findTestObject('01. LoginPage_Locators/password'), GlobalVariable.lumaPassword)

		WebUI.scrollToElement(findTestObject('01. LoginPage_Locators/loginCTA'), 0)

		WebUI.click(findTestObject('01. LoginPage_Locators/loginCTA'))
	}

	@Keyword
	def selectBag() {

		WebUI.waitForElementVisible(findTestObject('02. AddToCartPage_Locators/gearMenu'), 10)

		WebUI.mouseOver(findTestObject('02. AddToCartPage_Locators/gearMenu'))

		WebUI.click(findTestObject('02. AddToCartPage_Locators/bags'))

		WebUI.verifyElementVisible(findTestObject('02. AddToCartPage_Locators/bagsHeading'))
	}

	@Keyword
	def clickOnBagByTextEle(String text) {
		// Define the TestObject for the list of bags
		TestObject bagsList = findTestObject('02. AddToCartPage_Locators/bagsList') // Adjust to your list locator

		// Get all elements in the list
		List<WebElement> bagsElements = WebUI.findWebElements(bagsList, 10)

		// Loop through the elements to find and click the bag matching `text`
		for (WebElement bag : bagsElements) {
			if (bag.getText().contains(text)) {
				bag.click()
				WebUI.comment("Clicked on bag: " + text)
				return
			}
		}
		WebUI.comment("Bag with text '" + text + "' not found.")
	}
}
