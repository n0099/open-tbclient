package com.kwad.sdk.core.c.a;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class w implements com.kwad.sdk.core.c<com.kwad.sdk.core.g.a.g> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(com.kwad.sdk.core.g.a.g gVar) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "feedAdH5Version", gVar.f34378a);
        com.kwad.sdk.utils.o.a(jSONObject, "feedAdH5Url", gVar.f34379b);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(com.kwad.sdk.core.g.a.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        gVar.f34378a = jSONObject.optString("feedAdH5Version");
        gVar.f34379b = jSONObject.optString("feedAdH5Url");
    }
}
