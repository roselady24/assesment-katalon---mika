import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper

def response = WS.sendRequest(findTestObject('GET_Users_Page_Negative')) // page=-1
WS.verifyResponseStatusCode(response, 200)

def json = new JsonSlurper().parseText(response.getResponseText())

// Server OK, data array bisa kosong atau default
assert json.data instanceof List
assert json.data.size() >= 0
