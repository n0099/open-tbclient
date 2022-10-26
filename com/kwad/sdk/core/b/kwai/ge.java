package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ge implements com.kwad.sdk.core.d {
    public static void a(WebViewCommercialMsg webViewCommercialMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        webViewCommercialMsg.category = jSONObject.optString("category");
        if (jSONObject.opt("category") == JSONObject.NULL) {
            webViewCommercialMsg.category = "";
        }
        webViewCommercialMsg.tag = jSONObject.optString("tag");
        if (jSONObject.opt("tag") == JSONObject.NULL) {
            webViewCommercialMsg.tag = "";
        }
        webViewCommercialMsg.msg = jSONObject.optJSONObject("msg");
        webViewCommercialMsg.extraParam = jSONObject.optJSONObject("extraParam");
        webViewCommercialMsg.eventId = jSONObject.optString("event_id");
        if (jSONObject.opt("event_id") == JSONObject.NULL) {
            webViewCommercialMsg.eventId = "";
        }
        webViewCommercialMsg.rate = jSONObject.optDouble("rate");
    }

    public static JSONObject b(WebViewCommercialMsg webViewCommercialMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = webViewCommercialMsg.category;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "category", webViewCommercialMsg.category);
        }
        String str2 = webViewCommercialMsg.tag;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "tag", webViewCommercialMsg.tag);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "msg", webViewCommercialMsg.msg);
        com.kwad.sdk.utils.r.putValue(jSONObject, "extraParam", webViewCommercialMsg.extraParam);
        String str3 = webViewCommercialMsg.eventId;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "event_id", webViewCommercialMsg.eventId);
        }
        double d = webViewCommercialMsg.rate;
        if (d != 0.0d) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "rate", d);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((WebViewCommercialMsg) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((WebViewCommercialMsg) bVar, jSONObject);
    }
}
