package com.kwad.sdk.e.kwai;

import com.tachikoma.core.component.imageview.TKCDNUrlInner;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d implements com.kwad.sdk.e.e<TKCDNUrlInner> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.e.e
    public void a(TKCDNUrlInner tKCDNUrlInner, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tKCDNUrlInner.mCdn = jSONObject.optString("cdn");
        tKCDNUrlInner.mUrl = jSONObject.optString("url");
        tKCDNUrlInner.mUrlType = jSONObject.optString("urlType");
        tKCDNUrlInner.mIsFreeTrafficCdn = jSONObject.optBoolean("freeTrafficCdn");
        tKCDNUrlInner.mPushCdn = jSONObject.optString("pushCdn");
        tKCDNUrlInner.mIp = jSONObject.optString("ip");
        tKCDNUrlInner.mUrlPattern = jSONObject.optString("urlPattern");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.e.e
    public JSONObject b(TKCDNUrlInner tKCDNUrlInner, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.e.f.a(jSONObject, "cdn", tKCDNUrlInner.mCdn);
        com.kwad.sdk.e.f.a(jSONObject, "url", tKCDNUrlInner.mUrl);
        com.kwad.sdk.e.f.a(jSONObject, "urlType", tKCDNUrlInner.mUrlType);
        com.kwad.sdk.e.f.a(jSONObject, "freeTrafficCdn", tKCDNUrlInner.mIsFreeTrafficCdn);
        com.kwad.sdk.e.f.a(jSONObject, "pushCdn", tKCDNUrlInner.mPushCdn);
        com.kwad.sdk.e.f.a(jSONObject, "ip", tKCDNUrlInner.mIp);
        com.kwad.sdk.e.f.a(jSONObject, "urlPattern", tKCDNUrlInner.mUrlPattern);
        return jSONObject;
    }
}
