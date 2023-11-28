package com.kwad.sdk.core.b.a;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class ir implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.t> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.core.webview.tachikoma.b.t tVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tVar.aae = jSONObject.optBoolean("needPromopt");
        tVar.KC = jSONObject.optBoolean("needReport");
        tVar.showTime = jSONObject.optInt("showTime");
        tVar.aaf = jSONObject.optLong("playDuration");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.t tVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = tVar.aae;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "needPromopt", z);
        }
        boolean z2 = tVar.KC;
        if (z2) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "needReport", z2);
        }
        int i = tVar.showTime;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showTime", i);
        }
        long j = tVar.aaf;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playDuration", j);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.t tVar, JSONObject jSONObject) {
        a2(tVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.t tVar, JSONObject jSONObject) {
        return b2(tVar, jSONObject);
    }
}
