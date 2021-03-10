/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci483.assign2;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author bmteasdale
 */
@ManagedBean(name = "reviewBean")
@SessionScoped
public class ReviewBean implements Serializable {
    
//    https://www.primefaces.org/showcase/ui/data/datatable/contextMenu.xhtml?jfwid=6a01e
    
    private ArrayList<Review> reviews;
    
    @PostConstruct
    public void init() {
        this.reviews = new ArrayList<>();
        reviews.add(new Review(
                "TestTitle", 
                "testURL", 
                "TestSummary", 
                "testPosComm", 
                "TestNegComm", 
                "TestMajPoints",
                "TestMinPoints", 
                "TestReccom",
                "testRevName",
                7.85));
        reviews.add(new Review(
                "TestTitle2", 
                "testURL2", 
                "TestSummary2", 
                "testPosComm2", 
                "TestNegComm2", 
                "TestMajPoints2",
                "TestMinPoints2", 
                "TestReccom2",
                "testRevName2",
                9.5));
        reviews.add(new Review(
                "TestTitle3", 
                "testURL3", 
                "TestSummary3", 
                "testPosComm3", 
                "TestNegComm3", 
                "TestMajPoints3",
                "TestMinPoints3", 
                "TestReccom3",
                "testRevName3",
                5.6));
    }
    
    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }
    
}
