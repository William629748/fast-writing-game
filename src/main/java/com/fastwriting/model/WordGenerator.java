package com.fastwriting.model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Generates random words and phrases for the Fast Writing game.
 * Provides different difficulty levels with increasingly complex content.
 *
 * @author [Your Name]
 * @version 2.0
 * @since 2024
 */
public class WordGenerator {

    /**
     * Random number generator for selecting words and phrases.
     */
    private final Random random;

    /**
     * List of easy words for beginner levels (1-10).
     */
    private final List<String> easyWords;

    /**
     * List of medium difficulty words for intermediate levels (11-20).
     */
    private final List<String> mediumWords;

    /**
     * List of hard words for advanced levels (21-30).
     */
    private final List<String> hardWords;

    /**
     * List of expert words for challenging levels (31-40).
     */
    private final List<String> expertWords;

    /**
     * List of short phrases for high-level gameplay (41-50).
     */
    private final List<String> shortPhrases;

    /**
     * List of complex phrases for master levels (51+).
     */
    private final List<String> complexPhrases;

    /**
     * Constructs a new WordGenerator and initializes word lists.
     */
    public WordGenerator() {
        random = new Random();

        easyWords = Arrays.asList(
                "cat", "dog", "sun", "moon", "book", "tree", "car", "home", "love", "life",
                "time", "water", "fire", "earth", "music", "dance", "smile", "happy", "peace", "light",
                "blue", "green", "house", "phone", "work", "play", "food", "hand", "face", "door",
                "window", "chair", "table", "paper", "money", "world", "school", "friend", "family", "heart"
        );

        mediumWords = Arrays.asList(
                "computer", "keyboard", "programming", "development", "technology", "innovation",
                "creativity", "challenge", "adventure", "discovery", "knowledge", "education",
                "communication", "friendship", "beautiful", "wonderful", "amazing", "fantastic",
                "incredible", "extraordinary", "magnificent", "spectacular", "brilliant", "excellent",
                "important", "different", "interesting", "experience", "environment", "government",
                "information", "organization", "performance", "opportunity", "community", "application",
                "management", "relationship", "understanding", "responsibility", "international", "professional"
        );

        hardWords = Arrays.asList(
                "sophisticated", "unprecedented", "extraordinary", "incomprehensible", "revolutionary",
                "philosophical", "psychological", "technological", "entrepreneurial", "constitutional",
                "interdisciplinary", "multidimensional", "internationally", "environmentally",
                "characteristically", "uncharacteristically", "disproportionately", "overwhelmingly",
                "indistinguishable", "incontrovertible", "straightforwardness", "counterproductive",
                "incompatibility", "misunderstanding", "disappointment", "accomplishment", "establishment",
                "entertainment", "advertisement", "recommendation", "transformation", "investigation",
                "collaboration", "concentration", "demonstration", "experimentation", "implementation",
                "communication", "transportation", "administration", "rehabilitation", "representation"
        );

        expertWords = Arrays.asList(
                "antidisestablishmentarianism", "floccinaucinihilipilification", "pneumonoultramicroscopicsilicovolcanoconiosiss",
                "supercalifragilisticexpialidocious", "hippopotomonstrosesquippedaliophobia", "pseudopseudohypoparathyroidism",
                "incomprehensibilities", "immunoelectrophoresis", "psychopharmacologically", "radioimmunoelectrophoresis",
                "tetraiodophenolphthalein", "hepaticocholangiocholecystenterostomies", "spectrophotometrically", "electroencephalograph",
                "esophagogastroduodenoscopy", "electrocardiographically", "immunoelectrophoretically", "psychoneuroendocrinology",
                "pneumoencephalographically", "electroretinographically", "magnetohydrodynamically", "crystallographically",
                "electroencephalographically", "psychopharmacologically", "immunoelectrophoretically", "spectrophotometrically",
                "electrocardiographically", "pneumoencephalographically", "electroretinographically", "magnetohydrodynamically"
        );

        shortPhrases = Arrays.asList(
                "The quick brown fox jumps over the lazy dog.",
                "To be or not to be, that is the question.",
                "A journey of a thousand miles begins with a single step.",
                "The only thing we have to fear is fear itself.",
                "Ask not what your country can do for you.",
                "I have a dream that one day this nation will rise up.",
                "That's one small step for man, one giant leap for mankind.",
                "The way to get started is to quit talking and begin doing.",
                "Life is what happens to you while you're busy making other plans.",
                "The future belongs to those who believe in the beauty of their dreams.",
                "It is during our darkest moments that we must focus to see the light.",
                "Success is not final, failure is not fatal: it is the courage to continue.",
                "The greatest glory in living lies not in never falling, but in rising every time we fall.",
                "In the end, we will remember not the words of our enemies, but the silence of our friends.",
                "Darkness cannot drive out darkness: only light can do that. Hate cannot drive out hate: only love can do that.",
                "Be yourself; everyone else is already taken.",
                "Two things are infinite: the universe and human stupidity; and I'm not sure about the universe.",
                "A room without books is like a body without a soul.",
                "You only live once, but if you do it right, once is enough.",
                "If you want to know what a man's like, take a good look at how he treats his inferiors, not his equals."
        );

        complexPhrases = Arrays.asList(
                "Programming is the art of telling another human what one wants the computer to do.",
                "Innovation distinguishes between a leader and a follower in today's competitive marketplace.",
                "The complexity of modern software development requires a deep understanding of multiple programming paradigms.",
                "Artificial intelligence and machine learning are revolutionizing the way we approach problem-solving in various industries.",
                "The implementation of advanced algorithms requires both theoretical knowledge and practical programming experience.",
                "Object-oriented programming principles such as encapsulation, inheritance, and polymorphism form the foundation of modern software design.",
                "Database management systems play a crucial role in storing, retrieving, and managing large amounts of structured and unstructured data.",
                "User interface design must balance functionality with aesthetics to create engaging and intuitive user experiences.",
                "Software testing methodologies including unit testing, integration testing, and system testing ensure the reliability and quality of applications.",
                "The emergence of cloud computing has transformed the way organizations deploy, scale, and maintain their software infrastructure.",
                "Cybersecurity threats continue to evolve, requiring constant vigilance and advanced security measures to protect sensitive information.",
                "Agile development methodologies emphasize iterative development, collaboration, and adaptability to changing requirements throughout the project lifecycle.",
                "Data structures and algorithms form the fundamental building blocks of efficient and scalable software solutions.",
                "The Internet of Things (IoT) connects everyday objects to the internet, enabling smart homes, cities, and industrial automation.",
                "Version control systems like Git enable teams of developers to collaborate effectively on large-scale software projects.",
                "Microservices architecture breaks down monolithic applications into smaller, independently deployable services for improved scalability and maintainability.",
                "Responsive web design ensures that websites and applications provide optimal viewing experiences across a wide range of devices and screen sizes.",
                "Big data analytics involves processing and analyzing large volumes of data to extract meaningful insights and support data-driven decision making.",
                "DevOps practices integrate software development and IT operations to improve collaboration, automation, and continuous delivery of software products.",
                "Machine learning algorithms can automatically learn and improve from experience without being explicitly programmed for every possible scenario."
        );
    }

    /**
     * Returns a random word or phrase based on the current game level.
     * Difficulty increases progressively as levels advance.
     *
     * @param level the current game level
     * @return a random word or phrase appropriate for the level
     */
    public String getRandomWord(int level) {
        if (level <= 10) {
            return getRandomFromList(easyWords);
        } else if (level <= 20) {
            return getRandomFromList(mediumWords);
        } else if (level <= 30) {
            return getRandomFromList(hardWords);
        } else if (level <= 40) {
            return getRandomFromList(expertWords);
        } else if (level <= 50) {
            return getRandomFromList(shortPhrases);
        } else {
            return getRandomFromList(complexPhrases);
        }
    }

    /**
     * Selects a random element from the provided list.
     *
     * @param list the list to select from
     * @return a random element from the list
     */
    private String getRandomFromList(List<String> list) {
        int index = random.nextInt(list.size());
        return list.get(index);
    }

    /**
     * Gets the total number of easy words available.
     *
     * @return the count of easy words
     */
    public int getEasyWordsCount() {
        return easyWords.size();
    }

    /**
     * Gets the total number of medium difficulty words available.
     *
     * @return the count of medium words
     */
    public int getMediumWordsCount() {
        return mediumWords.size();
    }

    /**
     * Gets the total number of hard words available.
     *
     * @return the count of hard words
     */
    public int getHardWordsCount() {
        return hardWords.size();
    }

    /**
     * Gets the total number of expert words available.
     *
     * @return the count of expert words
     */
    public int getExpertWordsCount() {
        return expertWords.size();
    }

    /**
     * Gets the total number of short phrases available.
     *
     * @return the count of short phrases
     */
    public int getShortPhrasesCount() {
        return shortPhrases.size();
    }

    /**
     * Gets the total number of complex phrases available.
     *
     * @return the count of complex phrases
     */
    public int getComplexPhrasesCount() {
        return complexPhrases.size();
    }

    /**
     * Determines the difficulty category based on the current level.
     *
     * @param level the current game level
     * @return a string representing the difficulty category
     */
    public String getDifficultyCategory(int level) {
        if (level <= 10) {
            return "Easy";
        } else if (level <= 20) {
            return "Medium";
        } else if (level <= 30) {
            return "Hard";
        } else if (level <= 40) {
            return "Expert";
        } else if (level <= 50) {
            return "Master";
        } else {
            return "Legendary";
        }
    }

    /**
     * Gets the total number of unique content items available.
     *
     * @return the total count of all words and phrases
     */
    public int getTotalContentCount() {
        return easyWords.size() + mediumWords.size() + hardWords.size() +
                expertWords.size() + shortPhrases.size() + complexPhrases.size();
    }
}