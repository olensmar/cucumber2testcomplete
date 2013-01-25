package com.smartbear.cucumber.testcomplete

import static org.junit.Assert.assertTrue

this.metaClass.mixin(cucumber.runtime.groovy.Hooks)
this.metaClass.mixin(cucumber.runtime.groovy.EN)

World {
    new TestCompleteWorld("src/test/resources/testcomplete/AutomationTest.pjs", "AutomationTest", "NotepadSteps")
}

Given(~'^notepad is running$') {->
    // pass on to TestComplete
    runRoutine("notepad_is_running")
}

When(~'I load the file (.*)') { String filename ->
    // make sure we have a valid absolute path that TestComplete can work with
    def file = new File( filename )
    if( !file.exists())
       file = new File( "src/test/resources/data/" + filename )

    assertTrue( "Missing file $file",  file.exists() )

    // pass on to TestComplete
    runRoutineEx("I_load_the_file", file.absolutePath)
}

Then(~'the editor should contain (.*)') { String text ->
    // pass on to TestComplete
    runRoutineEx("the_editor_should_contain", text)
}