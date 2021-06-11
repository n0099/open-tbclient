package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.retrieve.RetrieveFileData;
import com.kwad.sdk.core.preload.SplashPreloadManager;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class z implements com.kwad.sdk.core.c<SplashPreloadManager.PreLoadItem> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(SplashPreloadManager.PreLoadItem preLoadItem) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "cacheTime", preLoadItem.cacheTime);
        com.kwad.sdk.utils.o.a(jSONObject, RetrieveFileData.EXPIRED, preLoadItem.expiredTime);
        com.kwad.sdk.utils.o.a(jSONObject, "preloadId", preLoadItem.preloadId);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        preLoadItem.cacheTime = jSONObject.optLong("cacheTime");
        preLoadItem.expiredTime = jSONObject.optLong(RetrieveFileData.EXPIRED);
        preLoadItem.preloadId = jSONObject.optString("preloadId");
    }
}
