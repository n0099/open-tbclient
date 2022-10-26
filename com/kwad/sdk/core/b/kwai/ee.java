package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ee implements com.kwad.sdk.core.d {
    public static void a(com.kwad.components.core.webview.b.a.m mVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        mVar.NU = jSONObject.optBoolean("isEnd");
    }

    public static JSONObject b(com.kwad.components.core.webview.b.a.m mVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = mVar.NU;
        if (z) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "isEnd", z);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.b.a.m) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.b.a.m) bVar, jSONObject);
    }
}
