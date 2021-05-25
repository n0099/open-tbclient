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
        dVar.f31867a = jSONObject.optInt("isRoot");
        dVar.f31868b = jSONObject.optInt("isXPosed");
        dVar.f31869c = jSONObject.optInt("isFrameworkHooked");
        dVar.f31870d = jSONObject.optInt("isVirtual");
        dVar.f31871e = jSONObject.optInt("isAdbEnabled");
        dVar.f31872f = jSONObject.optInt("isEmulator");
        dVar.f31873g = jSONObject.optInt("isGroupControl");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(com.kwad.sdk.collector.a.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "isRoot", dVar.f31867a);
        com.kwad.sdk.utils.o.a(jSONObject, "isXPosed", dVar.f31868b);
        com.kwad.sdk.utils.o.a(jSONObject, "isFrameworkHooked", dVar.f31869c);
        com.kwad.sdk.utils.o.a(jSONObject, "isVirtual", dVar.f31870d);
        com.kwad.sdk.utils.o.a(jSONObject, "isAdbEnabled", dVar.f31871e);
        com.kwad.sdk.utils.o.a(jSONObject, "isEmulator", dVar.f31872f);
        com.kwad.sdk.utils.o.a(jSONObject, "isGroupControl", dVar.f31873g);
        return jSONObject;
    }
}
