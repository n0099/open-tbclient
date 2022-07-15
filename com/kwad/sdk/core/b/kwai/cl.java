package com.kwad.sdk.core.b.kwai;

import android.net.http.Headers;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class cl implements com.kwad.sdk.core.d<com.kwad.components.a.kwai.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.a.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optString("Access-Control-Allow-Origin");
        if (jSONObject.opt("Access-Control-Allow-Origin") == JSONObject.NULL) {
            aVar.a = "";
        }
        aVar.b = jSONObject.optString("Timing-Allow-Origin");
        if (jSONObject.opt("Timing-Allow-Origin") == JSONObject.NULL) {
            aVar.b = "";
        }
        aVar.c = jSONObject.optString(Headers.CONTENT_TYPE);
        if (jSONObject.opt(Headers.CONTENT_TYPE) == JSONObject.NULL) {
            aVar.c = "";
        }
        aVar.d = jSONObject.optString("Date");
        if (jSONObject.opt("Date") == JSONObject.NULL) {
            aVar.d = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.a.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "Access-Control-Allow-Origin", aVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "Timing-Allow-Origin", aVar.b);
        com.kwad.sdk.utils.r.a(jSONObject, Headers.CONTENT_TYPE, aVar.c);
        com.kwad.sdk.utils.r.a(jSONObject, "Date", aVar.d);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.a.kwai.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.a.kwai.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
