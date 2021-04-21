package com.kwai.video.ksvodplayerkit.b;

import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class b {
    public static String a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adaptationId", aVar.f37614a);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("duration", aVar.f37615b);
        } catch (Exception unused2) {
        }
        try {
            if (aVar.f37616c != null && !aVar.f37616c.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (j jVar : aVar.f37616c) {
                    jSONArray.put(k.a(jVar));
                }
                jSONObject.put("representation", jSONArray);
            }
        } catch (Exception unused3) {
        }
        return jSONObject.toString();
    }
}
