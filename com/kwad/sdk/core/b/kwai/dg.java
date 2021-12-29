package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.preload.SplashPreloadManager;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class dg implements com.kwad.sdk.core.d<SplashPreloadManager.PreLoadPara> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(SplashPreloadManager.PreLoadPara preLoadPara, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        preLoadPara.spreadTime = jSONObject.optLong("spreadTime");
        preLoadPara.isValidReturned = jSONObject.optInt("isValidReturned");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(SplashPreloadManager.PreLoadPara preLoadPara, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "spreadTime", preLoadPara.spreadTime);
        com.kwad.sdk.utils.t.a(jSONObject, "isValidReturned", preLoadPara.isValidReturned);
        return jSONObject;
    }
}
