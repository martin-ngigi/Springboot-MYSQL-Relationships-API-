# SPRINGBOOT API IN MYSQL RELATIONSHIPS
## Requirements
- youtube link -> https://www.youtube.com/watch?v=f5bdUjEIbrg&t=4s&ab_channel=KrisFoster
- jdk - version 19
- Intellij
- Database -> MYSQL (XAMP) i.e. port 3306

- initializer url -> https://start.spring.io/

## mvn commands
- mvn clean
- mvn clean compile
- mvn test

## Tomcat
- Tomcat port: 8080

## Solving plugin errors:
- Now lets say I had 10 such plugins which didn't get resolve and among them the first was 'org.apache.maven.plugins:maven-site-plugin' I went to '.m2/repository/org/apache/maven/plugins/' and deleted the directory 'maven-site-plugin' and did a maven reimport again. Guess what, particular missing plugin got dowloaded. And I just followed similar steps for other missing plugins and all got resolved.
- link -> https://stackoverflow.com/questions/20496239/maven-plugins-can-not-be-found-in-intellij

## NB : 
- While opening the project in IDEA such as Intellij IDEA, open the last 'mongo-relationships' file


## Killing a process in cmd:
- First determine process id occupied by that port i.e. port 8080 by running:<br>

      netstat -ano | findstr :8080
- Then kill the process

      netstat -ano | findstr :8080

## Layers 
- API layer - Controller (Contains GET, POST, PUT, DELETE)
- Service Layer - Business logic
- Data Access Layer - 

## API Layer
![SpringBootLayers](images/SpringBootLayers.PNG)

## Relationships:
### Subject...
- A subject can have many students
- A subject has one teacher

### Student...
- A student can have many subjects

### Teacher...
- A teacher can have many subjects

#### Student and Subject:
- The relationship is ManyToMany as a student can have many subjects and a subject can have many students.

## API
### Student
1. POST -> Create student:
- endpoint -> http://localhost:8080/api/v1/students
- body:

        {
          "name":"Martin"
        }
- response:

        {
          "id": 1,
          "name": "Martin"
        }
2. GET -> Retrieve all students:
- endpoint -> http://localhost:8080/api/v1/students
- response:

       [
         {
           "id": 1,
           "name": "Martin"
         },
         {
           "id": 2,
           "name": "Ken"
         }
       ]


### Subject
1. POST -> Create subject:
- endpoint -> http://localhost:8080/api/v1/subjects
- body:

        {
          "name":"Math"
        }
- response:

        {
          "id": 1,
          "name": "Math"
        }
2. GET -> Retrieve all subjects:
- endpoint -> http://localhost:8080/api/v1/subjects
- response:

       [
         {
           "id": 1,
           "name": "Math"
         },
         {
           "id": 2,
           "name": "English"
         }
       ]

### Teacher
1. POST -> Create teacher:
- endpoint -> http://localhost:8080/api/v1/teachers
- body:

        {
          "name":"Martin"
        }
- response:

        {
          "id": 1,
          "name": "Martin"
        }
2. GET -> Retrieve all teachers:
- endpoint -> http://localhost:8080/api/v1/teachers
- response:

       [
         {
           "id": 1,
           "name": "Martin"
         },
         {
           "id": 2,
           "name": "Ken"
         }
       ]

## RELATIONSHIPS
### Student and Subject Relationship(Many to many)
1. POST -> Create student:
- endpoint -> http://localhost:8080/api/v1/students
- body:

        {
          "name":"Simon"
        }
- response:

        {
          "id": 3,
          "subjects": [],
          "name": "Simon"
        }

2. POST -> Create subject:
- endpoint -> http://localhost:8080/api/v1/subjects
- body:

        {
          "name":"Kiswahili"
        }
- response:

        {
          "id": 3,
          "enrolledStudents": [],
          "name": "Kiswahili"
        }

3. PUT -> Enroll Student to subject
   NB: No Body request
- detailed endpoint -> http://localhost:8080/api/v1/subjects/1/students/1/{subjectId}/students/{studentId}
- endpoint -> http://localhost:8080/api/v1/subjects/1/students/1
- response:

        {
          "id": 1,
          "enrolledStudents": [
            {
              "id": 1,
              "name": "Martin"
            },
            {
              "id": 2,
              "name": "Ken"
            }
          ],
          "name": "English"
        }
4. GET -> Retrieve all subjects:
- endpoint -> http://localhost:8080/api/v1/subjects
- response:

       [
         {
           "id": 1,
           "name": "Math"
         },
         {
           "id": 2,
           "enrolledStudents": [
             {
               "id": 1,
               "name": "Martin"
             },
             {
               "id": 2,
               "name": "Ken"
             }
          ],
           "name": "English"
         }
       ]

### Teacher and subject(One To Many). i.e. A teacher can have many subjects but a subject can have only one teacher.
1. POST -> Create subject:
- endpoint -> http://localhost:8080/api/v1/subjects
- body:

        {
          "name":"Geography"
        }
- response:

        {
          "id": 4,
          "enrolledStudents": [],
          "teacher": null,
          "name": "Geography"
        }
2. PUT -> Assign Teacher to Subject
NB: No Body request
- detailed endpoint -> http://localhost:8080/api/v1/subjects//{subjectId}/teacher/{teacherId}
- endpoint -> http://localhost:8080/api/v1/subjects/1/teacher/1
- response:

        {
          "id": 1,
          "enrolledStudents": [
            {
              "id": 1,
              "name": "Martin"
            },
            {
              "id": 2,
              "name": "Ken"
            }
          ],
          "teacher": {
            "id": 1,
            "name": "Mr Martin"
          },
          "name": "English"
        }


3. GET -> Retrieve all subjects:
- endpoint -> http://localhost:8080/api/v1/subjects
- response:

       [
         {
           "id": 1,
           "name": "Math"
         },
         {
           "id": 2,
           "enrolledStudents": [
             {
               "id": 1,
               "name": "Martin"
             },
             {
               "id": 2,
               "name": "Ken"
             }
          ],
          teacher": {
            "id": 1,
            "name": "Mr Martin"
          },
           "name": "English"
         }
       ]

4. GET -> Retrieve all teachers:
- endpoint -> http://localhost:8080/api/v1/subjects
- response:
![SpringBootLayers](images/Get all teachers.PNG)