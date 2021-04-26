package com.kwad.sdk.core.c.a;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ad implements com.kwad.sdk.core.c<com.kwad.sdk.collector.a.d> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(com.kwad.sdk.collector.a.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.f32693a = jSONObject.optInt("isRoot");
        dVar.f32694b = jSONObject.optInt("isXPosed");
        dVar.f32695c = jSONObject.optInt("isFrameworkHooked");
        dVar.f32696d = jSONObject.optInt("isVirtual");
        dVar.f32697e = jSONObject.optInt("isAdbEnabled");
        dVar.f32698f = jSONObject.optInt("isEmulator");
        dVar.f32699g = jSONObject.optInt("isGroupControl");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(com.kwad.sdk.collector.a.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "isRoot", dVar.f32693a);
        com.kwad.sdk.utils.o.a(jSONObject, "isXPosed", dVar.f32694b);
        com.kwad.sdk.utils.o.a(jSONObject, "isFrameworkHooked", dVar.f32695c);
        com.kwad.sdk.utils.o.a(jSONObject, "isVirtual", dVar.f32696d);
        com.kwad.sdk.utils.o.a(jSONObject, "isAdbEnabled", dVar.f32697e);
        com.kwad.sdk.utils.o.a(jSONObject, "isEmulator", dVar.f32698f);
        com.kwad.sdk.utils.o.a(jSONObject, "isGroupControl", dVar.f32699g);
        return jSONObject;
    }
}
