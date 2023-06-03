package com.kwad.sdk.core.b.kwai;

import com.kwad.components.splash.SplashPreloadManager;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class el implements com.kwad.sdk.core.d<SplashPreloadManager.PreLoadPara> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(SplashPreloadManager.PreLoadPara preLoadPara, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        preLoadPara.spreadTime = jSONObject.optLong("spreadTime");
        preLoadPara.isValidReturned = jSONObject.optInt("isValidReturned");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(SplashPreloadManager.PreLoadPara preLoadPara, JSONObject jSONObject) {
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SplashPreloadManager.PreLoadPara preLoadPara, JSONObject jSONObject) {
        a2(preLoadPara, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SplashPreloadManager.PreLoadPara preLoadPara, JSONObject jSONObject) {
        return b2(preLoadPara, jSONObject);
    }
}
