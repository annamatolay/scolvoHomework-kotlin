# Homework for Scolvo

Create an app what can retrive address as string (detailed task description isn't in the scope).

For the Unit test plan, check the Wiki 'Test Plan' section.

### Instruction

Unit testing with code coverage:
###### Ubuntu:
```
./gradlew jacocoTestReport
```
###### Windows:
```
gradlew.bat jacocoTestReport
```
After the command execution you can find test result here:

ktolin-scolvo-homework/build/reports/jacoco/test/html/com.palmatolay.scolvoHomework/index.html

**Note1:** Developed and tested under Linux Ubuntu (18.10)

**Note2:** For code coverage:
Complete Address data class testing wasn't in the scope. Only those tested what are used in the application.

### Tech stack

* Kotlin 1.3.11 (compiled to Java 1.8)
* JUnit 4.12
* Jacoco (code coverage generator)