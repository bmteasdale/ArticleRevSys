/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci483.assign2;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import com.csci483.assign2.model.DBConnection;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author bmteasdale
 */
@ManagedBean(name = "reviewBean")
@SessionScoped
public class ReviewBean implements Serializable {
    
//    https://www.primefaces.org/showcase/ui/data/datatable/contextMenu.xhtml?jfwid=6a01e
    
    private ArrayList<Review> reviews;
    private int selectedScore;
    
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
    
    @PostConstruct
    public void init() {
        try {
            getReviewsFromDB();
        } catch (UnknownHostException ex) {
            Logger.getLogger(ReviewBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void showAction() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Success", "The review has been successfully saved!"));
    }
    
    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }
    
    public int getSelectedScore() {
        return selectedScore;
    }

    public void setSelectedScore(int selectedScore) {
        this.selectedScore = selectedScore;
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

    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
    }
    
    
    public void getReviewsFromDB() throws UnknownHostException{
        DBConnection db = new DBConnection();
        this.reviews = db.findAllRecords();
    }
    
    public void saveReview() throws UnknownHostException {
        Review review = new Review(new ObjectId(), this.pubTitle, this.pubURL, this.summary, this.posComments, this.negComments, this.majPoints, this.minPoints, this.recommendation, this.revName, 0);
        DBConnection conn = new DBConnection();
        conn.insert(review);
        getReviewsFromDB();
        this.pubTitle = null;        
        this.pubURL = null;
        this.summary = null;
        this.posComments = null;
        this.negComments = null;
        this.majPoints = null;
        this.minPoints = null;
        this.recommendation = null;
        this.revName = null;
    }
}
