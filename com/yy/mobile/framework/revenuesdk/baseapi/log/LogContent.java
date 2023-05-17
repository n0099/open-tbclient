package com.yy.mobile.framework.revenuesdk.baseapi.log;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class LogContent {
    public JSONArray content;
    public List<JSONObject> copyWaitingJsonList;
    public AtomicInteger retryCount = new AtomicInteger(0);
}
