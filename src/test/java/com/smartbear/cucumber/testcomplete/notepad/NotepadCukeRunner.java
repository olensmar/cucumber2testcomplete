package com.smartbear.cucumber.testcomplete.notepad;

import cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(features = "src/test/resources/features/notepad.feature")
public class NotepadCukeRunner {
}