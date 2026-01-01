# School Bus Management System

## Overview
A Java console application for managing school bus transportation. The system allows schools to manage students, parents/guardians, and bus assignments with verification capabilities.

## Project Structure
```
├── overall.java     # Main entry point with CLI menus and program logic
├── Bus.java         # Bus entity with student pin tracking
├── Company.java     # Transportation company entity
├── School.java      # School entity with profile and bus management
├── Student.java     # Student entity
├── Parents.java     # Parent/guardian entity with notifications
├── Profile.java     # Family profile linking parents and students
└── .gitignore       # Java gitignore configuration
```

## How to Run
The project compiles and runs with:
```bash
javac *.java && java overall
```

## Features
- **School Menu**: Add/remove families, students, and buses; view info; send notifications
- **Adult Notifications**: View notifications for parents/guardians
- **Bus Driver Mode**: Verify students boarding correct buses using PIN system
- **Administrator Menu**: Manage companies and schools

## Technology
- Language: Java (GraalVM 22.3)
- Type: Console/CLI application
- Build: Direct javac compilation (no build system)

## Data Model
- Companies contain Schools
- Schools contain Profiles and Buses
- Profiles link Parents to Students
- Buses track student PINs for verification
