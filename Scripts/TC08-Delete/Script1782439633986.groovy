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

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Search username
WebUI.clearText(findTestObject('Object Repository/Admin_Delete/txt_Username_Search'))

WebUI.setText(
	findTestObject('Object Repository/Admin_Delete/txt_Username_Search'),
	target_username
)

WebUI.click(findTestObject('Object Repository/Admin_Delete/btn_Search'))

WebUI.delay(2)

// Checkbox berdasarkan username
TestObject checkbox = new TestObject()

checkbox.addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//div[text()='" + target_username + "']/ancestor::div[@role='row']//i[contains(@class,'oxd-checkbox-input-icon')]"
)

WebUI.click(checkbox)

// Delete Selected
WebUI.click(findTestObject('Object Repository/Admin_Delete/btn_Delete'))

// Confirm Delete
WebUI.click(findTestObject('Object Repository/Admin_Delete/btn_ConfirmDelete'))

// Verifikasi toast sukses
WebUI.verifyTextPresent(
	expected_success_message,
	false
)

// Search ulang
WebUI.clearText(findTestObject('Object Repository/Admin_Delete/txt_Username_Search'))

WebUI.setText(
	findTestObject('Object Repository/Admin_Delete/txt_Username_Search'),
	target_username
)

WebUI.click(findTestObject('Object Repository/Admin_Delete/btn_Search'))

WebUI.delay(2)

// Verifikasi user sudah tidak ada
WebUI.verifyTextPresent(
	expected_after_delete_message,
	false
)

WebUI.takeScreenshot()