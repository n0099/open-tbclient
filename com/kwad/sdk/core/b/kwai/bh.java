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
        dVar.f39233b = jSONObject.optInt("isXPosed");
        dVar.f39234c = jSONObject.optInt("isFrameworkHooked");
        dVar.f39235d = jSONObject.optInt("isVirtual");
        dVar.f39236e = jSONObject.optInt("isAdbEnabled");
        dVar.f39237f = jSONObject.optInt("isEmulator");
        dVar.f39238g = jSONObject.optInt("isGroupControl");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.collector.kwai.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "isRoot", dVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "isXPosed", dVar.f39233b);
        com.kwad.sdk.utils.t.a(jSONObject, "isFrameworkHooked", dVar.f39234c);
        com.kwad.sdk.utils.t.a(jSONObject, "isVirtual", dVar.f39235d);
        com.kwad.sdk.utils.t.a(jSONObject, "isAdbEnabled", dVar.f39236e);
        com.kwad.sdk.utils.t.a(jSONObject, "isEmulator", dVar.f39237f);
        com.kwad.sdk.utils.t.a(jSONObject, "isGroupControl", dVar.f39238g);
        return jSONObject;
    }
}
