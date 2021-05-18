package com.kwad.sdk.core.c.a;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class t implements com.kwad.sdk.core.c<com.kwad.sdk.core.g.a.c> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(com.kwad.sdk.core.g.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.f32299a = jSONObject.optInt("cellId");
        cVar.f32300b = jSONObject.optInt("lac");
        cVar.f32301c = jSONObject.optInt("bsss");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(com.kwad.sdk.core.g.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "cellId", cVar.f32299a);
        com.kwad.sdk.utils.o.a(jSONObject, "lac", cVar.f32300b);
        com.kwad.sdk.utils.o.a(jSONObject, "bsss", cVar.f32301c);
        return jSONObject;
    }
}
