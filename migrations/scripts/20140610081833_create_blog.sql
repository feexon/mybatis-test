--// @
-- Migration SQL that makes the change goes here.

CREATE TABLE blogs (
  id    INTEGER NOT NULL PRIMARY KEY,
  title VARCHAR(20)
);
INSERT INTO blogs VALUES (1, 'MyBatis');
INSERT INTO blogs VALUES (2, 'Java');
--//@UNDO
-- SQL to undo the change goes here.
DROP TABLE blogs;


