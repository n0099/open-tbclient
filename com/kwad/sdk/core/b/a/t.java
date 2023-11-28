package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class t implements com.kwad.sdk.core.d<AdGlobalConfigInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdGlobalConfigInfo adGlobalConfigInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adGlobalConfigInfo.neoPageType = jSONObject.optInt("neoPageType");
        AdGlobalConfigInfo.NeoScanAggregationSceneInfo neoScanAggregationSceneInfo = new AdGlobalConfigInfo.NeoScanAggregationSceneInfo();
        adGlobalConfigInfo.neoScanAggregationSceneInfo = neoScanAggregationSceneInfo;
        neoScanAggregationSceneInfo.parseJson(jSONObject.optJSONObject("neoScanAggregationSceneInfo"));
        AdVideoPreCacheConfig adVideoPreCacheConfig = new AdVideoPreCacheConfig();
        adGlobalConfigInfo.adVideoPreCacheConfig = adVideoPreCacheConfig;
        adVideoPreCacheConfig.parseJson(jSONObject.optJSONObject("adVideoPreCacheConfig"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdGlobalConfigInfo adGlobalConfigInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = adGlobalConfigInfo.neoPageType;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "neoPageType", i);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "neoScanAggregationSceneInfo", adGlobalConfigInfo.neoScanAggregationSceneInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "adVideoPreCacheConfig", adGlobalConfigInfo.adVideoPreCacheConfig);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdGlobalConfigInfo adGlobalConfigInfo, JSONObject jSONObject) {
        a2(adGlobalConfigInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdGlobalConfigInfo adGlobalConfigInfo, JSONObject jSONObject) {
        return b2(adGlobalConfigInfo, jSONObject);
    }
}
