### Overview:

The Book Service is a component designed to facilitate CRUD (Create, Read, Update, Delete) operations on books within a larger system. It works in conjunction with the Borrow Service to manage book availability statuses.

### Components:

1. **Book Service**: Responsible for CRUD operations related to books.
2. **Borrow Service**: Manages the borrowing status of books and communicates with the Book Service for updates.

### Technologies Used:

- Java
- Spring Boot
- OpenFeign (for communication between services)
- Lombok
- H2 Database
- Netflix Eureka Server (for service registration and monitoring)
- Microservices Architecture

### Functionality:

1. **CRUD Operations**:
    - **Create**: Allows adding new books to the system.
    - **Read**: Enables fetching details of books including availability status.
    - **Update**: Supports modifying book details and availability status.
    - **Delete**: Permits removing books from the system.

2. **Communication with Borrow Service**:
    - Utilizes OpenFeign client for seamless communication with the Borrow Service.
    - Updates the availability status of books in real-time based on borrow requests and returns.

### How It Works:

1. **Book Service**:
    - Exposes REST endpoints for CRUD operations on books.
    - Maintains a database or storage mechanism to persist book records.
    - Upon receiving requests, it processes CRUD operations internally and updates the status of books in the database.
    - Utilizes OpenFeign client to communicate with the Borrow Service for updating book availability.

2. **Borrow Service**:
    - Manages borrowing transactions including checking out and returning books.
    - Communicates with the Book Service to update book availability status when books are borrowed or returned.

### Usage:

1. **Book Service Endpoints**:
    - `/books`:
        - `GET`: Retrieve all books.
        - `POST`: Add a new book.
    - `/books/{id}`:
        - `GET`: Retrieve details of a specific book.
        - `PUT`: Update details of a specific book.
        - `DELETE`: Remove a book from the system.
          I apologize for the oversight. Here's the updated section with the Borrow Service endpoints included in the previous response:

### Usage:

1. **Endpoints**:
    - `/books`:
        - `GET`: Retrieve all books.
        - `POST`: Add a new book.
        - `PUT`: Update details of a specific book.
        - `DELETE`: Remove a book from the system.
    - `/borrow/books`:
        - `GET`: Retrieve all borrowed books.
    - `/borrow/updateAvailability/{id}?status={status}`:
        - `PUT`: Update the availability status of a book. For example: `/borrow/updateAvailability/10?status=borrowed`.

2. **Interacting with Borrow Service**:
    - When a book is borrowed or returned, the Borrow Service communicates with the Book Service to update the availability status.
    - Book availability status is updated dynamically in response to borrow requests.


### Setup:

1. Clone the repository containing the Book Service code.
2. Ensure Java and Maven are installed.
3. Configure the application properties to specify the connection details for the database and Borrow Service.
4. Build and run the Book Service application.
5. Ensure the Borrow Service is also running and accessible.
6. Test the endpoints and functionality to ensure proper operation.