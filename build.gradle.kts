plugins {
    application
    id("org.flywaydb.flyway") version "8.5.0" // Flyway releases: https://github.com/flyway/flyway/releases
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

val slf4jVersion = "1.7.36" // SLF4J releases: http://www.slf4j.org/news.html
val postgresVersion = "42.3.3" // Postgres JDBC releases: https://jdbc.postgresql.org/ and https://search.maven.org/artifact/org.postgresql/postgresql

dependencies {
    implementation("org.slf4j:slf4j-api:$slf4jVersion")
    implementation("org.slf4j:slf4j-simple:$slf4jVersion")
    implementation("org.postgresql:postgresql:$postgresVersion")
}

application {
    mainClass.set("dgroomes.App")
}

flyway {
    url = "jdbc:postgresql:postgres"
    user = "postgres"
    locations = arrayOf("filesystem:db-migrations")
}
