// Given object
const sampleJson = {
    "company": {
      "employees": {
        "name": "abc",
        "payable": {
          "salary": 7000,
          "bonus": 800
        }
      }
    }
  };
  
  // Accessing and calculating total salary
  const salary = sampleJson.company.employees.payable.salary;
  const bonus = sampleJson.company.employees.payable.bonus;
  const totalSalary = salary + bonus;
  
  // Output total salary
  console.log("Total Salary: " + totalSalary);
  