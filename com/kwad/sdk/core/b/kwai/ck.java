package com.kwad.sdk.core.b.kwai;

import com.baidubce.http.Headers;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ck implements com.kwad.sdk.core.d<com.kwad.sdk.c.kwai.b> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.c.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.a = jSONObject.optInt("Status");
        bVar.f39174b = jSONObject.optString("Content-Encoding");
        if (jSONObject.opt("Content-Encoding") == JSONObject.NULL) {
            bVar.f39174b = "";
        }
        bVar.f39175c = jSONObject.optString(Headers.CACHE_CONTROL);
        if (jSONObject.opt(Headers.CACHE_CONTROL) == JSONObject.NULL) {
            bVar.f39175c = "";
        }
        bVar.f39176d = jSONObject.optString("Content-Type");
        if (jSONObject.opt("Content-Type") == JSONObject.NULL) {
            bVar.f39176d = "";
        }
        com.kwad.sdk.c.kwai.a aVar = new com.kwad.sdk.c.kwai.a();
        bVar.f39177e = aVar;
        aVar.parseJson(jSONObject.optJSONObject("headers"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.c.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "Status", bVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "Content-Encoding", bVar.f39174b);
        com.kwad.sdk.utils.t.a(jSONObject, Headers.CACHE_CONTROL, bVar.f39175c);
        com.kwad.sdk.utils.t.a(jSONObject, "Content-Type", bVar.f39176d);
        com.kwad.sdk.utils.t.a(jSONObject, "headers", bVar.f39177e);
        return jSONObject;
    }
}
