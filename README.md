# Mayank_K_Rastogi_hw3

*Proof of Concept to test referential integrity in Java RMI*

---

## Overview

This proof of concept demonstrates that the **Java RMI system maintains referential integrity**, i.e. if two references of the same object are passed to a remote method, the remote server will receive them as the same object.

## Methodology

- This project defines one class called `NumberWrapper` which wraps an integer value
- `ReferenceComparer` is a `trait`/`interface` for the remote object, which declares a method named `compare`, that takes in two parameters of type `NumberWrapper` and returns `true` if both the parameters refer to the same object

    `def compare(a: NumberWrapper, b: NumberWrapper): Boolean`
- `ReferenceComparerImplementation` is the implementation of `ReferenceComparer` on the server side. The `ReferenceComparerImplementationTest` class provides two test cases for testing the implemented `compare` method
- The server makes an instance of `ReferenceComparerImplementation` available for remote invocation using RMI
- The client application invokes the remote method `compare` of the remote object two times by passing the arguments as follows:
    1. **Two different instances of `NumberWrapper` &ndash;** The remote method returns `false` in this case, indicating that both the parameters it received were referencing two different objects
    2. **Same instance of `NumberWrapper` &ndash;** The remote method returns `true` in this case, indicating that both the parameters it received reference the same object
    
*This proves our premise that the Java RMI system maintains referential integrity at the remote end.*

## How to run?

1. Clone the repository or download and unzip the project
2. Open `command prompt` (if on Windows) or `terminal` (if on Linux/Mac)
3. Browse to the project directory
4. Build the project by issuing the following command:
    
    `> sbt clean compile`
5. Start the RMI registry and run the server application

    `> sbt startRegistry run`
    
6. Enter `2` to run the server when prompted
7. Repeat steps `2` and `3` and run the Client application using `sbt run`
8. Choose `1` this time to run the client application