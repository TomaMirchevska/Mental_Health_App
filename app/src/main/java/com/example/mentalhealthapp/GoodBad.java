package com.example.mentalhealthapp;

public class GoodBad {

    // These are the placeholders for the question resource id and the correct answer.
    private int questionID; // It's safer to keep variables private.
    // It's an int because we will get the ID from strings which is an int.
    private boolean answer; // Good or bad.

    // This is the constructor that will be called when a new quiz question is created.
    // Will pass two parameters as each question will be created according to its own ID.
    // Also whether its answer is good or bad.

    public GoodBad(int questionResourceID, boolean goodOrBad) {
        questionID = questionResourceID;
        answer = goodOrBad;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
