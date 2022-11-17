package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class aq implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.a.a.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.core.webview.a.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.x = jSONObject.optDouble("x");
        bVar.y = jSONObject.optDouble("y");
        bVar.width = jSONObject.optInt("width");
        bVar.height = jSONObject.optInt("height");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.core.webview.a.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d = bVar.x;
        if (d != 0.0d) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "x", d);
        }
        double d2 = bVar.y;
        if (d2 != 0.0d) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "y", d2);
        }
        int i = bVar.width;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "width", i);
        }
        int i2 = bVar.height;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "height", i2);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.a.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.a.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
