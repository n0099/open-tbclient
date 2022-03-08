package com.kwad.sdk.core.report.kwai;

import com.kwad.sdk.utils.t;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a implements b {
    @Override // com.kwad.sdk.core.report.kwai.b
    public void a(JSONObject jSONObject, Map<String, Object> map) {
        JSONObject optJSONObject = jSONObject.optJSONObject("ecExt");
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                map.put(next, optJSONObject.opt(next));
            }
        }
    }

    @Override // com.kwad.sdk.core.report.kwai.b
    public void b(JSONObject jSONObject, Map<String, Object> map) {
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
                jSONObject2.put(entry.getKey(), entry.getValue());
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
        if (jSONObject2.length() > 0) {
            t.a(jSONObject, "ecExt", jSONObject2);
        }
    }
}
