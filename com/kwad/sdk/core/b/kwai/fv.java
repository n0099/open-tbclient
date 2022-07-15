package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class fv implements com.kwad.sdk.core.d<WebViewLoadMsg> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(WebViewLoadMsg webViewLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        webViewLoadMsg.url = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            webViewLoadMsg.url = "";
        }
        webViewLoadMsg.state = jSONObject.optInt("state");
        webViewLoadMsg.interval = jSONObject.optString("interval");
        if (jSONObject.opt("interval") == JSONObject.NULL) {
            webViewLoadMsg.interval = "";
        }
        webViewLoadMsg.failReason = jSONObject.optString("fail_reason");
        if (jSONObject.opt("fail_reason") == JSONObject.NULL) {
            webViewLoadMsg.failReason = "";
        }
        webViewLoadMsg.costTime = jSONObject.optString("cost_time");
        if (jSONObject.opt("cost_time") == JSONObject.NULL) {
            webViewLoadMsg.costTime = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(WebViewLoadMsg webViewLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "url", webViewLoadMsg.url);
        com.kwad.sdk.utils.r.a(jSONObject, "state", webViewLoadMsg.state);
        com.kwad.sdk.utils.r.a(jSONObject, "interval", webViewLoadMsg.interval);
        com.kwad.sdk.utils.r.a(jSONObject, "fail_reason", webViewLoadMsg.failReason);
        com.kwad.sdk.utils.r.a(jSONObject, "cost_time", webViewLoadMsg.costTime);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(WebViewLoadMsg webViewLoadMsg, JSONObject jSONObject) {
        a2(webViewLoadMsg, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(WebViewLoadMsg webViewLoadMsg, JSONObject jSONObject) {
        return b2(webViewLoadMsg, jSONObject);
    }
}
