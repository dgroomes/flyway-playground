plugins {
    application
    id("org.flywaydb.flyway") version "9.11.0" // Flyway releases: https://github.com/flyway/flyway/releases
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.slf4j.api)
    implementation(libs.slf4j.simple)
    implementation(libs.postgres.jdbc)
}

application {
    mainClass.set("dgroomes.App")
}

flyway {
    url = "jdbc:postgresql:postgres"
    user = "postgres"
    locations = arrayOf("filesystem:db-migrations")
}
