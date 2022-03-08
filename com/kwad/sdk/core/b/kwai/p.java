package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class p implements com.kwad.sdk.core.d<AdInfo.AdPreloadInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(AdInfo.AdPreloadInfo adPreloadInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adPreloadInfo.preloadId = jSONObject.optString("preloadId");
        if (jSONObject.opt("preloadId") == JSONObject.NULL) {
            adPreloadInfo.preloadId = "";
        }
        adPreloadInfo.preloadType = jSONObject.optInt("preloadType");
        adPreloadInfo.preloadTips = jSONObject.optString("preloadTips", new String("已提前加载"));
        adPreloadInfo.validityPeriod = jSONObject.optInt("validityPeriod", new Integer("604800").intValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdInfo.AdPreloadInfo adPreloadInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "preloadId", adPreloadInfo.preloadId);
        com.kwad.sdk.utils.t.a(jSONObject, "preloadType", adPreloadInfo.preloadType);
        com.kwad.sdk.utils.t.a(jSONObject, "preloadTips", adPreloadInfo.preloadTips);
        com.kwad.sdk.utils.t.a(jSONObject, "validityPeriod", adPreloadInfo.validityPeriod);
        return jSONObject;
    }
}
