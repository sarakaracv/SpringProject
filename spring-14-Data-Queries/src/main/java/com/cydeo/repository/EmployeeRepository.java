package com.cydeo.repository;

import com.cydeo.entity.Department;
import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.support.lob.TemporaryLobCreator;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    //Display all employees with email address ""
    List<Employee> findByEmail(String email);

    //Display all employees with firstname "" and last name "",
    //also show all employees with an email address ""
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstname,String lastname,String email);

    //Display all employees that first name is not ""
    List<Employee> findByFirstNameIsNot(String firstname);

    //Display all employees where last name starts with ""
    List<Employee> findByLastNameStartsWith(String pattern);

    //Display all employees with salaries higher than ""
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //Display all employees with salaries less than ""
    List<Employee> findBySalaryLessThan(Integer salary);

    //Display all employees that has been hired between "" and ""
    List<Employee> findByHireDateBetween(LocalDate startDate,LocalDate endDate);

    //Display all employees where salaries greater and equal to "" in order-salary
    List<Employee> findBySalaryGreaterThanEqualOrderBySalary(Integer salary);

    //Display top unique 3 employees that is making less than ""
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //Display all employees that do not have email address
    List<Employee> findByEmailIsNull();


    @Query("SELECT employee FROM Employee employee WHERE employee.email='amcnee1@google.es'")
    Employee retrieveEmployeeDetail();


    @Query("SELECT e.salary FROM Employee e WHERE e.email='amcnee1@google.es'")
    Integer retrieveEmployeeSalary();

    // Not Equal
    @Query("SELECT e FROM Employee e WHERE e.salary <> ?1 ")
    List<Employee> retrieveEmployeeSalaryNotEqual(int salary);

    // Like / Contains / Startswiths / Endswith

    @Query ("SELECT e FROM Employee e WHERE e.firstName LIKE ?1 ")
    List <Employee> retrieveEmployeeFirstNameLike(String pattern);

    //less than
    @Query ("SELECT e FROM Employee e WHERE e.salary < ?1 ")
    List<Employee> retrieveEmployeeSalaryLessThan(int salary);

    // greater than show first name
    @Query ("SELECT e.firstName FROM Employee e WHERE e.salary > ?1 ")
    List<String> retrieveEmployeeSalaryGreaterThan(int salary);

    //between
    @Query ("SELECT e FROM Employee e WHERE e.salary between ?1 and ?2 ")
    List<Integer> retrieveEmployeeSalaryBetweenThan(int salary1, int salary2);

    //BEFORE

    @Query ("SELECT e FROM Employee e WHERE e.hireDate > ?1 ")
    List<Integer> retrieveEmployeeHireDateBefore (LocalDate date);

    //NULL
    @Query ("SELECT e FROM Employee e WHERE e.email IS NULL")
    List<Employee> retrieveEmployeeIsNull();
    //  NOT NULL
    @Query ("SELECT e FROM Employee e WHERE e.email IS NOT NULL")
    List<Employee> retrieveEmployeeIsNotNull();

    //Sorting in desc Order
    @Query ("SELECT e FROM Employee e order by e.salary desc ")
    List<Employee> retrieveEmployeeSalaryOrderDesc();

    //Sorting in asc Order
    @Query ("SELECT e FROM Employee e order by e.salary ")
    List<Employee> retrieveEmployeeSalaryOrderAsc();


    //Native Query
    @Query (value= "SELECT * FROM employees WHERE salary = ?1 ", nativeQuery=true)
    List<Employee> retrieveEmployeeDetailBySalary(int salary);

  // Named Parameter

    @Query("SELECT e FROM Employee e WHERE e.salary = :salary")
    List<Employee> retrieveEmployeeSalary(@Param("salary") int salary);
















}
