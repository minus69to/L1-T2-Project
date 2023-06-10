package com.example.javapart2final;

import java.util.*;

class ProductionCompany {
    private static List<String> ss;

    public static List<String>MostRecentMovies(String productionCompany) {
        List<Movies> movies = new ArrayList();
        int latestYear = 0;
        for (int i = 0; i < HelloApplication.mvs.size(); i++) {
            Movies m = HelloApplication.mvs.get(i);
            if (m.getProductionCom().equalsIgnoreCase(productionCompany)) {
                if (m.getIntYear() >= latestYear) {
                    latestYear = m.getIntYear();
                }
            }
        }
        if (latestYear!=0)
        {
            for (int i = 0; i <  HelloApplication.mvs.size(); i++) {
                Movies m =  HelloApplication.mvs.get(i);
                if (m.getIntYear()==latestYear && m.getProductionCom().equalsIgnoreCase(productionCompany))
                {
                    movies.add(m);
                }
            }
        }
        List<String> ss = new ArrayList<>();
        for(Movies m:movies){
            ss.add(m.showMovies());
        }
        return ss;
    }

    public static List<String> MaxRevenue(String productionCompany) {
        List <Movies> movies = new ArrayList();
        long maxRevenue = 0;
        for (int i = 0; i < HelloApplication.mvs.size(); i++) {
            Movies m = HelloApplication.mvs.get(i);
            if (m.getProductionCom().equalsIgnoreCase(productionCompany)) {
                if (Integer.parseInt(m.getRevenue()) > maxRevenue) {
                    maxRevenue =Integer.parseInt(m.getRevenue());
                }
            }
        }
        if (maxRevenue != 0)
        {
            for (int i = 0; i < HelloApplication.mvs.size(); i++) {
                Movies m = HelloApplication.mvs.get(i);
                if (Integer.parseInt(m.getRevenue()) == maxRevenue && m.getProductionCom().equalsIgnoreCase(productionCompany))
                {
                    movies.add(m);
                }
            }
        }
        List<String> ss = new ArrayList<>();
        for(Movies m:movies){
            ss.add(m.showMovies());
        }
        return ss;
    }

    public static long TotalProfit() {
        long totalProfit = 0;
        for (Movies m : HelloApplication.mvs) {
             totalProfit += m.getProfit();
        }
        return totalProfit;
    }

    //****************
    public static List<String>AllMovies(String productionCompany) {

        List<Movies> movies = new ArrayList();
        //int latestYear = 0;
        for (int i = 0; i < HelloApplication.mvs.size(); i++)
        {
            Movies m = HelloApplication.mvs.get(i);
            if (m.getProductionCom().equalsIgnoreCase(productionCompany))
            {
                movies.add(m);
            }
        }

        List<String> ss = new ArrayList<>();
        for(Movies m:movies)
        {
            ss.add(m.showMovies());
        }
        return ss;
    }
}