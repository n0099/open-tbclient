package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class gc implements com.kwad.sdk.core.d {
    public static void a(com.kwad.components.core.webview.b.a.s sVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        sVar.kD = jSONObject.optInt("currentTime");
        sVar.NZ = jSONObject.optBoolean("failed");
        sVar.Oa = jSONObject.optBoolean("finished");
    }

    public static JSONObject b(com.kwad.components.core.webview.b.a.s sVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = sVar.kD;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "currentTime", i);
        }
        boolean z = sVar.NZ;
        if (z) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "failed", z);
        }
        boolean z2 = sVar.Oa;
        if (z2) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "finished", z2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.b.a.s) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.b.a.s) bVar, jSONObject);
    }
}
