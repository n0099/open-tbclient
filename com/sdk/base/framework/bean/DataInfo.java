package com.sdk.base.framework.bean;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class DataInfo extends JSONObject {
    public DataInfo() {
        try {
            put("r", System.currentTimeMillis());
        } catch (JSONException e) {
        }
    }

    public JSONObject putData(String str, Object obj) {
        try {
            return super.put(str, obj);
        } catch (Exception e) {
            return this;
        }
    }

    public String toAESString() {
        return "";
    }
}
