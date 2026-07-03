package com.ml.pipeline;

import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.Evaluation;

import java.io.InputStream;
import java.util.Random;

public class MIPipelineOrchestrator {

    public static void main(String[] args) {
        try {
            System.out.println("🤖 Starting Autonomous Machine Learning Pipeline...");

            InputStream inputStream = MIPipelineOrchestrator.class
                    .getClassLoader()
                    .getResourceAsStream("bank_transactions.arff");

            if (inputStream == null) {
                System.err.println("❌ Data file missing from resources! Please check your folder structure.");
                return;
            }

            DataSource source = new DataSource(inputStream);
            Instances data = source.getDataSet();

            data.setClassIndex(data.numAttributes() - 1);
            System.out.println("✅ Data successfully ingested. Total records loaded: " + data.numInstances());

            System.out.println("⚙️ Training Decision Tree Model (J48 Algorithm)...");
            J48 decisionTree = new J48();
            decisionTree.buildClassifier(data);
            System.out.println("✅ Model training complete.");

            System.out.println("📊 Running Cross-Validation Evaluation Loop...");
            Evaluation eval = new Evaluation(data);
            eval.crossValidateModel(decisionTree, data, 5, new Random(1));

            System.out.println("\n=== AUTOMATED ML PERFORMANCE REPORT ===");
            System.out.println("Correctly Classified Instances: " + String.format("%.2f", eval.pctCorrect()) + "%");
            System.out.println("Incorrectly Classified Instances: " + String.format("%.2f", eval.pctIncorrect()) + "%");
            System.out.println("=======================================");

        } catch (Exception e) {
            System.err.println("❌ Critical failure in the automated ML pipeline: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
