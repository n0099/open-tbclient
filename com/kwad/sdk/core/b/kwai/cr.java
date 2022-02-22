package com.kwad.sdk.core.b.kwai;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cr implements com.kwad.sdk.core.d<com.kwad.sdk.c.kwai.c> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.c.kwai.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.a = jSONObject.optString("sceneId");
        if (jSONObject.opt("sceneId") == JSONObject.NULL) {
            cVar.a = "";
        }
        cVar.f55678b = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("packages");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                com.kwad.sdk.c.kwai.d dVar = new com.kwad.sdk.c.kwai.d();
                dVar.parseJson(optJSONArray.optJSONObject(i2));
                cVar.f55678b.add(dVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.c.kwai.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "sceneId", cVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "packages", cVar.f55678b);
        return jSONObject;
    }
}
