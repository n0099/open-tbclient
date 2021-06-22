package com.kwai.video.ksvodplayerkit.b;

import com.kwai.video.ksvodplayerkit.b.c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class e {
    public static c.a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c.a aVar = new c.a();
        JSONArray optJSONArray = jSONObject.optJSONArray("representation");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    arrayList.add(g.a(optJSONObject));
                }
            }
            aVar.f38105a = arrayList;
        }
        return aVar;
    }

    public static String a(c.a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (aVar.f38105a != null && !aVar.f38105a.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (f fVar : aVar.f38105a) {
                    jSONArray.put(g.a(fVar));
                }
                jSONObject.put("representation", jSONArray);
            }
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }
}
