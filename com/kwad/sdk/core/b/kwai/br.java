package com.kwad.sdk.core.b.kwai;

import android.net.http.Headers;
import org.json.JSONObject;
/* loaded from: classes7.dex */
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
        aVar.f39171b = jSONObject.optString("Timing-Allow-Origin");
        if (jSONObject.opt("Timing-Allow-Origin") == JSONObject.NULL) {
            aVar.f39171b = "";
        }
        aVar.f39172c = jSONObject.optString(Headers.CONTENT_TYPE);
        if (jSONObject.opt(Headers.CONTENT_TYPE) == JSONObject.NULL) {
            aVar.f39172c = "";
        }
        aVar.f39173d = jSONObject.optString("Date");
        if (jSONObject.opt("Date") == JSONObject.NULL) {
            aVar.f39173d = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.c.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "Access-Control-Allow-Origin", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "Timing-Allow-Origin", aVar.f39171b);
        com.kwad.sdk.utils.t.a(jSONObject, Headers.CONTENT_TYPE, aVar.f39172c);
        com.kwad.sdk.utils.t.a(jSONObject, "Date", aVar.f39173d);
        return jSONObject;
    }
}
