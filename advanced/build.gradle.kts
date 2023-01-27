import org.flywaydb.gradle.task.FlywayMigrateTask

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

tasks {

    // Usually, you would only have one "Flyway migration" Gradle task but in this project we need two different tasks
    // (and thus two different configurations (notice the JDBC URL)) because of a quirk in Flyway: https://stackoverflow.com/a/19830591
    //
    // Specifically, we create a task just to create the "mydb" database. Then, in the "normal" Flyway Gradle task/configuration
    // we do the rest of our migrations.
    val flywayBootstrapMigrate = create<FlywayMigrateTask>("flywayBootstrapMigrate") {
        url = "jdbc:postgresql:postgres"
        user = "postgres"
        locations = arrayOf("filesystem:db-bootstrap-migration")
    }

    flywayMigrate {
        dependsOn(flywayBootstrapMigrate)
    }
}

flyway {
    url = "jdbc:postgresql:mydb"
    user = "postgres"
    locations = arrayOf("filesystem:db-migrations")
}
