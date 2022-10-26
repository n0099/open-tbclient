package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.jshandler.v;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class db implements com.kwad.sdk.core.d {
    public static void a(v.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.MD = jSONObject.optDouble("progress");
        bVar.status = jSONObject.optInt("status");
        bVar.totalBytes = jSONObject.optLong("totalBytes");
    }

    public static JSONObject b(v.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d = bVar.MD;
        if (d != 0.0d) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "progress", d);
        }
        int i = bVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "status", i);
        }
        long j = bVar.totalBytes;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "totalBytes", j);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((v.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((v.b) bVar, jSONObject);
    }
}
