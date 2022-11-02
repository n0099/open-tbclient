package com.kwad.sdk.core.webview.request;

import com.kwad.sdk.core.network.d;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.utils.r;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class a extends d {
    public String ags;
    public String mUrl;

    public a(String str, String str2, String str3) {
        JSONObject jSONObject;
        this.mUrl = str;
        this.ags = str2;
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
            jSONObject = null;
        }
        com.kwad.sdk.core.e.b.d("WebCardGetDataRequest", "mBodyParams1 size=" + this.mBodyParams.length());
        if (jSONObject != null) {
            com.kwad.sdk.core.e.b.d("WebCardGetDataRequest", "paramsJsonObj=" + jSONObject.toString());
        }
        r.merge(this.mBodyParams, jSONObject);
        com.kwad.sdk.core.e.b.d("WebCardGetDataRequest", "mBodyParams2 size=" + this.mBodyParams.length());
        addHeader("user-agent", o.getUserAgent());
        com.kwad.sdk.core.e.b.d("WebCardGetDataRequest", "user-agent" + o.getUserAgent());
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return com.kwad.sdk.b.qJ() + this.mUrl;
    }
}
