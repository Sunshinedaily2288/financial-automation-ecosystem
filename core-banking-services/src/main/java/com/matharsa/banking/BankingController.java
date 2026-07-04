package com.matharsa.banking;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/banking")
public class BankingController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/status")
    public Map<String, Object> getBankingSystemStatus() {
        System.out.println("📥 Incoming transaction ledger ping detected on Port 8105...");
        return Map.of(
                "status", "OPERATIONAL",
                "service", "core-banking-services",
                "port", 8105,
                "message", "Financial transaction infrastructure ready."
        );
    }

    @GetMapping("/process-transaction")
    public Map<String, Object> processFinancialTransaction() {
        System.out.println("💳 Processing incoming bank transaction request on Port 8105...");

        // Define the live target URL pointing straight to your background ML Server on Port 8100
        String mlServerUrl = "http://localhost:8100/api/v1/predict";
        String aiEngineResponse;

        try {
            System.out.println("🧠 Dispatched transaction payload data down to AI Core on Port 8100...");
            // Call your ML background server live over your internal network ports
            aiEngineResponse = restTemplate.getForObject(mlServerUrl, String.class);
            System.out.println("✅ Real-time fraud analysis metrics received back from ML Core.");
        } catch (Exception e) {
            System.err.println("⚠️ Warning: Could not reach the Machine Learning engine on Port 8100!");
            aiEngineResponse = "{\"status\": \"FALLBACK_MODE\", \"prediction\": \"UNKNOWN\", \"error\": \"ML engine offline\"}";
        }

        // Return a combined ledger response confirming that both systems are talking
        return Map.of(
                "transactionId", "TXN-" + System.currentTimeMillis(),
                "amount", 25000.00,
                "currency", "USD",
                "coreBankingStatus", "PROCESSED",
                "aiVerificationReport", aiEngineResponse
        );
    }
}
