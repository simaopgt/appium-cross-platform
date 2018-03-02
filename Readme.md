https://travis-ci.org/simaopgt/appium-cross-platform.svg?branch=master

## Appium Cross Platform Simple Project

*This project is a simple example of how to use Appium to test iOS and Android apps with the same codebase. Also, this project is a example of how you can start the Appium Service and the Emulator (Android or iOS) programmatically.*

**Pre Requirements**

1. Appium 1.7.2+ installed via node
  - **npm install appium**
2. Android Studio 3.0.1+ installed
3. Android and Java environments variables configured
4. An AVD with Nexus 6 and API 27 x86 created
5. Xcode 9.2+ installed

**Setup and Run**

1. Clone the project
  - **git clone https://github.com/simaopgt/appium-cross-platform.git**
2. Import this project as a maven project in e.g. IntelliJ or Eclipse.
5. With the terminal, go to the project directory
  - **cd /Users/username/workspace/appium-cross-platform** 
6. Run the tests on IOS with the following command on terminal :
  - **mvn test -DOS=IOS**
7. Run the tests on ANDROID with the following command on terminal:
  - **mvn test -DOS=ANDROID**
 
 
----------


  
