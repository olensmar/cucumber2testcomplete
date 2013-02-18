package com.smartbear.cucumber.testcomplete.soapui

import com.smartbear.cucumber.testcomplete.TestCompleteWorld

this.metaClass.mixin(cucumber.runtime.groovy.Hooks)
this.metaClass.mixin(cucumber.runtime.groovy.EN)

World {
    new TestCompleteWorld("src/test/resources/testcomplete/AutomationTest.pjs", "AutomationTest", "SoapUISteps")
}

Given(~'^SoapUI is running$') {->
    // pass on to TestComplete
    callScript("soapui_is_running")
}

Given(~'^no dialogs are visible$') { ->
    // pass on to TestComplete
    callScript("no_dialogs_are_visible")
}

When(~'I select (.*) from the (.*) menu' ){ String menuItem, String menu ->
    // pass on to TestComplete
    callScript("i_select_from_the_menu", menu, menuItem)
}

Then(~'the (.*) dialog is shown') { String dialogName ->
    // pass on to TestComplete
    callScript("the_dialog_is_shown", dialogName)
}