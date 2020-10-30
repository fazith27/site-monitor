package com.fazith.sitemonitor.service;

import java.io.IOException;
import java.util.Map;

public interface URLStatusCheckService {
    public abstract Map getStatus() throws IOException;
}
