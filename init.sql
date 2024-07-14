-- Create the Department table
CREATE TABLE Department (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Create the Employee table with a foreign key reference to the Department table
CREATE TABLE Employee (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    salary VARCHAR(255),
    department_ID INTEGER,
    FOREIGN KEY (department_ID) REFERENCES Department(id)
);


-- Insert dummy data into the Department table
INSERT INTO Department (name) VALUES ('HR');
INSERT INTO Department (name) VALUES ('Engineering');
INSERT INTO Department (name) VALUES ('Marketing');

-- Insert dummy data into the Employee table
INSERT INTO Employee (name, salary, department_ID) VALUES ('John Doe', '50000', 1);
INSERT INTO Employee (name, salary, department_ID) VALUES ('Jane Smith', '60000', 2);
INSERT INTO Employee (name, salary, department_ID) VALUES ('Emily Johnson', '55000', 1);
INSERT INTO Employee (name, salary, department_ID) VALUES ('Michael Brown', '70000', 3);
INSERT INTO Employee (name, salary, department_ID) VALUES ('Jessica Davis', '65000', 2);
