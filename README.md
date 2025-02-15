# Smart Contact Manager

Smart Contact Manager is a web-based application designed to securely store and manage your contacts. This project is built using **Spring Boot**, **Spring Security**, and **Hibernate**, with a **MERN** stack frontend integration.

## Features
- **User Authentication & Authorization**
- **Secure Contact Management**
- **Role-Based Access Control**
- **Responsive & User-Friendly UI**
- **Encrypted Passwords using Spring Security**
- **Admin Dashboard**

## Default Admin Credentials
To log in as an admin, use the following credentials:

- **Username:** `admin@gmail.com`
- **Password:** `admin`

⚠️ **Change the default admin password after the first login for security reasons.**

## Technologies Used
### Backend:
- **Spring Boot** (REST API)
- **Spring Security** (Authentication & Authorization)
- **Hibernate** (ORM for database management)
- **MySQL** (Relational Database)

### Frontend:
- **React.js** (UI Framework)
- **Redux** (State Management)
- **Bootstrap/Tailwind CSS** (Styling)

## Setup Instructions
### Prerequisites
Make sure you have the following installed:
- Java (JDK 11 or later)
- MySQL Database
- Node.js & npm (for frontend)

### Backend Setup
1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/smart-contact-manager.git
   cd smart-contact-manager
   ```
2. Configure the database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/scm
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   ```
3. Run the application:
   ```sh
   mvn spring-boot:run
   ```

### Frontend Setup
1. Navigate to the frontend directory:
   ```sh
   cd frontend
   ```
2. Install dependencies:
   ```sh
   npm install
   ```
3. Start the React development server:
   ```sh
   npm start
   ```

## API Endpoints
### Authentication
- `POST /api/auth/login` - Login
- `POST /api/auth/register` - Register new users

### Contacts Management
- `GET /api/contacts` - Fetch all contacts
- `POST /api/contacts` - Add new contact
- `DELETE /api/contacts/{id}` - Delete a contact

## Contributing
Feel free to fork this project and contribute to its development! Open an issue or create a pull request if you have any suggestions or improvements.

## License
This project is licensed under the **MIT License**.

---
🌟 **Happy Coding!** 🚀

