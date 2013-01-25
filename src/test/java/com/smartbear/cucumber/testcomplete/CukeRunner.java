package com.smartbear.cucumber.testcomplete;

import cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(features = "src/test/resources/features")
public class CukeRunner {
}