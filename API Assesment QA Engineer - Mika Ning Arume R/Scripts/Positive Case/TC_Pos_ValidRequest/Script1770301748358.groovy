import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper

// Kirim request
def response = WS.sendRequest(findTestObject('GET_Users_Page_2'))

// Verifikasi status code
WS.verifyResponseStatusCode(response, 200)

// Parse JSON
def json = new JsonSlurper().parseText(response.getResponseText())

// Verifikasi pagination
assert json.page == 2
assert json.per_page > 0
assert json.total_pages >= json.page

// Verifikasi data user
assert json.data.size() > 0

json.data.each { user ->
	assert user.id instanceof Integer
	assert user.email.contains("@")
	assert user.first_name != null
	assert user.last_name != null
	assert user.avatar.startsWith("https")
}

