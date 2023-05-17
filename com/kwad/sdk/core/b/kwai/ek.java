package com.kwad.sdk.core.b.kwai;

import com.baidu.sapi2.result.GetUserAttrInfoResult;
import com.kwad.components.splash.SplashPreloadManager;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class ek implements com.kwad.sdk.core.d<SplashPreloadManager.PreLoadItem> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        preLoadItem.cacheTime = jSONObject.optLong(GetUserAttrInfoResult.KEY_DATA_CACHE_TIME);
        preLoadItem.expiredTime = jSONObject.optLong("expiredTime");
        preLoadItem.preloadId = jSONObject.optString("preloadId");
        if (jSONObject.opt("preloadId") == JSONObject.NULL) {
            preLoadItem.preloadId = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = preLoadItem.cacheTime;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, GetUserAttrInfoResult.KEY_DATA_CACHE_TIME, j);
        }
        long j2 = preLoadItem.expiredTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "expiredTime", j2);
        }
        String str = preLoadItem.preloadId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "preloadId", preLoadItem.preloadId);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        a2(preLoadItem, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        return b2(preLoadItem, jSONObject);
    }
}
