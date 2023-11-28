package com.kwad.sdk.core.b.a;

import android.net.http.Headers;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class es implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.b.a.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aDm = jSONObject.optString("Access-Control-Allow-Origin");
        if (JSONObject.NULL.toString().equals(aVar.aDm)) {
            aVar.aDm = "";
        }
        aVar.aDn = jSONObject.optString("Timing-Allow-Origin");
        if (JSONObject.NULL.toString().equals(aVar.aDn)) {
            aVar.aDn = "";
        }
        aVar.aDo = jSONObject.optString(Headers.CONTENT_TYPE);
        if (JSONObject.NULL.toString().equals(aVar.aDo)) {
            aVar.aDo = "";
        }
        aVar.aDp = jSONObject.optString("Date");
        if (JSONObject.NULL.toString().equals(aVar.aDp)) {
            aVar.aDp = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.aDm;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "Access-Control-Allow-Origin", aVar.aDm);
        }
        String str2 = aVar.aDn;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "Timing-Allow-Origin", aVar.aDn);
        }
        String str3 = aVar.aDo;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, Headers.CONTENT_TYPE, aVar.aDo);
        }
        String str4 = aVar.aDp;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "Date", aVar.aDp);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
