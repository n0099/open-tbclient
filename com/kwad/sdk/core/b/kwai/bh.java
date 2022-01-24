package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bh implements com.kwad.sdk.core.d<com.kwad.sdk.collector.kwai.d> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.collector.kwai.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.a = jSONObject.optInt("isRoot");
        dVar.f55567b = jSONObject.optInt("isXPosed");
        dVar.f55568c = jSONObject.optInt("isFrameworkHooked");
        dVar.f55569d = jSONObject.optInt("isVirtual");
        dVar.f55570e = jSONObject.optInt("isAdbEnabled");
        dVar.f55571f = jSONObject.optInt("isEmulator");
        dVar.f55572g = jSONObject.optInt("isGroupControl");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.collector.kwai.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "isRoot", dVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "isXPosed", dVar.f55567b);
        com.kwad.sdk.utils.t.a(jSONObject, "isFrameworkHooked", dVar.f55568c);
        com.kwad.sdk.utils.t.a(jSONObject, "isVirtual", dVar.f55569d);
        com.kwad.sdk.utils.t.a(jSONObject, "isAdbEnabled", dVar.f55570e);
        com.kwad.sdk.utils.t.a(jSONObject, "isEmulator", dVar.f55571f);
        com.kwad.sdk.utils.t.a(jSONObject, "isGroupControl", dVar.f55572g);
        return jSONObject;
    }
}
