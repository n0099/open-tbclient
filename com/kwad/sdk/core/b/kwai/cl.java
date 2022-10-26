package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.jshandler.u;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class cl implements com.kwad.sdk.core.d {
    public static void a(u.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.creativeId = jSONObject.optLong("creativeId", new Long("-1").longValue());
    }

    public static JSONObject b(u.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "creativeId", bVar.creativeId);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((u.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((u.b) bVar, jSONObject);
    }
}
