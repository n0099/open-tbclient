package com.kwai.video.ksvodplayerkit.b;

import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b {
    public static String a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adaptationId", aVar.f38098a);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("duration", aVar.f38099b);
        } catch (Exception unused2) {
        }
        try {
            if (aVar.f38100c != null && !aVar.f38100c.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (j jVar : aVar.f38100c) {
                    jSONArray.put(k.a(jVar));
                }
                jSONObject.put("representation", jSONArray);
            }
        } catch (Exception unused3) {
        }
        return jSONObject.toString();
    }
}
