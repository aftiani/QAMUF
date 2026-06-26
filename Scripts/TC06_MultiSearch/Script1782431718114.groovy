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

search_status = search_status.trim()
search_role = search_role.trim()
expected_result_type = expected_result_type.trim()

WebUI.clearText(findTestObject('Object Repository/Admin_Search/txt_Username'))

//username
WebUI.setText(
	findTestObject('Object Repository/Admin_Search/txt_Username'),
	search_username
)

//userrole
WebUI.click(findTestObject('Object Repository/Admin_Search/drp_UserRole'))

TestObject roleOption = new TestObject()

roleOption.addProperty(
	"xpath",
	ConditionType.EQUALS,
	"(//div[@role='listbox']//div[normalize-space()='" + search_role + "'])[1]"
)

WebUI.click(roleOption)

//status
// Status
WebUI.click(findTestObject('Object Repository/Admin_Search/drp_Status'))

WebUI.delay(2)

println("===== PAGE SOURCE =====")
println(WebUI.getPageSource())

TestObject statusOption = new TestObject()

statusOption.addProperty(
    "xpath",
    ConditionType.EQUALS,
    "//*[normalize-space()='" + search_status + "']"
)

WebUI.waitForElementVisible(statusOption, 10)
WebUI.waitForElementClickable(statusOption, 10)

WebUI.click(statusOption)


WebUI.click(findTestObject('Object Repository/Admin_Search/btn_Search'))

WebUI.delay(3)

if (expected_result_type.equalsIgnoreCase("FOUND")) {
	
		String actualUsername =
			WebUI.getText(findTestObject('Object Repository/Admin_Search/tbl_Username'))
	
		String actualRole =
			WebUI.getText(findTestObject('Object Repository/Admin_Search/tbl_Role'))
	
		String actualStatus =
			WebUI.getText(findTestObject('Object Repository/Admin_Search/tbl_Status'))
	
		WebUI.verifyEqual(actualUsername, search_username)
		WebUI.verifyEqual(actualRole, expected_role_in_result)
		WebUI.verifyEqual(actualStatus, expected_status_in_result)
	
	} else {
	
		WebUI.verifyTextPresent('No Records Found', false)
	
	}
	WebUI.takeScreenshot()