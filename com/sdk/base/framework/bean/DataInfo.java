package com.sdk.base.framework.bean;

import com.baidu.mapsdkplatform.comapi.map.r;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class DataInfo extends JSONObject {
    public DataInfo() {
        try {
            put(r.f7699a, System.currentTimeMillis());
        } catch (JSONException unused) {
        }
    }

    public JSONObject putData(String str, Object obj) {
        try {
            return super.put(str, obj);
        } catch (Exception unused) {
            return this;
        }
    }

    public String toAESString() {
        return "";
    }
}
