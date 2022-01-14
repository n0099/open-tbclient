package com.kwad.sdk.core.webview.request;

import com.kwad.sdk.core.network.d;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.utils.t;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d {

    /* renamed from: b  reason: collision with root package name */
    public String f56485b;

    /* renamed from: c  reason: collision with root package name */
    public String f56486c;

    public a(String str, String str2, String str3) {
        JSONObject jSONObject;
        this.f56485b = str;
        this.f56486c = str2;
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
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
        return com.kwad.sdk.d.a() + this.f56485b;
    }
}
