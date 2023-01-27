# flyway-playground

📚 Learning and exploring Flyway, the Java-based database migration tool.

> Database Migrations Made Easy.
> 
> --<cite> https://github.com/flyway/flyway/ </cite>


## Overview

This codebase is my way of learning Flyway and building a corpus of runnable reference code.

**NOTE**: This project was developed on macOS. It is for my own personal use.


## Standalone subprojects

This repository illustrates different concepts, patterns and examples via standalone subprojects. Each sub-project is
completely independent of the others and do not depend on the root project. This _standalone sub-project constraint_
forces the subprojects to be complete and maximizes the reader's chances of successfully running, understanding, and
re-using the code.

The subprojects include:


### `basic/`

A simple Gradle and Java project that builds a database schema using Flyway.

See the README in [basic/](basic/).


## Wish List

General clean-ups, TODOs and things I wish to implement for this project:

* [ ] IN PROGRESS Consider creating a `basic/` and an `advanced/` subproject. I want to keep the basic stuff optimized for getting
  up running. In `advanced/` I want to do stuff like create a custom Java-based migration, andy maybe explore idempotent
  things like repeatable migrations. And other features I'm not considering.
  * [x] DONE Create a `basic/` subproject.

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
