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

WebUI.verifyElementPresent(
	findTestObject('Object Repository/Admin/systemUsersHeader'),
	10
)

WebUI.verifyElementPresent(
	findTestObject('Object Repository/Admin/txt_Username_Search'),
	10
)

WebUI.verifyElementPresent(
	findTestObject('Object Repository/Admin/Drpdown_UserRole'),
	10
)

WebUI.verifyElementPresent(
	findTestObject('Object Repository/Admin/txt_EmployeeName'),
	10
)

WebUI.verifyElementPresent(
	findTestObject('Object Repository/Admin/Drpdown_Status'),
	10
)

WebUI.verifyElementPresent(
	findTestObject('Object Repository/Admin/btn_Search'),
	10
)

WebUI.verifyElementPresent(
	findTestObject('Object Repository/Admin/btn_Reset'),
	10
)

WebUI.takeScreenshot()