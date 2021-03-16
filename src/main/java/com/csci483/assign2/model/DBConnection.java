/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci483.assign2.model;

import com.csci483.assign2.Review;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import com.mongodb.*;
import java.net.UnknownHostException;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author bmteasdale
 */
@ManagedBean(name = "dbConnection")
public class DBConnection {
    
    private MongoClient client = null;
    private final DB database;
    private final DBCollection reviews;
    
    public DBConnection() throws UnknownHostException {
        this.client = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        this.database = client.getDB("cs483Assign2");
        this.reviews = database.getCollection("reviews");
    }
    
    /**
     *
     * @param review
     * @return 
     */
    public static DBObject convert(Review review) { 
        return new BasicDBObject("reviewID", review.getReviewID())
                .append("pubTitle", review.getPubTitle())
                .append("pubURL", review.getPubURL())
                .append("summary", review.getSummary())
                .append("posComments", review.getPosComments())
                .append("negComments", review.getNegComments())
                .append("majPoints", review.getMajPoints())
                .append("minPoints", review.getMinPoints())
                .append("recommendation", review.getRecommendation())
                .append("revName", review.getRevName())
                .append("highestScore", review.getHighestScore());
    }
    
    public void insert(Review review) {
        this.reviews.insert(convert(review));
    }
    
    public void saveReviewScore(
            ObjectId reviewID, 
            int score, 
            String pubTitle, 
            String pubURL, 
            String summary, 
            String posComments, 
            String negComments, 
            String majPoints, 
            String minPoints, 
            String recommendation, 
            String revName){
        DBObject query = new BasicDBObject("reviewID", reviewID);
        DBCursor cursor = this.reviews.find(query);
        if(cursor.count() != 0) {
            int currentScore = (int) cursor.one().get("highestScore");
            if(currentScore < score){
                Review modifiedReview = new Review(reviewID,
                    pubTitle, 
                    pubURL, 
                    summary, 
                    posComments, 
                    negComments, 
                    majPoints, 
                    minPoints, 
                    recommendation,
                    revName,
                    score
                );
                this.reviews.findAndModify(query, convert(modifiedReview));
            }
            
        }
        
        
    }
    
    public ArrayList<Review> findAllRecords() {
        DBCursor cursor;
        ArrayList<Review> allReviews = new ArrayList<>();
        cursor = this.reviews.find();
        
        while(cursor.hasNext()) {
            DBObject next = cursor.next();
            Review review = new Review(
                    (ObjectId) next.get("reviewID"),
                    (String) next.get("pubTitle"), 
                    (String) next.get("pubURL"), 
                    (String) next.get("summary"), 
                    (String) next.get("posComments"), 
                    (String) next.get("negComments"), 
                    (String) next.get("majPoints"),
                    (String) next.get("minPoints"), 
                    (String) next.get("recommendation"),
                    (String) next.get("revName"),
                    (int) next.get("highestScore"));
            allReviews.add(review);
        }
    
        return allReviews;
    }
    
    public int getHighestScoreFromDB(ObjectId reviewID) {
        DBObject query = new BasicDBObject("reviewID", reviewID);
        DBCursor cursor = this.reviews.find(query);
        int highestScore;
        if(!cursor.hasNext())
            return 0;
        return ((int) cursor.one().get("highestScore"));
    }
}
