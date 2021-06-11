package com.kwai.video.ksvodplayerkit.b;

import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b {
    public static String a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adaptationId", aVar.f38000a);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("duration", aVar.f38001b);
        } catch (Exception unused2) {
        }
        try {
            if (aVar.f38002c != null && !aVar.f38002c.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (j jVar : aVar.f38002c) {
                    jSONArray.put(k.a(jVar));
                }
                jSONObject.put("representation", jSONArray);
            }
        } catch (Exception unused3) {
        }
        return jSONObject.toString();
    }
}
