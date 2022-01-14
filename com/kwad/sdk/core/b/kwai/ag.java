package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ag implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.c> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.core.request.model.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.a = jSONObject.optInt("cellId");
        cVar.f56148b = jSONObject.optInt("lac");
        cVar.f56149c = jSONObject.optInt("bsss");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.core.request.model.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "cellId", cVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "lac", cVar.f56148b);
        com.kwad.sdk.utils.t.a(jSONObject, "bsss", cVar.f56149c);
        return jSONObject;
    }
}
