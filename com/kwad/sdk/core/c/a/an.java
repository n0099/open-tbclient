package com.kwad.sdk.core.c.a;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class an implements com.kwad.sdk.core.c<com.kwad.sdk.core.g.a.g> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(com.kwad.sdk.core.g.a.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        gVar.f33071a = jSONObject.optString("feedAdH5Version");
        gVar.f33072b = jSONObject.optString("feedAdH5Url");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(com.kwad.sdk.core.g.a.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "feedAdH5Version", gVar.f33071a);
        com.kwad.sdk.utils.o.a(jSONObject, "feedAdH5Url", gVar.f33072b);
        return jSONObject;
    }
}
