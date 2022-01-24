package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class br implements com.kwad.sdk.core.d<com.kwad.sdk.c.kwai.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.c.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optString("Access-Control-Allow-Origin");
        if (jSONObject.opt("Access-Control-Allow-Origin") == JSONObject.NULL) {
            aVar.a = "";
        }
        aVar.f55504b = jSONObject.optString("Timing-Allow-Origin");
        if (jSONObject.opt("Timing-Allow-Origin") == JSONObject.NULL) {
            aVar.f55504b = "";
        }
        aVar.f55505c = jSONObject.optString("content-type");
        if (jSONObject.opt("content-type") == JSONObject.NULL) {
            aVar.f55505c = "";
        }
        aVar.f55506d = jSONObject.optString("Date");
        if (jSONObject.opt("Date") == JSONObject.NULL) {
            aVar.f55506d = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.c.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "Access-Control-Allow-Origin", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "Timing-Allow-Origin", aVar.f55504b);
        com.kwad.sdk.utils.t.a(jSONObject, "content-type", aVar.f55505c);
        com.kwad.sdk.utils.t.a(jSONObject, "Date", aVar.f55506d);
        return jSONObject;
    }
}
