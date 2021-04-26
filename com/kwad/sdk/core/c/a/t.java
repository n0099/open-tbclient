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
        cVar.f33054a = jSONObject.optInt("cellId");
        cVar.f33055b = jSONObject.optInt("lac");
        cVar.f33056c = jSONObject.optInt("bsss");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(com.kwad.sdk.core.g.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "cellId", cVar.f33054a);
        com.kwad.sdk.utils.o.a(jSONObject, "lac", cVar.f33055b);
        com.kwad.sdk.utils.o.a(jSONObject, "bsss", cVar.f33056c);
        return jSONObject;
    }
}
