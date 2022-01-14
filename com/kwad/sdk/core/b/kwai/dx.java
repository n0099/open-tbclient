package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class dx implements com.kwad.sdk.core.d<com.kwad.sdk.splashscreen.kwai.b> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.splashscreen.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.a = jSONObject.optLong("lastShowShakeTimestamp");
        bVar.f57887b = jSONObject.optInt("currentDailyCount");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.splashscreen.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "lastShowShakeTimestamp", bVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "currentDailyCount", bVar.f57887b);
        return jSONObject;
    }
}
