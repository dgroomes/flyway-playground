-- This is a SQL script that defines a table. SQL commands that create tables, columns and other structural data are
-- often called "Data Definition Language" commands. In some cases, the file name might even be suffixed with ".ddl"
-- instead of ".sql"
--
-- This file is also a legal Flyway database "migration" definition because of the file name. Specifically, the leading
-- "V" and the double-underscore ("__") help Flyway recognize this file. See https://flywaydb.org/documentation/concepts/migrations#sql-based-migrations

create table observations(
    description text not null,
    notes text[] not null
);
