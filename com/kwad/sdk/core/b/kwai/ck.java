package com.kwad.sdk.core.b.kwai;

import com.baidubce.http.Headers;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ck implements com.kwad.sdk.core.d<com.kwad.sdk.c.kwai.b> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.c.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.a = jSONObject.optInt("Status");
        bVar.b = jSONObject.optString("Content-Encoding");
        if (jSONObject.opt("Content-Encoding") == JSONObject.NULL) {
            bVar.b = "";
        }
        bVar.c = jSONObject.optString(Headers.CACHE_CONTROL);
        if (jSONObject.opt(Headers.CACHE_CONTROL) == JSONObject.NULL) {
            bVar.c = "";
        }
        bVar.d = jSONObject.optString("Content-Type");
        if (jSONObject.opt("Content-Type") == JSONObject.NULL) {
            bVar.d = "";
        }
        com.kwad.sdk.c.kwai.a aVar = new com.kwad.sdk.c.kwai.a();
        bVar.e = aVar;
        aVar.parseJson(jSONObject.optJSONObject("headers"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.c.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "Status", bVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "Content-Encoding", bVar.b);
        com.kwad.sdk.utils.t.a(jSONObject, Headers.CACHE_CONTROL, bVar.c);
        com.kwad.sdk.utils.t.a(jSONObject, "Content-Type", bVar.d);
        com.kwad.sdk.utils.t.a(jSONObject, "headers", bVar.e);
        return jSONObject;
    }
}
