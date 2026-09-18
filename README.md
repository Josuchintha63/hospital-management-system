# Hospital Management System

A Java 21 console application for managing patient billing and insurance coverage.

---

## Requirements
- Java 21+
- Apache Maven 3.8+

---

## How to Build & Run
```bash
mvn clean compile
mvn exec:java
```

---

## Running Tests
```bash
mvn test
```

---

## Issue Tracking & Git Workflow

### Jira Workspace: [Hospital Management System (HMS)](https://chinthajyoshna.atlassian.net/browse/HMS-1)
- **Ticket Key**: `HMS-1`
- **Summary**: Fix Patient Billing insurance discount and medicine tax calculation bug
- **Status**: Resolved / In Progress
- **Branch**: `HMS-1` & `HMS-123`

### Commit History for HMS-1:
1. `test(HMS-1): add unit tests reproducing insurance discount and fee validation bugs`
2. `fix(HMS-1): implement input validation for consultation fee and medicine costs`
3. `fix(HMS-1): correct insurance coverage percentage formula and boundaries`
4. `refactor(HMS-1): enhance invoice formatting and interactive insurance prompts`
5. `docs(HMS-1): update README with bug resolution details, test results, and Jira ticket HMS-1`

---

## GitHub Repository
- **Owner**: [Josuchintha63](https://github.com/Josuchintha63)
- **Repository**: [https://github.com/Josuchintha63/hospital-management-system](https://github.com/Josuchintha63/hospital-management-system)
