# Social Media Platform README

## Overview

This is a Social Media Platform application built using Spring Boot and REST services. Users can create profiles, post updates, follow other users, and send messages. The system also integrates with Amazon S3 for storing user-generated content.

## Features

- User Registration: Users can create profiles by registering with a username, email, and password.
- Post Updates: Users can create and post updates to their timeline.
- Follow Other Users: Users can follow other users to see their updates on their timeline.
- Messaging System: Users can send and receive messages from other users.
- Cloud Storage Integration: User-generated content, such as images, is stored in Amazon S3.

## Getting Started

### Prerequisites

- Java JDK (11 or later)
- Maven
- Amazon S3 account (for cloud storage)

### Installation

1. Clone the repository: `git clone [repository-url]`
2. Navigate to the project directory: `cd social-media-platform`
3. Build the project: `mvn clean install`
4. Run the application: `mvn spring-boot:run`

## Configuration

### AWS S3 Configuration

1. Set up an Amazon S3 bucket for storing user-generated content.
2. Configure AWS credentials in the application properties or programmatically.

   ```properties
   aws.accessKeyId=your-access-key-id
   aws.secretKey=your-secret-key
   aws.region=your-region
   aws.s3.bucket-name=your-s3-bucket-name
## Usage
1. Register a new user using the /api/users/register endpoint.
2. Post updates using the /api/posts/create endpoint.
3. Follow and unfollow users using the /api/users/follow/{followerId}/{followingId} and /api/users/unfollow/{followerId}/{followingId} endpoints.
4. Send messages using the /api/messages/send endpoint.
5. Retrieve user timelines and messages using the /api/users/timeline/{userId} and /api/users/messages/{userId} endpoints.
## Endpoints
* User Endpoints:

   * /api/users/register (POST): Register a new user.
   * /api/users/follow/{followerId}/{followingId} (POST): Follow a user.
   * /api/users/unfollow/{followerId}/{followingId} (POST): Unfollow a user.
   * /api/users/timeline/{userId} (GET): Retrieve user timeline.
   * /api/users/messages/{userId} (GET): Retrieve user messages.

* Post Endpoints:

  * /api/posts/create (POST): Create a new post.
* Message Endpoints:
  * /api/messages/send (POST): Send a message.
  * /api/messages/retrieve/{userId} (GET): Retrieve user messages.

## Testing
Run unit tests: 
```bash 
mvn test
```
Use tools like Postman to test API endpoints.
## Test Coverage

Check the test coverage using the following command:

```bash
./mvnw test jacoco:report 
``` 

View the coverage report in the target/site/jacoco directory (Maven) or build/reports/jacoco directory (Gradle).

## Code Quality

Run SonarQube analysis to check code quality:

```bash
./mvnw sonar:sonar
``` 
## Conversation Logs

ChatGPT conversation logs are available in the file [chat.log](src/main/resources/chat.log).
Conversation link:https://chat.openai.com/share/869c7894-777a-439c-ab5b-a8c659bd63c3

# Project Feedback

- **Was it easy to complete the task using AI?**
    - Absolutely, leveraging AI made the task significantly more straightforward.

- **How long did the task take you to complete?**
    - The task was completed in approximately 2 hour.

- **Was the code ready to run after generation? What did you have to change to make it usable?**
    - The generated code was ready to run; I made minor adjustments to the readme for clarity.

- **Which challenges did you face during completion of the task?**
    - The primary challenge revolved around formulating questions in a manner that AI could understand, leading to satisfactory responses.

## Contributing
Contributions are welcome! Please follow the Contribution Guidelines.