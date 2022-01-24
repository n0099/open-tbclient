package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.webview.jshandler.n;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class cd implements com.kwad.sdk.core.d<n.b> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(n.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.a = jSONObject.optDouble("progress");
        bVar.f56466b = jSONObject.optInt("status");
        bVar.f56467c = jSONObject.optLong("totalBytes");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(n.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "progress", bVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "status", bVar.f56466b);
        com.kwad.sdk.utils.t.a(jSONObject, "totalBytes", bVar.f56467c);
        return jSONObject;
    }
}
