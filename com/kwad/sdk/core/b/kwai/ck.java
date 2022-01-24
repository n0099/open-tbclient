package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ck implements com.kwad.sdk.core.d<com.kwad.sdk.c.kwai.b> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.c.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.a = jSONObject.optInt("Status");
        bVar.f55507b = jSONObject.optString("Content-Encoding");
        if (jSONObject.opt("Content-Encoding") == JSONObject.NULL) {
            bVar.f55507b = "";
        }
        bVar.f55508c = jSONObject.optString("Cache-Control");
        if (jSONObject.opt("Cache-Control") == JSONObject.NULL) {
            bVar.f55508c = "";
        }
        bVar.f55509d = jSONObject.optString("Content-Type");
        if (jSONObject.opt("Content-Type") == JSONObject.NULL) {
            bVar.f55509d = "";
        }
        com.kwad.sdk.c.kwai.a aVar = new com.kwad.sdk.c.kwai.a();
        bVar.f55510e = aVar;
        aVar.parseJson(jSONObject.optJSONObject("headers"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.c.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "Status", bVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "Content-Encoding", bVar.f55507b);
        com.kwad.sdk.utils.t.a(jSONObject, "Cache-Control", bVar.f55508c);
        com.kwad.sdk.utils.t.a(jSONObject, "Content-Type", bVar.f55509d);
        com.kwad.sdk.utils.t.a(jSONObject, "headers", bVar.f55510e);
        return jSONObject;
    }
}
