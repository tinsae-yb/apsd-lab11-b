<h1>First Part</h1>
<h3> Building Image for attached demo-java-cli-application </h3>

![Screenshot 2024-04-20 at 6.21.32 PM.png](screenshots%2FScreenshot%202024-04-20%20at%206.21.32%E2%80%AFPM.png)

<h3> running the application </h3>

![Screenshot 2024-04-20 at 6.23.41 PM.png](screenshots%2FScreenshot%202024-04-20%20at%206.23.41%E2%80%AFPM.png)


<h1>Part two</h1>
<h2>Dockerizing my application from lab 7  </h2>
<h3> I used packeto builder to build my spring boot application image. I used the maven plugin</h3>
<h3>Notice I added the image tag inside build -> plugins -> configurations </h3>
<h3> The image tag defines the properties. like image name, packeto builder to use, in this case jammy, and jvm version </h3>

![Screenshot 2024-04-20 at 6.25.39 PM.png](screenshots%2FScreenshot%202024-04-20%20at%206.25.39%E2%80%AFPM.png)

<h2>Building the image</h2>
<h3> I used the command mvn spring-boot:build-image -DskipTests to build the image </h3>

![Screenshot 2024-04-20 at 6.29.42 PM.png](screenshots%2FScreenshot%202024-04-20%20at%206.29.42%E2%80%AFPM.png)

<h3> Configuring docker compose file </h3>

```yaml
services:
  lab10:
    image: "my-image-lab10"
    ports:
      - "8080:8080"
    depends_on:
      - mysql
    environment:
      - SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/lab10
      - SPRING_DATASOURCE_USERNAME=lab10-user
      - SPRING_DATASOURCE_PASSWORD=lab10-password
      - SPRING_JPA_HIBERNATE_DDL_AUTO=create
      - SPRING_JPA_SHOW_SQL=true
      - SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT=org.hibernate.dialect.MySQLDialect

  mysql:
    image: "mysql:latest"
    ports:
      - "3306:3306"
    environment:
      - MYSQL_ROOT_PASSWORD=root
      - MYSQL_DATABASE=lab10
      - MYSQL_USER=lab10-user
      - MYSQL_PASSWORD=lab10-password

```

<h3> Running the application </h3>

```shell
docker-compose up --build
```

![Screenshot 2024-04-20 at 6.31.35 PM.png](screenshots%2FScreenshot%202024-04-20%20at%206.31.35%E2%80%AFPM.png)

<h3>Calling one of the endpoints </h3>

```shell
curl http://localhost:8080/adsweb/api/v1/patient/list
```

![Screenshot 2024-04-20 at 6.35.05 PM.png](screenshots%2FScreenshot%202024-04-20%20at%206.35.05%E2%80%AFPM.png)

