# Neo4JEmployeeAPI-Java

This repository contains a Java solution that build two Web API web services. The following tasks were completed:

  - Create an :Employee node with parameters: 1) String name; and 2) int emp_Id
  - Return all :Employee nodes
  - Deployed Neo4J Server here: http://neo4j-gmc.eastus.cloudapp.azure.com:7474/browser; password: Pass@word1. 
    - BTW, I don't typically put passwords in readme files :)
  
 To run the solution on a local environment, do the following:
 - clone the contents to a local directory
 - Open using Eclipse or Spring STS
 - Run the demo package. Capture the localhost port number from the Console Window. It will be needed to test the APIs
 - Open a tool such as Postman to test the APIs
  - Test Get All Employees: use GET; URI: http://localhost:8080/employees - use the port captured from the previous step
    - Add headers: Key: Content-Type; Value: application/json
  - Test Add Employee: use POST; URI: http://localhost:8080/employees - use the previously captured port
    - Add headers: Key: Content-Type; Value: application/json
    - Add body:  {"name": "<Employee Name>","emp_Id": <Employee Id>} - be sure to use an integer for the employee Id
    
The C# version can be found here: https://github.com/GeorgeCrossIV/Neo4JEmployeeAPI. This version is more complete as it also has a web interface. Information regarding the Neo4J server is in the readme.md file here: https://github.com/GeorgeCrossIV/Neo4JEmployeeAPI/blob/master/README.md. 
  
 
