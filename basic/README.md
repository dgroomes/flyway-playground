# basic

A simple Gradle and Java project that builds a database schema using Flyway.


## Overview

This codebase defines an example SQL schema, an example Java program that connects to the database (Postgres), and uses
Flyway to apply the schema to the database via a so-called *database  migration*. Flyway is invoked by way of the Flyway
Gradle plugin.


## Instructions

Follow these instructions to perform a database migration and run the sample program.

1. Use Java 17
2. Start the database
    * ```shell
      docker-compose up --detach
      ```
3. Run the database migration
    * ```shell
      ./gradlew flywayMigrate --info
      ```
    * The database tables and sample data were created!
    * Tons of stuff was logged to the screen unfortunately, but if you look closely you'll see something like:
      ```text
      ...omitted...
      Creating Schema History table "public"."flyway_schema_history" ...
      Migrating schema "public" to version "1 - observations-schema"
      Migrating schema "public" to version "2 - observations-data"
      Successfully applied 2 migrations to schema "public", now at version v2 (execution time 00:00.176s)
      ...omitted...
      ```
4. Run the Java program
    * ```shell
      ./gradlew run
      ```
    * Notice that the program successfully read from the table!
5. Stop the database
    * ```shell
      docker-compose down
      ```

