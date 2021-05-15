##### Steps

###### Connecting from local application to GCP cloud SQL instance
1. Create Spring Boot project
2. Create a project in GCP using cloud console.
3. Create DB instance, database and table using below procedure.
    3.a. In the Cloud Shell enable Cloud SQL Administration API.
    >gcloud services enable sqladmin.googleapis.com     

    3.b. Provision a new Cloud SQL instance
    >gcloud sql instances create demoapp --region=us-central1
    
    3.c. Create a `registration` database in the MySQL instance
    >gcloud sql databases create registration --instance demoapp
   
    3.d. Use CLI to connect to the database
    >gcloud sql connect guestbook
   * Root  password is blank by default.
    
    3.e. Switch to the demoapp database
    >use demoapp
    
    3.f.  Create the table
    ```
   CREATE TABLE users (
   id BIGINT NOT NULL AUTO_INCREMENT,
   name CHAR(128) NOT NULL,
   PRIMARY KEY (id)
   );

4. Application changes.
  
   4.1. Add the below dependencies to pom.xml
    ```xml
     <dependency>
         <groupId>org.springframework.cloud</groupId>
         <artifactId>spring-cloud-gcp-starter</artifactId>
      </dependency>
      <dependency>
         <groupId>org.springframework.cloud</groupId>
         <artifactId>spring-cloud-gcp-starter-sql-mysql</artifactId>
      </dependency>

   
  4.2. Add the below properties in application-cloud.properties.

      spring.cloud.gcp.sql.enabled=true
      spring.cloud.gcp.sql.database-name=messages
      spring.cloud.gcp.sql.instance-connection-name=YOUR_INSTANCE_CONNECTION_NAME
      spring.datasource.hikari.maximum-pool-size=5

5. Run the application with cloud profile.

###References
* https://mydeveloperplanet.com/2019/04/10/deploy-spring-boot-app-to-gcp-app-engine/
* https://cloud.google.com/appengine/docs/standard/java/maven-reference
* https://cloud.google.com/sdk/docs/quickstart
* https://cloud.google.com/sql/docs/postgres/connect-admin-ip
* https://cloud.google.com/sql/docs/postgres/quickstart
* https://cloud.google.com/docs/authentication/production
* https://cloud.google.com/docs/authentication/production#windows
* https://cloud.google.com/iam/docs/impersonating-service-accounts#attaching-to-resources
* https://cloud.google.com/iam/docs/granting-changing-revoking-access
* https://stackoverflow.com/questions/48972977/unable-to-obtain-credentials-to-communicate-with-the-cloud-sql-api-remote-host/48973743
* https://cloud.google.com/sdk/auth_success
* https://codelabs.developers.google.com/codelabs/cloud-app-engine-springboot#8
* https://dzone.com/articles/spring-boot-and-postgresql
* https://www.baeldung.com/spring-boot-google-app-engine