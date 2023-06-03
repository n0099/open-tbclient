package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class ew implements com.kwad.sdk.core.d<com.kwad.components.core.webview.b.a.n> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.core.webview.b.a.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nVar.NV = jSONObject.optBoolean("userForce");
        nVar.type = jSONObject.optInt("type");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.core.webview.b.a.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = nVar.NV;
        if (z) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "userForce", z);
        }
        int i = nVar.type;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "type", i);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.b.a.n nVar, JSONObject jSONObject) {
        a2(nVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.b.a.n nVar, JSONObject jSONObject) {
        return b2(nVar, jSONObject);
    }
}
