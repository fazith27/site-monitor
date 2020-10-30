package com.fazith.sitemonitor.service;

import com.fazith.sitemonitor.repository.LocalStore;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

@Service
public class URLStatusCheckServiceImpl implements URLStatusCheckService{

    public Map getStatus() throws IOException {
        HashSet<String> urls = LocalStore.getURLs();
        Map<String,String> monitorstatus = new HashMap<String, String>();
        Iterator value = urls.iterator();
        while (value.hasNext()) {
            String urlstring = (String)value.next();
            URL url = new URL(urlstring);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int code = connection.getResponseCode();
            monitorstatus.put(urlstring,code+"");
        }
        return monitorstatus;
    }
}
