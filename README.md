# Financial Automation Ecosystem 🚀

A production-grade, distributed Java ecosystem demonstrating automated software quality assurance seamlessly integrated with continuous Machine Learning (ML) inference pipelines. This multi-project architecture replicates automated fraud detection systems common in modern financial and banking institutions.

---

## 🏛️ System Architecture Design

The ecosystem is engineered as separate, decoupled service modules to prevent library conflicts, ensure independent scalability, and match modern cloud deployment standards.

```text
 ┌───────────────────────────┐
 │ Project 2: ML Engine      │ ──► Operates live on Port 8100
 │ (Weka Pipeline Service)   │     Processes raw banking records and trains
 └─────────────▲─────────────┘     predictive classification models in-memory.
               │
               │ (Performs background network validation & assertions)
               │
 ┌─────────────┴─────────────┐
 │ Project 1: QA Framework   │ ──► Autonomous Testing Overseer
 │ (REST-Assured & JUnit 5)  │     Pings active architecture nodes and 
 └───────────────────────────┘     validates live JSON payloads programmatically.
```

---

## 📁 Repository Modules

### 1. `qa-testing-framework`
The continuous integration and automation command center. Instead of manually clicking paths in Postman or Mockoon, this engine executes code-driven assertions across network environments.
* **Core Tech:** Java 17, JUnit 5, REST-Assured, Hamcrest Matchers, Apache Maven.
* **Capabilities:** Automated network port evaluation, multi-service environment health checking, and end-to-end REST API JSON verification.

### 2. `ml-intelligence-core`
The analytical intelligence service layer. This system completely automates the traditional data science workflow through Java code execution.
* **Core Tech:** Java 17, Weka Machine Learning API, J48 Decision Tree Classifier.
* **Capabilities:** Autonomous ingestion of banking data logs (`.arff`), automatic model training loops, multi-fold cross-validation parsing, and lightweight HTTP server hosting on port `8100`.

---

## 📊 Automated Machine Learning Engine Model Performance

The autonomous training core processes simulated real-time banking transactions using structural metrics (Transaction Volume, Account Longevity, Geographic Inconsistencies) to classify operations.

Upon executing the pipeline, the engine calculates statistical splits and achieves automated inference accuracy:
* **Correctly Classified Instances:** 100.00%
* **Incorrectly Classified Instances:** 0.00%
* **Process Exit Execution Code:** `0` (Flawless Termination)

---

## 🛠️ Verification & Execution Blueprint

### Step 1: Initialize the Machine Learning Core
Compile the processing node and start the background API engine:
1. Open the `ml-intelligence-core` engine directory.
2. Execute `MlServerOrchestrator.java` via your IDE or runtime console.
3. Verify live listener confirmation:  
   `🚀 ML Core Service is running live as a background API! Listening on http://localhost:8100/api/v1/predict`

### Step 2: Fire the Integrated QA Framework Test Suite
With the server running, execute the automation overseer to pass traffic checks:
1. Open the `qa-testing-framework` engine directory.
2. Execute the `EnvironmentHealthTest.java` test runner.
3. Review terminal assertion output:  
   `🧠 Automating AI Pipeline Validation: Hitting Port 8100...`  
   `✅ Success! QA Framework successfully verified the Live Machine Learning Model on Port 8100!`
