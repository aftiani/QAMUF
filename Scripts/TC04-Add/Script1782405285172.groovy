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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType


WebUI.click(findTestObject('Object Repository/Admin_Add/btn_Add'))

WebUI.waitForPageLoad(5)

//userrole
WebUI.click(findTestObject('Object Repository/Admin_Add/Drpdown_UserRole'))

if(user_role == 'ESS') {
	WebUI.click(findTestObject('Object Repository/Admin_Add/option_ESS'))
} else {
	WebUI.click(findTestObject('Object Repository/Admin_Add/option_Admin'))
}


//employee
WebUI.setText(
	findTestObject('Object Repository/Admin_Add/txt_EmployeeName'),
	employee_name
)

WebUI.delay(2)

WebUI.sendKeys(
	findTestObject('Object Repository/Admin_Add/txt_EmployeeName'),
	Keys.chord(Keys.ARROW_DOWN, Keys.ENTER)
)


//status
WebUI.click(findTestObject('Object Repository/Admin_Add/Drpdown_Status'))

if(status == 'Enabled') {
	WebUI.click(findTestObject('Object Repository/Admin_Add/option_Enabled'))
} else {
	WebUI.click(findTestObject('Object Repository/Admin_Add/option_Disabled'))
}

WebUI.click(statusOption)

//username
String uniqueUsername =
	username + System.currentTimeMillis()

WebUI.setText(
	findTestObject('Object Repository/Admin_Add/txt_Username'),
	uniqueUsername
)

WebUI.setText(
	findTestObject('Object Repository/Admin_Add/txt_Password'),
	password
)

WebUI.setText(
	findTestObject('Object Repository/Admin_Add/txt_ConfirmPassword'),
	confirm_password
)


WebUI.click(findTestObject('Object Repository/Admin_Add/btn_Save'))

WebUI.delay(3)


WebUI.verifyTextPresent(
	expected_success_message,
	false
)

WebUI.takeScreenshot()