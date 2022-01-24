package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.webview.kwai.h;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bd implements com.kwad.sdk.core.d<h.b> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(h.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.a = jSONObject.optInt("status");
        bVar.f56527b = jSONObject.optInt("progress");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(h.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "status", bVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "progress", bVar.f56527b);
        return jSONObject;
    }
}
