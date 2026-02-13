import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper

def response = WS.sendRequest(findTestObject('GET_Users_Page_3')) // page param 3
WS.verifyResponseStatusCode(response, 200)

def json = new JsonSlurper().parseText(response.getResponseText())

// Cek page tidak melebihi total_pages
assert json.page <= json.total_pages

// Cek data ada sesuai per_page / total
assert json.data.size() > 0

