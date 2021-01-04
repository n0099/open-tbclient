package com.kwai.video.ksvodplayerkit.b;

import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class m {
    public static String a(l lVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (lVar.f11353a != null && !lVar.f11353a.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (a aVar : lVar.f11353a) {
                    jSONArray.put(b.a(aVar));
                }
                jSONObject.put("adaptationSet", jSONArray);
            }
        } catch (Exception e) {
        }
        return jSONObject.toString();
    }
}
