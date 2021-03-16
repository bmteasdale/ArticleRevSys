/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci483.assign2;
import org.bson.types.ObjectId;


/**
 *
 * @author bmteasdale
 */
public class Review {
    private ObjectId reviewID;
    private String pubTitle;
    private String pubURL;
    private String summary;
    private String posComments;
    private String negComments;
    private String majPoints;
    private String minPoints;
    private String recommendation;
    private String revName;
    private int highestScore;

    
    public Review(
            ObjectId reviewID,
            String pubTitle, 
            String pubURL, 
            String summary, 
            String posComments, 
            String negComments, 
            String majPoints, 
            String minPoints, 
            String recommendation, 
            String revName, 
            int highestScore) {
        this.reviewID = reviewID;
        this.pubTitle = pubTitle;
        this.pubURL = pubURL;
        this.summary = summary;
        this.posComments = posComments;
        this.negComments = negComments;
        this.majPoints = majPoints;
        this.minPoints = minPoints;
        this.recommendation = recommendation;
        this.revName = revName;
        this.highestScore = highestScore;
        
    }

    public ObjectId getReviewID() {
        return reviewID;
    }

    public void setReviewID(ObjectId id) {
        this.reviewID = id;
    }
    
    public String getPubTitle() {
        return pubTitle;
    }

    public void setPubTitle(String pubTitle) {
        this.pubTitle = pubTitle;
    }

    public String getPubURL() {
        return pubURL;
    }

    public void setPubURL(String pubURL) {
        this.pubURL = pubURL;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPosComments() {
        return posComments;
    }

    public void setPosComments(String posComments) {
        this.posComments = posComments;
    }

    public String getNegComments() {
        return negComments;
    }

    public void setNegComments(String negComments) {
        this.negComments = negComments;
    }

    public String getMajPoints() {
        return majPoints;
    }

    public void setMajPoints(String majPoints) {
        this.majPoints = majPoints;
    }

    public String getMinPoints() {
        return minPoints;
    }

    public void setMinPoints(String minPoints) {
        this.minPoints = minPoints;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getRevName() {
        return revName;
    }

    public void setRevName(String revName) {
        this.revName = revName;
    }
    
    public int getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(int score) {
        this.highestScore = score;
    }
}
