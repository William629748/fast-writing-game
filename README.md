### 🎮 Game Features

- **Progressive Difficulty**: Words become more complex as levels increase
- **Time Pressure**: Each level has a countdown timer that decreases with higher levels
- **Real-time Feedback**: Immediate validation and visual feedback
- **Level Progression**: Advance through unlimited levels with increasing challenges
- **Modern UI**: Clean, responsive interface with visual effects
- **Multiple Input Methods**: Support for both keyboard (Enter) and mouse (Submit button) input

### 🎯 Game Rules

1. **Starting Conditions**:
    - Level 1 begins with 20 seconds per word
    - Simple words are presented initially

2. **Level Progression**:
    - Correct typing advances to the next level
    - Every 5 levels, time limit decreases by 2 seconds (minimum 2 seconds)
    - Word difficulty increases: Easy → Medium → Hard → Expert phrases

3. **Validation**:
    - Exact match required (case-sensitive, including punctuation and spaces)
    - Input validated on Enter key press, Submit button click, or when timer expires

4. **Game Over**:
    - Incorrect input or running out of time ends the game
    - Display shows final level reached and performance summary

## 🛠️ Technical Specifications

### Requirements

- **Java Version**: Java SE 17+ (Amazon Corretto recommended)
- **JavaFX Version**: 17.0.2+
- **Build Tool**: Maven or Gradle
- **IDE**: IntelliJ IDEA (recommended)

### Architecture

- **Pattern**: MVC (Model-View-Controller)
- **GUI Framework**: JavaFX with FXML
- **UI Design**: Scene Builder compatible layouts
- **Event Handling**: Custom event handlers with inner classes and adapters

## 🚀 Installation and Setup

### Prerequisites

1. **Install Java 17+**
   ```bash
   # Verify Java installation
   java --version
   ```

2. **Install JavaFX SDK** (if not using Maven/Gradle)
    - Download from [OpenJFX.io](https://openjfx.io/)
    - Extract to desired location

### Option 1: Using Maven

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd fast-writing-game
   ```

2. **Build and run with Maven**
   ```bash
   mvn clean compile
   mvn javafx:run
   ```

3. **Generate Javadoc**
   ```bash
   mvn javadoc:javadoc
   ```

### Option 2: Using IntelliJ IDEA

1. **Import Project**
    - Open IntelliJ IDEA
    - File → New → Project from Version Control
    - Enter repository URL

2. **Configure JavaFX**
    - File → Project Structure → Libraries
    - Add JavaFX SDK as library
    - Configure VM options in Run Configuration:
   ```
   --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml
   ```

3. **Run Application**
    - Right-click `Main.java`
    - Run 'Main.main()'

### Option 3: Manual Setup

1. **Create project structure**
   ```
   FastWritingGame/
   ├── src/main/java/
   ├── src/main/resources/
   └── [copy all provided files]
   ```

2. **Compile manually**
   ```bash
   javac --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml -d out src/main/java/module-info.java src/main/java/com/fastwriting/**/*.java
   ```

3. **Run application**
   ```bash
   java --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml -cp out com.fastwriting.app.Main
   ```

## 📁 Project Structure

```
FastWritingGame/
├── src/main/
│   ├── java/
│   │   ├── module-info.java
│   │   └── com/fastwriting/
│   │       ├── app/Main.java
│   │       ├── controller/GameController.java
│   │       └── model/WordGenerator.java
│   └── resources/
│       ├── fxml/game-view.fxml
│       └── css/styles.css
├── pom.xml
└── README.md
```

## 🎮 How to Play

1. **Start the Game**: Launch the application
2. **Read the Word**: A word or phrase appears in the center display area
3. **Type Accurately**: Enter the exact text in the input field
4. **Submit**: Press Enter or click Submit button
5. **Progress**: Successfully typed words advance you to the next level
6. **Challenge Yourself**: See how many levels you can complete!

### 💡 Tips for Success

- **Accuracy over Speed**: One mistake ends the game
- **Focus on the Display**: Read carefully before typing
- **Use Both Hands**: Proper typing technique helps with speed
- **Stay Calm**: Don't panic as the timer counts down

## 🏆 Difficulty Levels

| Level Range | Category | Time Limit | Word Type |
|-------------|----------|------------|-----------|
| 1-5         | Easy     | 20s        | Simple words (3-4 letters) |
| 6-15        | Medium   | 18s-10s    | Common words (5-15 letters) |
| 16-25       | Hard     | 8s-2s      | Complex words (10+ letters) |
| 26+         | Expert   | 2s         | Full sentences and phrases |

## 🔧 Configuration

### Customizing Word Lists

Edit `WordGenerator.java` to modify word collections:

```java
// Add new words to appropriate difficulty lists
private final List<String> easyWords = Arrays.asList(
    "your", "custom", "words"
);
```

### Adjusting Game Parameters

Modify `GameController.java` constants:

```java
// Initial time limit
private int timeLimit = 20;

// Time reduction per 5 levels  
private static final int TIME_REDUCTION = 2;

// Minimum time limit
private static final int MIN_TIME_LIMIT = 2;
```

## 🐛 Troubleshooting

### Common Issues

1. **JavaFX Runtime Components Missing**
   ```
   Error: JavaFX runtime components are missing
   ```
   **Solution**: Add JavaFX modules to VM options

2. **FXML Load Exception**
   ```
   Exception in Application start method
   ```
   **Solution**: Verify FXML file path and controller class name

3. **CSS Not Loading**
   **Solution**: Check CSS file path in Main.java

### Performance Optimization

- Ensure adequate heap memory: `-Xmx512m`
- For older systems, disable visual effects in CSS
- Use hardware acceleration: `-Dprism.order=d3d` (Windows)

## 📚 Documentation

- **Javadoc**: Generated HTML documentation available in `target/site/apidocs/`
- **Code Style**: Follows Java conventions (camelCase, PascalCase, SNAKE_CASE)
- **Comments**: All methods and classes documented in English

## 👥 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit changes (`git commit -m 'Add amazing feature'`)
4. Push to branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👤 Authors

- **Developer**: [Your Name]
- **Institution**: [Your Institution]
- **Course**: Programming II - JavaFX Project

## 🙏 Acknowledgments

- JavaFX community for excellent documentation
- Scene Builder team for the visual FXML editor
- Java development team for continuous improvements

---

**Happy Typing!** 🎯✨