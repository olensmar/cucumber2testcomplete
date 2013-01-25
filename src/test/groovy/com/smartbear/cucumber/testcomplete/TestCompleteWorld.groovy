package com.smartbear.cucumber.testcomplete

import org.codehaus.groovy.scriptom.ActiveXObject

class TestCompleteWorld {

    private def tc = null
    private String scriptUnit
    private String project

    ActiveXObject getIntegration() {
        tc.Integration
    }

    TestCompleteWorld( String pathToTestCompleteProject, String project, String scriptUnit ) {

        this.project = project
        this.scriptUnit = scriptUnit

        Console.println("Connecting to TestComplete")
        tc = ActiveXObject.getObject("TestComplete.TestCompleteApplication")

        try {
            // this will throw an exception if TestComplete wasn't running
            tc.Integration
        }
        catch (Throwable t) {
            Console.println("TestComplete doesn't seem to be running - starting instead")
            tc = new ActiveXObject("TestComplete.TestCompleteApplication")
        }

        // make TestComplete visible and open the specified project file
        File file = new File( pathToTestCompleteProject );
        pathToTestCompleteProject = file.absolutePath

        Console.println("Connected to TestComplete - making visible and opening project " +
                "[$pathToTestCompleteProject]" )

        tc.Visible = true
        tc.Integration.OpenProjectSuite(pathToTestCompleteProject)
    }

    void runRoutine(String name) {
        Console.println("running [$name] in project [$project]")
        try {
            runWithDelays({
                integration.RunRoutine(project, scriptUnit, name)
            })
        }
        catch (Throwable t) {
            throw new Exception("Call to [$name] failed")
        }
    }

    void runWithDelays(closure) {
        while (integration.IsRunning()) {
            Thread.sleep(100)
        }

        closure()
        while (integration.IsRunning()) {
            Thread.sleep(100)
        }

        assert getIntegration().GetLastResultDescription().Status != 2
    }

    void runRoutineEx(String name, Object[] args) {
        Console.println("running [$name] with arguments [$args] in project [$project]")
        try {
            runWithDelays({
                integration.RunRoutineEx("AutomationTest", "NotepadSteps", name, args)
            })
        }
        catch (Throwable t) {
            throw new Exception("Call to [$name] with arguments [$args] failed")
        }
    }
}
