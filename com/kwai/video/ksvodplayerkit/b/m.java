package com.kwai.video.ksvodplayerkit.b;

import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class m {
    public static String a(l lVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (lVar.f11054a != null && !lVar.f11054a.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (a aVar : lVar.f11054a) {
                    jSONArray.put(b.a(aVar));
                }
                jSONObject.put("adaptationSet", jSONArray);
            }
        } catch (Exception e) {
        }
        return jSONObject.toString();
    }
}
