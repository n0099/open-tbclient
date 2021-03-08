package com.kwai.video.ksvodplayerkit.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class d {
    public static c a(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.f7274a = jSONObject.optString("version", cVar.f7274a);
        cVar.b = jSONObject.optString("type", cVar.b);
        cVar.c = e.a(jSONObject.optJSONObject("adaptationSet"));
        return cVar;
    }

    public static String a(c cVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", cVar.f7274a);
        } catch (Exception e) {
        }
        try {
            jSONObject.put("type", cVar.b);
        } catch (Exception e2) {
        }
        try {
            jSONObject.put("adaptationSet", e.a(cVar.c));
        } catch (Exception e3) {
        }
        return jSONObject.toString();
    }
}
