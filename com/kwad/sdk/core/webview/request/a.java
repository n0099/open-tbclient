package com.kwad.sdk.core.webview.request;

import com.kwad.sdk.core.network.d;
import com.kwad.sdk.core.network.n;
import com.kwad.sdk.utils.r;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a extends d {
    public String a;
    public String b;

    public a(String str, String str2, String str3) {
        JSONObject jSONObject;
        this.a = str;
        this.b = str2;
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.a(e);
            jSONObject = null;
        }
        com.kwad.sdk.core.d.b.a("WebCardGetDataRequest", "mBodyParams1 size=" + this.mBodyParams.length());
        com.kwad.sdk.core.d.b.a("WebCardGetDataRequest", "paramsJsonObj=" + jSONObject.toString());
        r.a(this.mBodyParams, jSONObject);
        com.kwad.sdk.core.d.b.a("WebCardGetDataRequest", "mBodyParams2 size=" + this.mBodyParams.length());
        addHeader("user-agent", n.c());
        com.kwad.sdk.core.d.b.a("WebCardGetDataRequest", "user-agent" + n.c());
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return com.kwad.sdk.b.a() + this.a;
    }
}
