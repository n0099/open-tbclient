package com.kwai.video.ksvodplayerkit.b;

import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class m {
    public static String a(l lVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (lVar.f37551a != null && !lVar.f37551a.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (a aVar : lVar.f37551a) {
                    jSONArray.put(b.a(aVar));
                }
                jSONObject.put("adaptationSet", jSONArray);
            }
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }
}
