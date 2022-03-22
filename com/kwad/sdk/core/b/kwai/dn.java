package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.webview.jshandler.w;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class dn implements com.kwad.sdk.core.d<w.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(w.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            aVar.a = "";
        }
        aVar.f40106b = jSONObject.optString("method");
        if (jSONObject.opt("method") == JSONObject.NULL) {
            aVar.f40106b = "";
        }
        aVar.f40107c = jSONObject.optString("params");
        if (jSONObject.opt("params") == JSONObject.NULL) {
            aVar.f40107c = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(w.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "url", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "method", aVar.f40106b);
        com.kwad.sdk.utils.t.a(jSONObject, "params", aVar.f40107c);
        return jSONObject;
    }
}
