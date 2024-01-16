package com.restful.booker.testbase;

import com.restful.booker.propertyreader.PropertyReader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class TestBase {

    @BeforeClass
    public void inIt(){
        RestAssured.baseURI = PropertyReader.getInstance().getProperty("baseURI");
        RestAssured.basePath = PropertyReader.getInstance().getProperty("basePath");
    }
}
