# flyway-playground

📚 Learning and exploring Flyway, the Java-based database migration tool.

> Database Migrations Made Easy.
> --<cite>https://github.com/flyway/flyway/</cite>

## Description

This codebase defines an example SQL schema (Postgres), an example Java program that conects to a database, and uses Flyway to apply the schema to the database via a so-called *database
migration*. Flyway is invoked by way of the Flyway Gradle plugin.    

## Instructions

Follow these instructions to perform a database migration and run the sample program.

1. Use Java 17
2. Start the database (Postgres)
   * `docker-compose up --detach`
3. Run the database migration
   * `./gradlew flywayMigrate --info`
   * The database tables and sample data were created!
   * Tons of stuff was logged to the screen unfortunately, but if you look closely you'll see something like:
     ```text
     Flyway Community Edition 8.5.0 by Redgate
     See what's new here: https://flywaydb.org/documentation/learnmore/releaseNotes#8.5.0
     
     Database: jdbc:postgresql:postgres (PostgreSQL 14.2)
     Successfully validated 2 migrations (execution time 00:00.007s)
     Creating Schema History table "public"."flyway_schema_history" ...
     Current version of schema "public": << Empty Schema >>
     Migrating schema "public" to version "1 - observations-schema"
     Migrating schema "public" to version "2 - observations-data"
     Successfully applied 2 migrations to schema "public", now at version v2 (execution time 00:00.176s)
     :flywayMigrate (Thread[Execution worker for ':',5,main]) completed. Took 0.535 secs.
     ```
4. Run the Java program
   * `./gradlew run`
   * Notice that the program successfully read from the table! 

## Reference

* [Flyway documentation](https://flywaydb.org/documentation/)
* [Flyway docs: "SQL-based migrations"](https://flywaydb.org/documentation/concepts/migrations#sql-based-migrations)
  > Migrations are most commonly written in SQL. This makes it easy to get started and leverage any existing scripts,
  > tools and skills. It gives you access to the full set of capabilities of your database and eliminates the need to
  > understand any intermediate translation layer.
  * This is a pragmatic approach in my opinion. I compare it to Liquibase where it's common (recommended?) to define
    migrations in the Liquibase language (well, config). I eventually settled on SQL-based migrations in Liquibase after
    some time. I think this is "the way".
  * The Flyway docs are great!
