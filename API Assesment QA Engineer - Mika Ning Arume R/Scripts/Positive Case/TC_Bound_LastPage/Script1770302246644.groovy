import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper

def response = WS.sendRequest(findTestObject('GET_Users_Page_2'))
WS.verifyResponseStatusCode(response, 200)

def json = new JsonSlurper().parseText(response.getResponseText())
assert json.page == 2
assert json.data.size() > 0
