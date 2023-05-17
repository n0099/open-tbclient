package com.kwad.sdk.core.b.kwai;

import android.net.http.Headers;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class cn implements com.kwad.sdk.core.d<com.kwad.components.a.kwai.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.a.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.PS = jSONObject.optString("Access-Control-Allow-Origin");
        if (jSONObject.opt("Access-Control-Allow-Origin") == JSONObject.NULL) {
            aVar.PS = "";
        }
        aVar.PT = jSONObject.optString("Timing-Allow-Origin");
        if (jSONObject.opt("Timing-Allow-Origin") == JSONObject.NULL) {
            aVar.PT = "";
        }
        aVar.PU = jSONObject.optString(Headers.CONTENT_TYPE);
        if (jSONObject.opt(Headers.CONTENT_TYPE) == JSONObject.NULL) {
            aVar.PU = "";
        }
        aVar.PV = jSONObject.optString("Date");
        if (jSONObject.opt("Date") == JSONObject.NULL) {
            aVar.PV = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.a.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.PS;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "Access-Control-Allow-Origin", aVar.PS);
        }
        String str2 = aVar.PT;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "Timing-Allow-Origin", aVar.PT);
        }
        String str3 = aVar.PU;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, Headers.CONTENT_TYPE, aVar.PU);
        }
        String str4 = aVar.PV;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "Date", aVar.PV);
        }
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
