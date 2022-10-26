package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class gf implements com.kwad.sdk.core.d {
    public static void a(WebViewLoadMsg webViewLoadMsg, JSONObject jSONObject) {
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
        webViewLoadMsg.ratioCount = jSONObject.optDouble("ratio_count");
    }

    public static JSONObject b(WebViewLoadMsg webViewLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = webViewLoadMsg.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "url", webViewLoadMsg.url);
        }
        int i = webViewLoadMsg.state;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "state", i);
        }
        String str2 = webViewLoadMsg.interval;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "interval", webViewLoadMsg.interval);
        }
        String str3 = webViewLoadMsg.failReason;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "fail_reason", webViewLoadMsg.failReason);
        }
        String str4 = webViewLoadMsg.costTime;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "cost_time", webViewLoadMsg.costTime);
        }
        double d = webViewLoadMsg.ratioCount;
        if (d != 0.0d) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "ratio_count", d);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((WebViewLoadMsg) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((WebViewLoadMsg) bVar, jSONObject);
    }
}
