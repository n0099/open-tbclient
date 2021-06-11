package com.kwad.sdk.core.c.a;

import com.kwad.sdk.emotion.model.CDNUrl;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j implements com.kwad.sdk.core.c<CDNUrl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(CDNUrl cDNUrl) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "cdn", cDNUrl.cdn);
        com.kwad.sdk.utils.o.a(jSONObject, "url", cDNUrl.url);
        com.kwad.sdk.utils.o.a(jSONObject, "ip", cDNUrl.ip);
        com.kwad.sdk.utils.o.a(jSONObject, "urlPattern", cDNUrl.urlPattern);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(CDNUrl cDNUrl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cDNUrl.cdn = jSONObject.optString("cdn");
        cDNUrl.url = jSONObject.optString("url");
        cDNUrl.ip = jSONObject.optString("ip");
        cDNUrl.urlPattern = jSONObject.optString("urlPattern");
    }
}
