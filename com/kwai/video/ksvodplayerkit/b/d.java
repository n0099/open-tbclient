package com.kwai.video.ksvodplayerkit.b;

import org.json.JSONObject;
/* loaded from: classes6.dex */
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
        cVar.f37233a = jSONObject.optString("version", cVar.f37233a);
        cVar.f37234b = jSONObject.optString("type", cVar.f37234b);
        cVar.f37235c = e.a(jSONObject.optJSONObject("adaptationSet"));
        return cVar;
    }

    public static String a(c cVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", cVar.f37233a);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("type", cVar.f37234b);
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("adaptationSet", e.a(cVar.f37235c));
        } catch (Exception unused3) {
        }
        return jSONObject.toString();
    }
}
