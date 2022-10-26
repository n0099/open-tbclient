package com.kwad.sdk.core.b.kwai;

import com.kwad.components.splash.SplashPreloadManager;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class el implements com.kwad.sdk.core.d {
    public static void a(SplashPreloadManager.PreLoadPara preLoadPara, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        preLoadPara.spreadTime = jSONObject.optLong("spreadTime");
        preLoadPara.isValidReturned = jSONObject.optInt("isValidReturned");
    }

    public static JSONObject b(SplashPreloadManager.PreLoadPara preLoadPara, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = preLoadPara.spreadTime;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "spreadTime", j);
        }
        int i = preLoadPara.isValidReturned;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "isValidReturned", i);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((SplashPreloadManager.PreLoadPara) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((SplashPreloadManager.PreLoadPara) bVar, jSONObject);
    }
}
