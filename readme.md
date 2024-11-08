# Taller sobre Multi-threading en Java

**Nombre:** Santiago Andres Araque

**Caso de uso:** Callable y Future

### Ejecucion: mvn compile
```bash
mvn compile
mvn exec:java
# o
mvn exec:java -Dexec.mainClass="com.example.App"
```

### Resultado Codigo: 
```
[INFO] Scanning for projects...
[INFO] 
[INFO] --------------------< com.example:multi-threading >---------------------
[INFO] Building multi-threading 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- exec:3.0.0:java (default-cli) @ multi-threading ---
Withdrew: 150.0, New Balance: 850.0
Withdrew: 100.0, New Balance: 750.0
Deposited: 200.0, New Balance: 950.0
Deposited: 300.0, New Balance: 1250.0
Transaction result: Deposited 200.0
Withdrew: 700.0, New Balance: 550.0
Transaction result: Withdrew 150.0
Transaction result: Withdrew 100.0
Transaction result: Deposited 300.0
Withdrew: 500.0, New Balance: 50.0
Transaction result: Withdrew 500.0
Deposited: 400.0, New Balance: 450.0
Transaction result: Deposited 400.0
Transaction result: Withdrew 700.0
Final Balance: 450.0
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.978 s
[INFO] Finished at: 2024-11-08T16:37:28-05:00
[INFO] ------------------------------------------------------------------------
```
