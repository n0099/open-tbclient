package com.qq.e.comm.plugin.y;

import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class f {
    static String a(JSONObject jSONObject, String str) {
        int a2 = h.a();
        String jSONObject2 = jSONObject.toString();
        if (jSONObject2.length() <= a2) {
            return jSONObject2;
        }
        Object opt = jSONObject.opt(str);
        if (opt instanceof JSONObject) {
            Iterator<String> keys = ((JSONObject) opt).keys();
            while (keys.hasNext()) {
                keys.next();
                keys.remove();
                String jSONObject3 = jSONObject.toString();
                if (jSONObject3.length() <= a2) {
                    return jSONObject3;
                }
            }
            jSONObject.remove(str);
            return jSONObject.toString();
        }
        return jSONObject2;
    }
}
