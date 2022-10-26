package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class aq implements com.kwad.sdk.core.d {
    public static void a(com.kwad.sdk.core.webview.a.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.x = jSONObject.optDouble("x");
        bVar.y = jSONObject.optDouble("y");
        bVar.width = jSONObject.optInt("width");
        bVar.height = jSONObject.optInt("height");
    }

    public static JSONObject b(com.kwad.sdk.core.webview.a.a.b bVar, JSONObject jSONObject) {
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

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.webview.a.a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.webview.a.a.b) bVar, jSONObject);
    }
}
