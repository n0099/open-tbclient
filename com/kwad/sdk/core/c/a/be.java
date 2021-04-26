package com.kwad.sdk.core.c.a;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class be implements com.kwad.sdk.core.c<com.kwad.sdk.collector.a.e> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(com.kwad.sdk.collector.a.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        eVar.f32700a = jSONObject.optInt("sensorType");
        eVar.f32702c = jSONObject.optLong("timestamp");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(com.kwad.sdk.collector.a.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "sensorType", eVar.f32700a);
        com.kwad.sdk.utils.o.a(jSONObject, "timestamp", eVar.f32702c);
        return jSONObject;
    }
}
