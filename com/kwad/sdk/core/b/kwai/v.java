package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class v implements com.kwad.sdk.core.d {
    public static void a(AdInfo.AdPreloadInfo adPreloadInfo, JSONObject jSONObject) {
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

    public static JSONObject b(AdInfo.AdPreloadInfo adPreloadInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = adPreloadInfo.preloadId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "preloadId", adPreloadInfo.preloadId);
        }
        int i = adPreloadInfo.preloadType;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "preloadType", i);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "preloadTips", adPreloadInfo.preloadTips);
        com.kwad.sdk.utils.r.putValue(jSONObject, "validityPeriod", adPreloadInfo.validityPeriod);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdPreloadInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdPreloadInfo) bVar, jSONObject);
    }
}
