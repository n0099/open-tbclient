package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class gc implements com.kwad.sdk.core.d<com.kwad.components.core.webview.b.a.s> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.core.webview.b.a.s sVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        sVar.kD = jSONObject.optInt("currentTime");
        sVar.NZ = jSONObject.optBoolean("failed");
        sVar.Oa = jSONObject.optBoolean("finished");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.core.webview.b.a.s sVar, JSONObject jSONObject) {
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.b.a.s sVar, JSONObject jSONObject) {
        a2(sVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.b.a.s sVar, JSONObject jSONObject) {
        return b2(sVar, jSONObject);
    }
}
