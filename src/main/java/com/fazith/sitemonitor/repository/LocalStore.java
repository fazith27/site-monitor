package com.fazith.sitemonitor.repository;

import java.util.HashSet;

public class LocalStore {

    public static HashSet<String> monitorstatus = new HashSet<String>();


    static public void addtoStore(String newSite){
        monitorstatus.add(newSite);
    }

    static public void initializeLocalStore(){
        monitorstatus.add("https://www.wikipedia.com");
        monitorstatus.add("https://www.yahoo.com");
        monitorstatus.add("https://www.netflix.com");
    }

    static public HashSet<String> getURLs(){
        return monitorstatus;
    }
}
