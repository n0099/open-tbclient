package com.kwai.video.ksvodplayerkit.b;

import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class m {
    public static String a(l lVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (lVar.f7280a != null && !lVar.f7280a.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (a aVar : lVar.f7280a) {
                    jSONArray.put(b.a(aVar));
                }
                jSONObject.put("adaptationSet", jSONArray);
            }
        } catch (Exception e) {
        }
        return jSONObject.toString();
    }
}
