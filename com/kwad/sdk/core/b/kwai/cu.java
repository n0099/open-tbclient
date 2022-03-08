package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.webview.jshandler.p;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class cu implements com.kwad.sdk.core.d<p.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(p.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt("status");
        aVar.f54988b = jSONObject.optString("errorMsg");
        if (jSONObject.opt("errorMsg") == JSONObject.NULL) {
            aVar.f54988b = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(p.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "status", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "errorMsg", aVar.f54988b);
        return jSONObject;
    }
}
