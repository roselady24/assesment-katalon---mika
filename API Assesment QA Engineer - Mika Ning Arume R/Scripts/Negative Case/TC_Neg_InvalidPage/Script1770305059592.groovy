import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

TestObject request = findTestObject('GET_Users_InvalidPage')

// invalid page
request.addProperty("page", ConditionType.EQUALS, "abc")

def response = WS.sendRequest(request)

// API tetap 200
WS.verifyResponseStatusCode(response, 200)

// ASSERT FALLBACK KE PAGE 1
WS.verifyElementPropertyValue(response, 'page', 1)

// data TIDAK kosong
WS.verifyElementPropertyValue(response, 'data.size()', 6)
