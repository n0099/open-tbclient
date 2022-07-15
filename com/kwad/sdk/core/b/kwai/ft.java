package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ft implements com.kwad.sdk.core.d<com.kwad.components.core.webview.b.kwai.q> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.core.webview.b.kwai.q qVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        qVar.a = jSONObject.optInt("currentTime");
        qVar.b = jSONObject.optBoolean("failed");
        qVar.c = jSONObject.optBoolean("finished");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.core.webview.b.kwai.q qVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "currentTime", qVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "failed", qVar.b);
        com.kwad.sdk.utils.r.a(jSONObject, "finished", qVar.c);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.b.kwai.q qVar, JSONObject jSONObject) {
        a2(qVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.b.kwai.q qVar, JSONObject jSONObject) {
        return b2(qVar, jSONObject);
    }
}
