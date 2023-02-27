package com.kwad.components.core.webview.a;

import com.ksad.json.annotation.KsJson;
import org.json.JSONObject;
@KsJson
/* loaded from: classes8.dex */
public final class b extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public String params;
    public String title;
    public String url;

    public final long pv() {
        try {
            return new JSONObject(this.params).optLong("creativeId", -1L);
        } catch (Exception unused) {
            return -1L;
        }
    }
}
