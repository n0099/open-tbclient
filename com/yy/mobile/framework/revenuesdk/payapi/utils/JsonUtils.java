package com.yy.mobile.framework.revenuesdk.payapi.utils;

import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class JsonUtils {
    public static Map<String, Object> getMapForJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.get(next));
            }
            return hashMap;
        } catch (Exception e) {
            RLog.error("JsonUtils", "getMapForJson Exception:" + e.getLocalizedMessage(), new Object[0]);
            return null;
        }
    }
}
