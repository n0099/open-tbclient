package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ez implements com.kwad.sdk.core.d<com.kwad.components.core.webview.b.a.q> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.core.webview.b.a.q qVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        qVar.NW = jSONObject.optBoolean("needPromopt");
        qVar.DZ = jSONObject.optBoolean("needReport");
        qVar.NX = jSONObject.optInt("showTime");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.core.webview.b.a.q qVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = qVar.NW;
        if (z) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "needPromopt", z);
        }
        boolean z2 = qVar.DZ;
        if (z2) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "needReport", z2);
        }
        int i = qVar.NX;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "showTime", i);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.b.a.q qVar, JSONObject jSONObject) {
        a2(qVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.b.a.q qVar, JSONObject jSONObject) {
        return b2(qVar, jSONObject);
    }
}
