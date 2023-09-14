INSERT INTO lecturer(id, degree, first_name, last_name, full_name, salary) VALUES (1, 2, 'Ryan', 'Gosling', 'Ryan Gosling', 150000);
INSERT INTO lecturer(id, degree, first_name, last_name, full_name, salary) VALUES (2, 1, 'Ryan', 'Reynolds', 'Ryan Reynolds', 70000);
INSERT INTO lecturer(id, degree, first_name, last_name, full_name, salary) VALUES (3, 0, 'Jake', 'Gyllenhall', 'Jake Gyllenhall', 100000);
INSERT INTO lecturer(id, degree, first_name, last_name, full_name, salary) VALUES (4, 2, 'Bryan', 'Crenston', 'Bryan Crenston', 200000);
INSERT INTO lecturer(id, degree, first_name, last_name, full_name, salary) VALUES (5, 0, 'Aaron', 'Paul', 'Aaron Paul', 50000);
INSERT INTO lecturer(id, degree, first_name, last_name, full_name, salary) VALUES (6, 1, 'Ice', 'Cube', 'Ice Cube', 180000);
INSERT INTO lecturer(id, degree, first_name, last_name, full_name, salary) VALUES (7, 0, 'Tuco', 'Salamanca', 'Tuco Salamanca', 90000);
INSERT INTO lecturer(id, degree, first_name, last_name, full_name, salary) VALUES (8, 2, 'John', 'Wick', 'John Wick', 150000);
INSERT INTO lecturer(id, degree, first_name, last_name, full_name, salary) VALUES (9, 1, 'Ivan', 'Petrenko', 'Ivan Petrenko', 100000);
INSERT INTO lecturer(id, degree, first_name, last_name, full_name, salary) VALUES (10, 1, 'Petro', 'Ivanov', 'Petro Ivanov', 100000);

INSERT INTO department(id, department_name, head_of_department_id) VALUES (1, 'Calculus', 1);
INSERT INTO department(id, department_name, head_of_department_id) VALUES (2, 'Accounting', 2);
INSERT INTO department(id, department_name, head_of_department_id) VALUES (3, 'Chemistry', 4);
INSERT INTO department(id, department_name, head_of_department_id) VALUES (4, 'Fighting', 8);
INSERT INTO department(id, department_name, head_of_department_id) VALUES (5, 'Cinematography', 10);

INSERT INTO lecturer_department(lecturer_id, department_id) VALUES (1, 1);
INSERT INTO lecturer_department(lecturer_id, department_id) VALUES (2, 2);
INSERT INTO lecturer_department(lecturer_id, department_id) VALUES (3, 2);
INSERT INTO lecturer_department(lecturer_id, department_id) VALUES (4, 3);
INSERT INTO lecturer_department(lecturer_id, department_id) VALUES (5, 3);
INSERT INTO lecturer_department(lecturer_id, department_id) VALUES (6, 4);
INSERT INTO lecturer_department(lecturer_id, department_id) VALUES (7, 4);
INSERT INTO lecturer_department(lecturer_id, department_id) VALUES (8, 4);
INSERT INTO lecturer_department(lecturer_id, department_id) VALUES (9, 5);
INSERT INTO lecturer_department(lecturer_id, department_id) VALUES (10, 5);

ALTER SEQUENCE DEPARTMENT_SEQ RESTART WITH 6;
ALTER SEQUENCE LECTURER_SEQ RESTART WITH 11;