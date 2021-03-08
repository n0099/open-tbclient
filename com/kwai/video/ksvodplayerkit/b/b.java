package com.kwai.video.ksvodplayerkit.b;

import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class b {
    public static String a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adaptationId", aVar.f7273a);
        } catch (Exception e) {
        }
        try {
            jSONObject.put("duration", aVar.b);
        } catch (Exception e2) {
        }
        try {
            if (aVar.c != null && !aVar.c.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (j jVar : aVar.c) {
                    jSONArray.put(k.a(jVar));
                }
                jSONObject.put("representation", jSONArray);
            }
        } catch (Exception e3) {
        }
        return jSONObject.toString();
    }
}
