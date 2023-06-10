package com.example.javapart2final;

import java.io.Serializable;

public class Movies implements Serializable {
    private String Title;
    private String YearR;
    private String Genre1,Genre2,Genre3;
    private String Runtime;
    private String  ProductionCom;
    private String Budget;
    private String Revenue;

    public Movies(String title, String yearR, String genre1, String genre2, String genre3, String runtime, String productionCom, String budget, String revenue) {
        Title = title;
        YearR = yearR;
        Genre1 = genre1;
        Genre2 = genre2;
        Genre3 = genre3;
        Runtime = runtime;
        ProductionCom = productionCom;
        Budget = budget;
        Revenue = revenue;
    }
    public long getProfit(){
        return (Long.parseLong(Revenue)-Long.parseLong(Budget));
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYearR() {
        return YearR;
    }
    public int getIntYear(){return  Integer.parseInt(YearR);}

    public void setYearR(String yearR) {
        YearR = yearR;
    }

    public String getGenre1() {
        return Genre1;
    }

    public void setGenre1(String genre1) {
        Genre1 = genre1;
    }

    public String getGenre2() {
        return Genre2;
    }

    public void setGenre2(String genre2) {
        Genre2 = genre2;
    }

    public String getGenre3() {
        return Genre3;
    }

    public void setGenre3(String genre3) {
        Genre3 = genre3;
    }

    public String getRuntime() {
        return Runtime;
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
    }

    public String getProductionCom() {
        return ProductionCom;
    }

    public void setProductionCom(String productionCom) {
        ProductionCom = productionCom;
    }

    public String getBudget() {
        return Budget;
    }

    public void setBudget(String budget) {
        Budget = budget;
    }

    public String getRevenue() {
        return Revenue;
    }

    public void setRevenue(String revenue) {
        Revenue = revenue;
    }

    public String showMovies()
    {    String s;
        s=("Title : "+getTitle()+"\n");
        s+=("Year : "+getYearR()+"\n");
        s+=("Genre : "+getGenre1()+" ");
        s+=(getGenre2()+" ");
        s+=(getGenre3()+" \n");
        s+=("Runtime : "+getRuntime()+"\n");
        s+=("Production Company Name : "+getProductionCom()+"\n");
        s+=("Budget : "+getBudget()+"\n");
        s+=("Revenue : "+getRevenue());

        return s;
        //System.out.println();
    }
}