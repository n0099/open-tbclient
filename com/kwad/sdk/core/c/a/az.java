package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.preload.SplashPreloadManager;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class az implements com.kwad.sdk.core.c<SplashPreloadManager.PreLoadPara> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(SplashPreloadManager.PreLoadPara preLoadPara, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        preLoadPara.spreadTime = jSONObject.optLong("spreadTime");
        preLoadPara.isValidReturned = jSONObject.optInt("isValidReturned");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(SplashPreloadManager.PreLoadPara preLoadPara, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "spreadTime", preLoadPara.spreadTime);
        com.kwad.sdk.utils.o.a(jSONObject, "isValidReturned", preLoadPara.isValidReturned);
        return jSONObject;
    }
}
