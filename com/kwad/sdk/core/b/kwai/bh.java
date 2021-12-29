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
        dVar.f57708b = jSONObject.optInt("isXPosed");
        dVar.f57709c = jSONObject.optInt("isFrameworkHooked");
        dVar.f57710d = jSONObject.optInt("isVirtual");
        dVar.f57711e = jSONObject.optInt("isAdbEnabled");
        dVar.f57712f = jSONObject.optInt("isEmulator");
        dVar.f57713g = jSONObject.optInt("isGroupControl");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.collector.kwai.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "isRoot", dVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "isXPosed", dVar.f57708b);
        com.kwad.sdk.utils.t.a(jSONObject, "isFrameworkHooked", dVar.f57709c);
        com.kwad.sdk.utils.t.a(jSONObject, "isVirtual", dVar.f57710d);
        com.kwad.sdk.utils.t.a(jSONObject, "isAdbEnabled", dVar.f57711e);
        com.kwad.sdk.utils.t.a(jSONObject, "isEmulator", dVar.f57712f);
        com.kwad.sdk.utils.t.a(jSONObject, "isGroupControl", dVar.f57713g);
        return jSONObject;
    }
}
