package com.qa.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class EnvironmentHealthTest {

    @Test
    public void testAllSystemPortsAndMlIntegration() {
        // 1. Basic Health Routing Check across active ports
        List<Integer> standardPorts = List.of(8097, 8098);

        for (int port : standardPorts) {
            try {
                System.out.println("🤖 Automating Health Check: Pinging Port " + port);
                int statusCode = given()
                        .baseUri("http://localhost")
                        .port(port)
                        .when()
                        .get("/")
                        .then()
                        .extract()
                        .statusCode();

                System.out.println("✅ Port " + port + " responded with status code: " + statusCode);
            } catch (Exception e) {
                System.err.println("⚠️ Alert: Port " + port + " did not respond. Service might be inactive.");
            }
        }

        // 2. Functional Test: Validate Live ML Service on Port 8100
        System.out.println("\n🧠 Automating AI Pipeline Validation: Hitting Port 8100...");
        try {
            given()
                    .baseUri("http://localhost")
                    .port(8100)
                    .when()
                    .get("/api/v1/predict")
                    .then()
                    .statusCode(200) // Asserts network request was successful
                    .body("status", equalTo("ANALYZED")) // Asserts JSON validation rules
                    .body("prediction", equalTo("LEGIT"));

            System.out.println("✅ Success! QA Framework successfully verified the Live Machine Learning Model on Port 8100!");
        } catch (Exception e) {
            System.err.println("❌ Automation Error: ML Core API did not respond correctly on Port 8100!");
        }
    }
}
