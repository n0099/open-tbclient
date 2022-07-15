package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class er implements com.kwad.sdk.core.d<com.kwad.components.core.webview.b.kwai.p> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.core.webview.b.kwai.p pVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        pVar.a = jSONObject.optBoolean("needPromopt");
        pVar.b = jSONObject.optBoolean("needReport");
        pVar.c = jSONObject.optInt("showTime");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.core.webview.b.kwai.p pVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "needPromopt", pVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "needReport", pVar.b);
        com.kwad.sdk.utils.r.a(jSONObject, "showTime", pVar.c);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.b.kwai.p pVar, JSONObject jSONObject) {
        a2(pVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.b.kwai.p pVar, JSONObject jSONObject) {
        return b2(pVar, jSONObject);
    }
}
