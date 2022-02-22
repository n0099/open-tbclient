package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.webview.jshandler.v;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class es implements com.kwad.sdk.core.d<v.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(v.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt("status");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(v.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "status", aVar.a);
        return jSONObject;
    }
}
