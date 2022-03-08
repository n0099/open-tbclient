package com.kwad.sdk.core.b.kwai;

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
        bVar.f54024b = jSONObject.optString("Content-Encoding");
        if (jSONObject.opt("Content-Encoding") == JSONObject.NULL) {
            bVar.f54024b = "";
        }
        bVar.f54025c = jSONObject.optString("Cache-Control");
        if (jSONObject.opt("Cache-Control") == JSONObject.NULL) {
            bVar.f54025c = "";
        }
        bVar.f54026d = jSONObject.optString("Content-Type");
        if (jSONObject.opt("Content-Type") == JSONObject.NULL) {
            bVar.f54026d = "";
        }
        com.kwad.sdk.c.kwai.a aVar = new com.kwad.sdk.c.kwai.a();
        bVar.f54027e = aVar;
        aVar.parseJson(jSONObject.optJSONObject("headers"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.c.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "Status", bVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "Content-Encoding", bVar.f54024b);
        com.kwad.sdk.utils.t.a(jSONObject, "Cache-Control", bVar.f54025c);
        com.kwad.sdk.utils.t.a(jSONObject, "Content-Type", bVar.f54026d);
        com.kwad.sdk.utils.t.a(jSONObject, "headers", bVar.f54027e);
        return jSONObject;
    }
}
