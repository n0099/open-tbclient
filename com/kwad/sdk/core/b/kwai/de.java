package com.kwad.sdk.core.b.kwai;

import com.baidubce.http.Headers;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class de implements com.kwad.sdk.core.d<com.kwad.components.a.kwai.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.a.kwai.b bVar, JSONObject jSONObject) {
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
        com.kwad.components.a.kwai.a aVar = new com.kwad.components.a.kwai.a();
        bVar.e = aVar;
        aVar.parseJson(jSONObject.optJSONObject("headers"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.a.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "Status", bVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "Content-Encoding", bVar.b);
        com.kwad.sdk.utils.r.a(jSONObject, Headers.CACHE_CONTROL, bVar.c);
        com.kwad.sdk.utils.r.a(jSONObject, "Content-Type", bVar.d);
        com.kwad.sdk.utils.r.a(jSONObject, "headers", bVar.e);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.a.kwai.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.a.kwai.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
