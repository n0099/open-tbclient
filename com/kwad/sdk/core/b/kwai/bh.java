package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bh implements com.kwad.sdk.core.d<com.kwad.sdk.collector.kwai.d> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.collector.kwai.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.a = jSONObject.optInt("isRoot");
        dVar.b = jSONObject.optInt("isXPosed");
        dVar.c = jSONObject.optInt("isFrameworkHooked");
        dVar.d = jSONObject.optInt("isVirtual");
        dVar.e = jSONObject.optInt("isAdbEnabled");
        dVar.f = jSONObject.optInt("isEmulator");
        dVar.g = jSONObject.optInt("isGroupControl");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.collector.kwai.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "isRoot", dVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "isXPosed", dVar.b);
        com.kwad.sdk.utils.t.a(jSONObject, "isFrameworkHooked", dVar.c);
        com.kwad.sdk.utils.t.a(jSONObject, "isVirtual", dVar.d);
        com.kwad.sdk.utils.t.a(jSONObject, "isAdbEnabled", dVar.e);
        com.kwad.sdk.utils.t.a(jSONObject, "isEmulator", dVar.f);
        com.kwad.sdk.utils.t.a(jSONObject, "isGroupControl", dVar.g);
        return jSONObject;
    }
}
