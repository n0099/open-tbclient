package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bh implements com.kwad.sdk.core.d<com.kwad.sdk.collector.kwai.d> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.collector.kwai.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.a = jSONObject.optInt("isRoot");
        dVar.f55734b = jSONObject.optInt("isXPosed");
        dVar.f55735c = jSONObject.optInt("isFrameworkHooked");
        dVar.f55736d = jSONObject.optInt("isVirtual");
        dVar.f55737e = jSONObject.optInt("isAdbEnabled");
        dVar.f55738f = jSONObject.optInt("isEmulator");
        dVar.f55739g = jSONObject.optInt("isGroupControl");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.collector.kwai.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "isRoot", dVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "isXPosed", dVar.f55734b);
        com.kwad.sdk.utils.t.a(jSONObject, "isFrameworkHooked", dVar.f55735c);
        com.kwad.sdk.utils.t.a(jSONObject, "isVirtual", dVar.f55736d);
        com.kwad.sdk.utils.t.a(jSONObject, "isAdbEnabled", dVar.f55737e);
        com.kwad.sdk.utils.t.a(jSONObject, "isEmulator", dVar.f55738f);
        com.kwad.sdk.utils.t.a(jSONObject, "isGroupControl", dVar.f55739g);
        return jSONObject;
    }
}
