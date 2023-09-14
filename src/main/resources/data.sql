INSERT INTO lecturer VALUES (2, 1, 'Ryan', 'Reynolds', 'Ryan Reynolds', 70000);
INSERT INTO lecturer VALUES (3, 0, 'Jake', 'Gyllenhall', 'Jake Gyllenhall', 100000);
INSERT INTO lecturer VALUES (4, 2, 'Bryan', 'Crenston', 'Bryan Crenston', 200000);
INSERT INTO lecturer VALUES (5, 0, 'Aaron', 'Paul', 'Aaron Paul', 50000);
INSERT INTO lecturer VALUES (6, 1, 'Ice', 'Cube', 'Ice Cube', 180000);
INSERT INTO lecturer VALUES (7, 0, 'Tuco', 'Salamanca', 'Tuco Salamanca', 90000);
INSERT INTO lecturer VALUES (8, 2, 'John', 'Wick', 'John Wick', 150000);
INSERT INTO lecturer VALUES (9, 1, 'Ivan', 'Petrenko', 'Ivan Petrenko', 100000);
INSERT INTO lecturer VALUES (10, 1, 'Petro', 'Ivanov', 'Petro Ivanov', 100000);

INSERT INTO department VALUES (2, 'Accounting', 2);
INSERT INTO department VALUES (3, 'Chemistry', 4);
INSERT INTO department VALUES (4, 'Fighting', 8);
INSERT INTO department VALUES (5, 'Cinematography', 10);

INSERT INTO lecturer_department VALUES (2, 2);
INSERT INTO lecturer_department VALUES (3, 2);
INSERT INTO lecturer_department VALUES (4, 3);
INSERT INTO lecturer_department VALUES (5, 3);
INSERT INTO lecturer_department VALUES (6, 4);
INSERT INTO lecturer_department VALUES (7, 4);
INSERT INTO lecturer_department VALUES (8, 4);
INSERT INTO lecturer_department VALUES (9, 5);
INSERT INTO lecturer_department VALUES (10, 5);

UPDATE department_seq SET next_val = 6 WHERE next_val = 2;
UPDATE lecturer_seq SET next_val = 11 WHERE next_val = 2;

SELECT * FROM lecturer;