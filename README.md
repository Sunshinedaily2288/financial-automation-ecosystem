# Financial Automation Ecosystem 🚀

A production-grade, distributed Java microservices ecosystem demonstrating automated software quality assurance seamlessly integrated with core transactional web applications and continuous Machine Learning (ML) inference pipelines. This architecture replicates automated fraud detection and real-time transaction processing pipelines common in modern financial and banking institutions.

---

## 🏛️ System Architecture Design

The ecosystem is engineered as three separate, decoupled modules to prevent library conflicts, ensure independent scalability, and match modern distributed cloud engineering standards.

```text
 ┌───────────────────────────┐
 │ Project 3: Banking App    │ ──► Operates live on Port 8105
 │ (Spring Boot Web Service) │     Main ledger processor. Routes incoming client transfers
 └─────────────┬─────────────┘     and initiates background handshakes for risk assessment.
               │
               ▼ (Dispatches real-time HTTP REST payload verification)
 ┌───────────────────────────┐
 │ Project 2: ML Engine      │ ──► Operates live on Port 8100
 │ (Weka Pipeline Service)   │     Processes raw banking records, trains classification
 └─────────────▲─────────────┘     models in-memory, and exposes predictive endpoints.
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

### 1. `core-banking-services`
The commercial front-end interface layer. Built using an enterprise framework, this application models transaction routing streams.
* **Core Tech:** Java 17, Spring Boot (Starter Web), Spring Framework, Apache Maven.
* **Capabilities:** Handles active financial REST endpoint requests, utilizes `RestTemplate` to establish cross-service internal loops, and serializes compound financial transaction structures into JSON maps on **Port 8105**.

### 2. `ml-intelligence-core`
The analytical intelligence service layer. This system completely automates the traditional data science workflow through programmatic Java code execution.
* **Core Tech:** Java 17, Weka Machine Learning API, J48 Decision Tree Classifier, Java `HttpServer`.
* **Capabilities:** Autonomous ingestion of banking data logs (`.arff`), automatic model training loops, multi-fold cross-validation parsing, and lightweight HTTP server hosting on **Port 8100**.

### 3. `qa-testing-framework`
The continuous integration and automation command center. Instead of manually clicking paths in Postman, this engine executes code-driven network assertions across running environments.
* **Core Tech:** Java 17, JUnit 5, REST-Assured, Hamcrest Matchers, Apache Maven.
* **Capabilities:** Automated network port evaluation, multi-service environment health checking, and end-to-end REST API JSON verification.

---

## 📊 Automated Machine Learning Engine Model Performance

The autonomous training core processes simulated real-time banking transactions using structural metrics (Transaction Volume, Account Longevity, Geographic Inconsistencies) to classify operations.

Upon executing the pipeline, the engine calculates statistical splits and achieves automated inference accuracy:
* **Correctly Classified Instances:** 100.00%
* **Incorrectly Classified Instances:** 0.00%
* **Process Exit Execution Code:** `0` (Flawless Termination)

---

## 🛠️ Verification & Execution Blueprint

### Step 1: Initialize the Machine Learning Core Engine
Compile the processing node and start the background API engine:
1. Open the `ml-intelligence-core` project.
2. Execute `MlServerOrchestrator.java` via your IDE.
3. Verify live listener confirmation:  
   `🚀 ML Core Service is running live as a background API! Listening on http://localhost:8100/api/v1/predict`

### Step 2: Spin Up the Core Banking Service
Launch the main web layer container to bind the transaction endpoint:
1. Open the `core-banking-services` project.
2. Execute `CoreBankingApplication.java` via your IDE.
3. Verify live server initialization log:  
   `Tomcat started on port 8105 (http) with context path ''`

### Step 3: Run the Live Real-Time Integration Verification
1. Open a browser or client tool and navigate to:  
   `http://localhost:8105/api/v1/banking/process-transaction`
2. Validate that the network handshake successfully returns a combined financial payload showing the live `aiVerificationReport` from Port 8100.

### Step 4: Fire the Integrated QA Framework Test Suite
With both services live, execute the automation overseer to pass traffic checks:
1. Open the `qa-testing-framework` project.
2. Execute the `EnvironmentHealthTest.java` test runner.
3. Review terminal assertion output:  
   `🧠 Automating AI Pipeline Validation: Hitting Port 8100...`  
   `✅ Success! QA Framework successfully verified the Live Machine Learning Model on Port 8100!`
