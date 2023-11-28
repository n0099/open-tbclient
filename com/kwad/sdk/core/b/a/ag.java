package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class ag implements com.kwad.sdk.core.d<AdInfo.AdPreloadInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdInfo.AdPreloadInfo adPreloadInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adPreloadInfo.preloadId = jSONObject.optString("preloadId");
        if (JSONObject.NULL.toString().equals(adPreloadInfo.preloadId)) {
            adPreloadInfo.preloadId = "";
        }
        adPreloadInfo.preloadType = jSONObject.optInt("preloadType");
        adPreloadInfo.preloadTips = jSONObject.optString("preloadTips", new String("已提前加载"));
        adPreloadInfo.validityPeriod = jSONObject.optInt("validityPeriod", new Integer("604800").intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdInfo.AdPreloadInfo adPreloadInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = adPreloadInfo.preloadId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "preloadId", adPreloadInfo.preloadId);
        }
        int i = adPreloadInfo.preloadType;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "preloadType", i);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "preloadTips", adPreloadInfo.preloadTips);
        com.kwad.sdk.utils.t.putValue(jSONObject, "validityPeriod", adPreloadInfo.validityPeriod);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdPreloadInfo adPreloadInfo, JSONObject jSONObject) {
        a2(adPreloadInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdPreloadInfo adPreloadInfo, JSONObject jSONObject) {
        return b2(adPreloadInfo, jSONObject);
    }
}
