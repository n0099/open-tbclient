package com.kwad.sdk.core.webview.request;

import com.kwad.sdk.core.network.d;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.utils.t;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends d {
    public String b;
    public String c;

    public a(String str, String str2, String str3) {
        JSONObject jSONObject;
        this.b = str;
        this.c = str2;
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException e) {
            com.kwad.sdk.core.d.a.a(e);
            jSONObject = null;
        }
        com.kwad.sdk.core.d.a.a("WebCardGetDataRequest", "mBodyParams1 size=" + this.a.length());
        com.kwad.sdk.core.d.a.a("WebCardGetDataRequest", "paramsJsonObj=" + jSONObject.toString());
        t.a(this.a, jSONObject);
        com.kwad.sdk.core.d.a.a("WebCardGetDataRequest", "mBodyParams2 size=" + this.a.length());
        a("user-agent", k.c());
        a("BrowserUa", k.d());
        a("SystemUa", k.a());
        com.kwad.sdk.core.d.a.a("WebCardGetDataRequest", "user-agent" + k.c());
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.a() + this.b;
    }
}
