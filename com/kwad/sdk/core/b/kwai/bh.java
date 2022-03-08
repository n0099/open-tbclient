package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class bh implements com.kwad.sdk.core.d<com.kwad.sdk.collector.kwai.d> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.collector.kwai.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.a = jSONObject.optInt("isRoot");
        dVar.f54084b = jSONObject.optInt("isXPosed");
        dVar.f54085c = jSONObject.optInt("isFrameworkHooked");
        dVar.f54086d = jSONObject.optInt("isVirtual");
        dVar.f54087e = jSONObject.optInt("isAdbEnabled");
        dVar.f54088f = jSONObject.optInt("isEmulator");
        dVar.f54089g = jSONObject.optInt("isGroupControl");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.collector.kwai.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "isRoot", dVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "isXPosed", dVar.f54084b);
        com.kwad.sdk.utils.t.a(jSONObject, "isFrameworkHooked", dVar.f54085c);
        com.kwad.sdk.utils.t.a(jSONObject, "isVirtual", dVar.f54086d);
        com.kwad.sdk.utils.t.a(jSONObject, "isAdbEnabled", dVar.f54087e);
        com.kwad.sdk.utils.t.a(jSONObject, "isEmulator", dVar.f54088f);
        com.kwad.sdk.utils.t.a(jSONObject, "isGroupControl", dVar.f54089g);
        return jSONObject;
    }
}
