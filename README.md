Fast Writing Game
A JavaFX-based typing game designed to improve typing speed and accuracy through progressive difficulty levels.

Description
Fast Writing Game is an interactive typing application that challenges players to type words and phrases correctly within time limits. The game features multiple difficulty levels, real-time statistics tracking, and a comprehensive user interface with multiple screens for navigation and performance analysis.

Features
Progressive Difficulty: 6 difficulty categories from beginner to legendary
Dynamic Timer: Starting at 20 seconds, decreasing every 5 levels
Multiple Game Screens: Menu, Rules, Game, Statistics, and Game Over
Performance Tracking: Comprehensive statistics including WPM, accuracy, and ratings
Modern UI: Attractive JavaFX interface with CSS styling
Navigation System: Seamless transitions between different screens
Game Mechanics
Difficulty Levels
Levels 1-10: Easy words (cat, dog, sun, moon...)
Levels 11-20: Medium words (computer, technology, education...)
Levels 21-30: Hard words (sophisticated, unprecedented...)
Levels 31-40: Expert words (antidisestablishmentarianism...)
Levels 41-50: Short phrases ("The quick brown fox jumps...")
Levels 51+: Complex phrases (programming concepts, etc.)
Timing System
Initial time limit: 20 seconds per level
Every 5 levels completed: time decreases by 2 seconds
Minimum time limit: 2 seconds per level
Scoring
Exact match required (case-sensitive)
Correct answer: Advance to next level
Wrong answer or timeout: Game Over
Performance ratings based on final level achieved
System Requirements
Java 17 or higher (Amazon Corretto recommended)
JavaFX 17 or higher
Maven 3.6 or higher
IntelliJ IDEA (recommended IDE)
Installation & Setup
Prerequisites
Install Java 17 (Amazon Corretto):
bash
# Download from: https://corretto.aws/downloads/latest/amazon-corretto-17-x64-windows-jdk.msi
Install Maven:
bash
# Download from: https://maven.apache.org/download.cgi
Clone or download the project files to your local machine
Project Structure
FastWritingGame/
├── pom.xml
├── README.md
├── src/main/java/
│   ├── module-info.java
│   └── com/fastwriting/
│       ├── app/
│       │   └── Main.java
│       ├── controller/
│       │   ├── GameController.java
│       │   ├── MenuController.java
│       │   ├── RulesController.java
│       │   ├── StatisticsController.java
│       │   └── GameOverController.java
│       ├── model/
│       │   ├── WordGenerator.java
│       │   └── GameStatistics.java
│       └── util/
│           └── SceneManager.java
└── src/main/resources/
├── css/
│   └── styles.css
└── fxml/
├── menu-view.fxml
├── rules-view.fxml
├── game-view.fxml
├── statistics-view.fxml
└── gameover-view.fxml
Running the Project
Using Maven (Recommended)
Open terminal/command prompt in the project root directory
Compile the project:
bash
mvn clean compile
Run the application:
bash
mvn javafx:run
Using IntelliJ IDEA
Open IntelliJ IDEA
File → Open → Select the project directory
Wait for Maven to import dependencies
Right-click on Main.java → Run 'Main.main()'
Alternative IntelliJ Setup
If direct run doesn't work:

Run → Edit Configurations
Add new Application configuration:
Main class: com.fastwriting.app.Main
Module: select your project module
VM options (if needed): --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml
Building JAR File
bash
mvn clean package
The executable JAR will be created in the target/ directory.

Generating Documentation
bash
mvn javadoc:javadoc
HTML documentation will be generated in target/javadoc/

Game Controls
Text Input: Type in the input field
Submit: Press Enter or click Submit button
Restart: Click Restart button to begin a new game
End Game: Click End Game to finish and view statistics
Navigation: Use menu buttons to navigate between screens
Performance Ratings
Beginner Typist: Levels 1-9
Intermediate Typist: Levels 10-19
Advanced Typist: Levels 20-29
Expert Typist: Levels 30-39
Master Typist: Levels 40-49
Legendary Typist: Level 50+
Troubleshooting
Common Issues
"The file in the editor is not runnable"
Ensure project is imported as Maven project
Refresh/reload Maven project
Check that src/main/java is marked as Sources Root
Check that src/main/resources is marked as Resources Root
JavaFX Runtime Components Missing
Ensure JavaFX dependencies are properly loaded
Use mvn javafx:run instead of direct execution
Check VM arguments in run configuration
FXML Loading Errors
Verify all FXML files are in correct locations
Check that CSS file is properly referenced
Ensure controller classes are properly specified in FXML
Maven Compilation Errors
Verify Java 17 is installed and configured
Check Maven settings and dependencies
Run mvn clean install to refresh dependencies
Getting Help
If you encounter issues:

Check the console/terminal for error messages
Verify all files are in correct directories
Ensure all dependencies are properly installed
Try cleaning and rebuilding the project: mvn clean compile
Technical Details
Language: Java 17
Framework: JavaFX 17
Build Tool: Maven
Architecture: Model-View-Controller (MVC)
UI Design: FXML with CSS styling
Documentation: Javadoc
Author
[Your Name]

Version
1.0.0 - Initial Release

License
This project is for educational purposes.

