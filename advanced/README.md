# advanced

An intermediate Flyway example project.


## Overview

Any given codebase has idiosyncrasies that make it more advanced, uncommon or just plain unusual compared to the "hello
world" examples that we usually see in tutorials. This project is an example of one of these deviations and it requires
that we use a more advanced configuration of Flyway than we did in the `basic/` project.

Consider that a default Postgres installation defines a database named "postgres", a user named "postgres" and a schema
named "public". This project defines its own database named "mydb" and its own schema named "myschema". Both of these
requirements take us through different techniques and options in Flyway.  


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
    * Tons of stuff was logged to the screen unfortunately, but if you look closely you'll see something like the
      following snippets.
    * ```text
      > Task :flywayBootstrapMigrate
      ...omitted...
      Database: jdbc:postgresql:postgres (PostgreSQL 15.1)
      Successfully validated 1 migration (execution time 00:00.010s)
      Creating Schema History table "public"."flyway_schema_history" ...
      Current version of schema "public": << Empty Schema >>
      Migrating schema "public" to version "1 - create-database-mydb" [non-transactional]
      Successfully applied 1 migration to schema "public", now at version v1 (execution time 00:00.067s)
      ```
    * ```text
      > Task :flywayMigrate
      ...omitted...
      Database: jdbc:postgresql:mydb (PostgreSQL 15.1)
      Successfully validated 3 migrations (execution time 00:00.003s)
      Creating Schema History table "public"."flyway_schema_history" ...
      Current version of schema "public": << Empty Schema >>
      Migrating schema "public" to version "1 - create-schema-myschema"
      Migrating schema "public" to version "2 - create-table-observations"
      Migrating schema "public" to version "3 - insert-data-observations"
      Successfully applied 3 migrations to schema "public", now at version v3 (execution time 00:00.039s)
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


## Wish List

General clean-ups, TODOs and things I wish to implement for this project:

* [ ] Add a custom Java-based migration. Ideally I want to define the migration in Gradle's `buildSrc` but I sense that
  Flyway is not designed to support that. I've done it in Liquibase.
* [ ] Can you put version numbers for Gradle plugins in the version catalog?
