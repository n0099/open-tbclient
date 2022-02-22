package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.webview.jshandler.q;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class z implements com.kwad.sdk.core.d<q.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(q.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optDouble("progress");
        aVar.f56644b = jSONObject.optInt("status");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(q.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "progress", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "status", aVar.f56644b);
        return jSONObject;
    }
}
