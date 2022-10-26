package com.kwad.sdk.core.b.kwai;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class du implements com.kwad.sdk.core.d {
    public static void a(com.kwad.sdk.e.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.sceneId = jSONObject.optString("sceneId");
        if (jSONObject.opt("sceneId") == JSONObject.NULL) {
            aVar.sceneId = "";
        }
        aVar.ais = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("packages");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                com.kwad.sdk.e.kwai.b bVar = new com.kwad.sdk.e.kwai.b();
                bVar.parseJson(optJSONArray.optJSONObject(i));
                aVar.ais.add(bVar);
            }
        }
    }

    public static JSONObject b(com.kwad.sdk.e.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.sceneId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "sceneId", aVar.sceneId);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "packages", aVar.ais);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.e.kwai.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.e.kwai.a) bVar, jSONObject);
    }
}
