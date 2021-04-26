package com.kwad.sdk.core.c.a;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class bg implements com.kwad.sdk.core.c<com.kwad.sdk.collector.a.f> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(com.kwad.sdk.collector.a.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.f32703a = jSONObject.optInt("phoneCount");
        fVar.f32704b = jSONObject.optInt("activePhoneCount");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(com.kwad.sdk.collector.a.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "phoneCount", fVar.f32703a);
        com.kwad.sdk.utils.o.a(jSONObject, "activePhoneCount", fVar.f32704b);
        return jSONObject;
    }
}
