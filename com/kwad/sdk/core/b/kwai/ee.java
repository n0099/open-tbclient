package com.kwad.sdk.core.b.kwai;

import com.kwad.components.ad.splashscreen.preload.SplashPreloadManager;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ee implements com.kwad.sdk.core.d<SplashPreloadManager.PreLoadItem> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        preLoadItem.cacheTime = jSONObject.optLong("cacheTime");
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
        com.kwad.sdk.utils.r.a(jSONObject, "cacheTime", preLoadItem.cacheTime);
        com.kwad.sdk.utils.r.a(jSONObject, "expiredTime", preLoadItem.expiredTime);
        com.kwad.sdk.utils.r.a(jSONObject, "preloadId", preLoadItem.preloadId);
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
