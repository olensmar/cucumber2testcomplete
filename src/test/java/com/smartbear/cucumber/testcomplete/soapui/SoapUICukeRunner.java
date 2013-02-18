package com.smartbear.cucumber.testcomplete.soapui;

import cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(features = "src/test/resources/features/soapui.feature")
public class SoapUICukeRunner {
}