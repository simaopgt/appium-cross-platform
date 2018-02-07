## Appium Cross Platform Simple Project

*This project is a simple example of how to use Appium to test iOS and Android apps with the same codebase.*

**Setup and Run**

1. Clone the project
2. Import this project as a maven project in e.g. IntelliJ or Eclipse.
3. Start the Appium Server
4. Create and start an AVD defined as a Nexus 5X device with the Android API 27 x86 OS.
5. Go to the project directory (e.g. cd foo/foo/appiumCrossPlatform)
6. Run the tests on IOS with following command:
  - **mvn test -DOperationalSystem=IOS**
7. Run the tests on ANDROID with the following command:
  - **mvn test -DOperationalSystem=ANDROID**
  
Appium Version 1.7.2 and Xcode Version 9.2


----------


  
