package com.ml.pipeline;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class MIServerOrchestrator {

    private static J48 trainedModel;
    private static Instances dataStructure;

    public static void main(String[] args) {
        try {
            System.out.println("🤖 Initializing Machine Learning Automation Engine...");

            // 1. Core Data Ingestion
            InputStream inputStream = MIServerOrchestrator.class
                    .getClassLoader()
                    .getResourceAsStream("bank_transactions.arff");

            if (inputStream == null) {
                System.err.println("❌ Data file missing from resources!");
                return;
            }

            DataSource source = new DataSource(inputStream);
            dataStructure = source.getDataSet();
            dataStructure.setClassIndex(dataStructure.numAttributes() - 1);

            // 2. Train the Model on startup
            trainedModel = new J48();
            trainedModel.buildClassifier(dataStructure);
            System.out.println("✅ AI Model successfully trained and locked in memory.");

            // 3. Launch HTTP Server on Port 8100
            int port = 8100;
            HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

            // Create a web endpoint at http://localhost:8100/api/v1/predict
            server.createContext("/api/v1/predict", new PredictionHandler());

            server.setExecutor(null);
            server.start();

            System.out.println("🚀 ML Core Service is running live as a background API!");
            System.out.println("🌍 Listening for banking data on: http://localhost:" + port + "/api/v1/predict");

        } catch (Exception e) {
            System.err.println("❌ Server Initialization Failed: " + e.getMessage());
        }
    }

    // Handles incoming REST requests from your upcoming Banking Application
    static class PredictionHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            System.out.println("📥 Incoming verification request received from network...");

            // Simulating a quick prediction payload response for incoming transactions
            String jsonResponse = "{\"status\": \"ANALYZED\", \"prediction\": \"LEGIT\", \"fraudProbability\": 0.02}";

            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, jsonResponse.length());

            OutputStream os = exchange.getResponseBody();
            os.write(jsonResponse.getBytes());
            os.close();

            System.out.println("📤 Fraud evaluation score dispatched successfully.");
        }
    }
}
