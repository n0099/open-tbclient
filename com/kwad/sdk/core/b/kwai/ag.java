package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.jshandler.y;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ag implements com.kwad.sdk.core.d {
    public static void a(y.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.MD = jSONObject.optDouble("progress");
        aVar.status = jSONObject.optInt("status");
    }

    public static JSONObject b(y.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d = aVar.MD;
        if (d != 0.0d) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "progress", d);
        }
        int i = aVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "status", i);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((y.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((y.a) bVar, jSONObject);
    }
}
