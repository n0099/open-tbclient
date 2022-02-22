package com.kwad.sdk.e.kwai;

import com.kuaishou.tachikoma.api.model.TKCDNUrl;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c implements com.kwad.sdk.e.e<TKCDNUrl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.e.e
    public void a(TKCDNUrl tKCDNUrl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tKCDNUrl.mCdn = jSONObject.optString("cdn");
        tKCDNUrl.mUrl = jSONObject.optString("url");
        tKCDNUrl.mUrlType = jSONObject.optString("urlType");
        tKCDNUrl.mIsFreeTrafficCdn = jSONObject.optBoolean("freeTrafficCdn");
        tKCDNUrl.mPushCdn = jSONObject.optString("pushCdn");
        tKCDNUrl.mIp = jSONObject.optString("ip");
        tKCDNUrl.mUrlPattern = jSONObject.optString("urlPattern");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.e.e
    public JSONObject b(TKCDNUrl tKCDNUrl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.e.f.a(jSONObject, "cdn", tKCDNUrl.mCdn);
        com.kwad.sdk.e.f.a(jSONObject, "url", tKCDNUrl.mUrl);
        com.kwad.sdk.e.f.a(jSONObject, "urlType", tKCDNUrl.mUrlType);
        com.kwad.sdk.e.f.a(jSONObject, "freeTrafficCdn", tKCDNUrl.mIsFreeTrafficCdn);
        com.kwad.sdk.e.f.a(jSONObject, "pushCdn", tKCDNUrl.mPushCdn);
        com.kwad.sdk.e.f.a(jSONObject, "ip", tKCDNUrl.mIp);
        com.kwad.sdk.e.f.a(jSONObject, "urlPattern", tKCDNUrl.mUrlPattern);
        return jSONObject;
    }
}
