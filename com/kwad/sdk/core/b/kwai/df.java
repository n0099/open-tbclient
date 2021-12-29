package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.retrieve.RetrieveFileData;
import com.kwad.sdk.core.preload.SplashPreloadManager;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class df implements com.kwad.sdk.core.d<SplashPreloadManager.PreLoadItem> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        preLoadItem.cacheTime = jSONObject.optLong("cacheTime");
        preLoadItem.expiredTime = jSONObject.optLong(RetrieveFileData.EXPIRED);
        preLoadItem.preloadId = jSONObject.optString("preloadId");
        if (jSONObject.opt("preloadId") == JSONObject.NULL) {
            preLoadItem.preloadId = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "cacheTime", preLoadItem.cacheTime);
        com.kwad.sdk.utils.t.a(jSONObject, RetrieveFileData.EXPIRED, preLoadItem.expiredTime);
        com.kwad.sdk.utils.t.a(jSONObject, "preloadId", preLoadItem.preloadId);
        return jSONObject;
    }
}
