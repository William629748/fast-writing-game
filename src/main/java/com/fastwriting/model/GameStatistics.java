package com.fastwriting.model;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Model class for tracking game statistics and performance metrics.
 * Stores data about player performance, timing, and accuracy during gameplay.
 *
 * @author [William Rooselbelt May Barreto]
 * @version 1.0
 * @since 2025
 */
public class GameStatistics {

    /**
     * The time when the game session started.
     */
    private LocalDateTime startTime;

    /**
     * The time when the game session ended.
     */
    private LocalDateTime endTime;

    /**
     * The final level reached by the player.
     */
    private int finalLevel;

    /**
     * Total number of words attempted by the player.
     */
    private int wordsAttempted;

    /**
     * Number of words typed correctly.
     */
    private int correctWords;

    /**
     * Number of words typed incorrectly.
     */
    private int incorrectWords;

    /**
     * Total time spent typing (excluding countdown time).
     */
    private long totalTimeSpent;

    /**
     * Creates a new GameStatistics instance with default values.
     */
    public GameStatistics() {
        this.startTime = LocalDateTime.now();
        this.finalLevel = 1;
        this.wordsAttempted = 0;
        this.correctWords = 0;
        this.incorrectWords = 0;
        this.totalTimeSpent = 0;
    }

    /**
     * Gets the game session start time.
     *
     * @return the start time of the game session
     */
    public LocalDateTime getStartTime() {
        return startTime;
    }

    /**
     * Sets the game session start time.
     *
     * @param startTime the start time to set
     */
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets the game session end time.
     *
     * @return the end time of the game session
     */
    public LocalDateTime getEndTime() {
        return endTime;
    }

    /**
     * Sets the game session end time.
     *
     * @param endTime the end time to set
     */
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    /**
     * Gets the final level reached by the player.
     *
     * @return the final level reached
     */
    public int getFinalLevel() {
        return finalLevel;
    }

    /**
     * Sets the final level reached by the player.
     *
     * @param finalLevel the final level to set
     */
    public void setFinalLevel(int finalLevel) {
        this.finalLevel = finalLevel;
    }

    /**
     * Gets the total number of words attempted.
     *
     * @return the number of words attempted
     */
    public int getWordsAttempted() {
        return wordsAttempted;
    }

    /**
     * Increments the count of words attempted.
     */
    public void incrementWordsAttempted() {
        this.wordsAttempted++;
    }

    /**
     * Gets the number of correctly typed words.
     *
     * @return the number of correct words
     */
    public int getCorrectWords() {
        return correctWords;
    }

    /**
     * Increments the count of correctly typed words.
     */
    public void incrementCorrectWords() {
        this.correctWords++;
    }

    /**
     * Gets the number of incorrectly typed words.
     *
     * @return the number of incorrect words
     */
    public int getIncorrectWords() {
        return incorrectWords;
    }

    /**
     * Increments the count of incorrectly typed words.
     */
    public void incrementIncorrectWords() {
        this.incorrectWords++;
    }

    /**
     * Gets the total time spent typing in seconds.
     *
     * @return the total time spent typing
     */
    public long getTotalTimeSpent() {
        return totalTimeSpent;
    }

    /**
     * Adds time to the total time spent typing.
     *
     * @param timeSpent the time to add in seconds
     */
    public void addTimeSpent(long timeSpent) {
        this.totalTimeSpent += timeSpent;
    }

    /**
     * Calculates the total duration of the game session.
     *
     * @return the duration of the game session, or null if end time is not set
     */
    public Duration getSessionDuration() {
        if (endTime == null) {
            return Duration.between(startTime, LocalDateTime.now());
        }
        return Duration.between(startTime, endTime);
    }

    /**
     * Calculates the accuracy percentage based on correct vs total words.
     *
     * @return the accuracy as a percentage (0-100)
     */
    public double getAccuracyPercentage() {
        if (wordsAttempted == 0) {
            return 0.0;
        }
        return (double) correctWords / wordsAttempted * 100.0;
    }

    /**
     * Calculates the average typing speed in words per minute.
     *
     * @return the typing speed in WPM
     */
    public double getWordsPerMinute() {
        Duration sessionDuration = getSessionDuration();
        if (sessionDuration.isZero() || correctWords == 0) {
            return 0.0;
        }
        double minutes = sessionDuration.toSeconds() / 60.0;
        return correctWords / minutes;
    }

    /**
     * Gets a performance rating based on the final level reached.
     *
     * @return a string describing the performance level
     */
    public String getPerformanceRating() {
        if (finalLevel >= 50) {
            return "Legendary Typist";
        } else if (finalLevel >= 40) {
            return "Master Typist";
        } else if (finalLevel >= 30) {
            return "Expert Typist";
        } else if (finalLevel >= 20) {
            return "Advanced Typist";
        } else if (finalLevel >= 10) {
            return "Intermediate Typist";
        } else {
            return "Beginner Typist";
        }
    }

    /**
     * Provides a formatted summary of the game statistics.
     *
     * @return a string containing formatted statistics
     */
    @Override
    public String toString() {
        return String.format(
                "Game Statistics:%n" +
                        "Final Level: %d%n" +
                        "Words Attempted: %d%n" +
                        "Correct Words: %d%n" +
                        "Incorrect Words: %d%n" +
                        "Accuracy: %.1f%%%n" +
                        "Words Per Minute: %.1f%n" +
                        "Performance Rating: %s%n" +
                        "Session Duration: %d minutes %d seconds",
                finalLevel, wordsAttempted, correctWords, incorrectWords,
                getAccuracyPercentage(), getWordsPerMinute(), getPerformanceRating(),
                getSessionDuration().toMinutes(), getSessionDuration().toSecondsPart()
        );
    }
}