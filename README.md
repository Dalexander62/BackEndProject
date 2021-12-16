
# Hobby Project - Dan Robinson


## Contents

    Resources
    Brief
    Scrum Kanban Board
    Database
    Backend
    Testing
    Frontend
    Continued Development

## Resources

    Presentation - google slides
    Scrum Board - Atlassian - https://danielalexadner.atlassian.net/jira/software/projects/HP/boards/4/backlog

## Brief

The brief for this project was to create a CRUD application with the utilisation of supporting tools, methodologies and technologies that encapsulate all core modules covered during training. This project involves concepts from all of the core training modules:

    Project Management
    Databases
    Java SE
    Spring Boot
    Frontend Development

## Project Management

First, I created a list of features for my app and prioritised them using the MoSCow method, and put the features required for the application to meet the minimum viable product under the must have column.


In order to manage my project, I used Jira Software to create an Agile Scrum Board. I used this to create User stories, Epics, and tasks based on the features I wanted my application to have. I provided each of these epics, user stories and tasks with story point estimates to help me judge how much work I had remaining.


## Version Control

I used GitHub as a Version Control System for this application. I created two public repositories one for the backend code and one for the frontend code. I created branches off the develop branch in order to track and manage changes to my code, whilst ensuring that I always maintained a working version which I could go back to if needed.

(Unable to upload network graphs) 

### Databases and Postman

I used a local H2 database for the testing of my application as it doesn’t persist data.

![h2](https://github.com/Dalexander62/BackEndProject/blob/main/Hobby%20Project%20Docs/h2-screenshot%20-%20Copy.png)

I used a ufc_fighter.schema.sql to create and drop this table between each test, I also used a game-data.sql to insert a specific record into the database for each test so that I knew exactly what the database would contain at the beginning and end of each test.

I used a MySQL database for production purposes as it persists data:

![sql](https://github.com/Dalexander62/BackEndProject/blob/main/Hobby%20Project%20Docs/sql.png)

Here is an ERD for the structure of both of my databases:

![ERD](https://github.com/Dalexander62/BackEndProject/blob/main/Hobby%20Project%20Docs/ERD.png)

I used Postman to help me establish that my requests were working correctly: 

![Postman](https://github.com/Dalexander62/BackEndProject/blob/main/Hobby%20Project%20Docs/postman.png)


## Backend

I used a Spring Boot Framework to create a Java application. By using this framework I was able to connect the database, the backend and the frontend effectively within one application. I was able to set up both databases within Spring Boot, as well as create the HTTP requests for the frontend.


I created a number of both integration and unit tests for my backend application. As shown below is my vcreate test as an example:
![test](https://github.com/Dalexander62/BackEndProject/blob/main/Hobby%20Project%20Docs/create-test.png)

Here below is the coverage for these tests: 

![coverage](https://github.com/Dalexander62/BackEndProject/blob/main/Hobby%20Project%20Docs/coverage-test.png)


## Frontend



#### Design

Before setting out on writing my code, I designed a simple wireframe diagram to give an outline of how I wanted my website to look:
![wireframe](https://github.com/Dalexander62/BackEndProject/blob/main/Hobby%20Project%20Docs/wireframe.png)


I created the layout of the web page using HTML, and implement JavaScript into the web page to make it more interactive for the user. I then used CSS and utilised Bootstrap to change the layout and overall look whilst adding a background image. I used JavaScript to integrate an API so the user can implement the CRUD functionality.

Below are a couple of snippets showing my final website.
![web1](https://github.com/Dalexander62/BackEndProject/blob/main/Hobby%20Project%20Docs/website1.png)
![web2](https://github.com/Dalexander62/BackEndProject/blob/main/Hobby%20Project%20Docs/website2.png)


## Continued Development 

I will be developing my project further, and focusing on these aspects:

    Creating a modal and/or toast using Bootstrap to have a form which updates the fighter entries rather than having the user fill in the create fighter form.
    I would add more tables and seperate fighters into their respective divisions so that it is easier for the user to establish where the fighters are.
    I would add further styling, add images that represent each fighter and make the cards more interactive.
