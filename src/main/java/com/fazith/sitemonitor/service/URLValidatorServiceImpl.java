package com.fazith.sitemonitor.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class URLValidatorServiceImpl implements URLValidatorService{

    public boolean validateURL(String url) throws Exception{
        String pattern = "(https|http):\\/\\/([\\w.\\/\\d_]*)";
        if(url !=null && url.matches(pattern)){
            return true;
        }
        return false;
    }
}
