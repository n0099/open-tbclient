package com.kwai.video.ksvodplayerkit.b;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class d {
    public static c a(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.f38003a = jSONObject.optString("version", cVar.f38003a);
        cVar.f38004b = jSONObject.optString("type", cVar.f38004b);
        cVar.f38005c = e.a(jSONObject.optJSONObject("adaptationSet"));
        return cVar;
    }

    public static String a(c cVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", cVar.f38003a);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("type", cVar.f38004b);
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("adaptationSet", e.a(cVar.f38005c));
        } catch (Exception unused3) {
        }
        return jSONObject.toString();
    }
}
