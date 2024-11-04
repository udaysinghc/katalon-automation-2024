package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p>Profile Staging : Staging Environment Url</p>
     */
    public static Object lumaUrl
     
    /**
     * <p>Profile Staging : Email</p>
     */
    public static Object lumaEmail
     
    /**
     * <p>Profile Staging : Password</p>
     */
    public static Object lumaPassword
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += TestCaseMain.getParsedValues(RunConfiguration.getOverridingParameters())
    
            lumaUrl = selectedVariables['lumaUrl']
            lumaEmail = selectedVariables['lumaEmail']
            lumaPassword = selectedVariables['lumaPassword']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
