package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.webview.kwai.h;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ba implements com.kwad.sdk.core.d<h.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            aVar.a = "";
        }
        aVar.b = jSONObject.optString("packageName");
        if (jSONObject.opt("packageName") == JSONObject.NULL) {
            aVar.b = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "url", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "packageName", aVar.b);
        return jSONObject;
    }
}
