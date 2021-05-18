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
        dVar.f31938a = jSONObject.optInt("isRoot");
        dVar.f31939b = jSONObject.optInt("isXPosed");
        dVar.f31940c = jSONObject.optInt("isFrameworkHooked");
        dVar.f31941d = jSONObject.optInt("isVirtual");
        dVar.f31942e = jSONObject.optInt("isAdbEnabled");
        dVar.f31943f = jSONObject.optInt("isEmulator");
        dVar.f31944g = jSONObject.optInt("isGroupControl");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(com.kwad.sdk.collector.a.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "isRoot", dVar.f31938a);
        com.kwad.sdk.utils.o.a(jSONObject, "isXPosed", dVar.f31939b);
        com.kwad.sdk.utils.o.a(jSONObject, "isFrameworkHooked", dVar.f31940c);
        com.kwad.sdk.utils.o.a(jSONObject, "isVirtual", dVar.f31941d);
        com.kwad.sdk.utils.o.a(jSONObject, "isAdbEnabled", dVar.f31942e);
        com.kwad.sdk.utils.o.a(jSONObject, "isEmulator", dVar.f31943f);
        com.kwad.sdk.utils.o.a(jSONObject, "isGroupControl", dVar.f31944g);
        return jSONObject;
    }
}
