package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class dp implements com.kwad.sdk.core.d<com.kwad.sdk.collector.kwai.e> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.collector.kwai.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        eVar.a = jSONObject.optInt("sensorType");
        eVar.f55574c = jSONObject.optLong("timestamp");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.collector.kwai.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "sensorType", eVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "timestamp", eVar.f55574c);
        return jSONObject;
    }
}
