package com.kwad.sdk.core.b.kwai;

import com.baidubce.http.Headers;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class dk implements com.kwad.sdk.core.d {
    public static void a(com.kwad.components.a.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("Status");
        bVar.contentEncoding = jSONObject.optString("Content-Encoding");
        if (jSONObject.opt("Content-Encoding") == JSONObject.NULL) {
            bVar.contentEncoding = "";
        }
        bVar.PW = jSONObject.optString(Headers.CACHE_CONTROL);
        if (jSONObject.opt(Headers.CACHE_CONTROL) == JSONObject.NULL) {
            bVar.PW = "";
        }
        bVar.PU = jSONObject.optString("Content-Type");
        if (jSONObject.opt("Content-Type") == JSONObject.NULL) {
            bVar.PU = "";
        }
        com.kwad.components.a.kwai.a aVar = new com.kwad.components.a.kwai.a();
        bVar.PX = aVar;
        aVar.parseJson(jSONObject.optJSONObject("headers"));
    }

    public static JSONObject b(com.kwad.components.a.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "Status", i);
        }
        String str = bVar.contentEncoding;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "Content-Encoding", bVar.contentEncoding);
        }
        String str2 = bVar.PW;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, Headers.CACHE_CONTROL, bVar.PW);
        }
        String str3 = bVar.PU;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "Content-Type", bVar.PU);
        }
        com.kwad.sdk.utils.r.a(jSONObject, "headers", bVar.PX);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.a.kwai.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.a.kwai.b) bVar, jSONObject);
    }
}
