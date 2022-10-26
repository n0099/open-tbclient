package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.a.a;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class br implements com.kwad.sdk.core.d {
    public static void a(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.progress = jSONObject.optInt("progress");
    }

    public static JSONObject b(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "status", i);
        }
        int i2 = bVar.progress;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "progress", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.b) bVar, jSONObject);
    }
}
