package com.kwai.video.ksvodplayerkit.b;

import com.kwai.video.ksvodplayerkit.b.c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class e {
    public static c.a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c.a aVar = new c.a();
        JSONArray optJSONArray = jSONObject.optJSONArray("representation");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(g.a(optJSONObject));
                }
            }
            aVar.f11047a = arrayList;
        }
        return aVar;
    }

    public static String a(c.a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (aVar.f11047a != null && !aVar.f11047a.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (f fVar : aVar.f11047a) {
                    jSONArray.put(g.a(fVar));
                }
                jSONObject.put("representation", jSONArray);
            }
        } catch (Exception e) {
        }
        return jSONObject.toString();
    }
}
