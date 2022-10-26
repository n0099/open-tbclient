package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.request.model.StatusInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class fd implements com.kwad.sdk.core.d {
    public static void a(StatusInfo.SplashAdInfo splashAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashAdInfo.dailyShowCount = jSONObject.optInt("dailyShowCount");
        StatusInfo.SplashStyleControl splashStyleControl = new StatusInfo.SplashStyleControl();
        splashAdInfo.splashStyleControl = splashStyleControl;
        splashStyleControl.parseJson(jSONObject.optJSONObject("splashStyleControl"));
    }

    public static JSONObject b(StatusInfo.SplashAdInfo splashAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = splashAdInfo.dailyShowCount;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "dailyShowCount", i);
        }
        com.kwad.sdk.utils.r.a(jSONObject, "splashStyleControl", splashAdInfo.splashStyleControl);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((StatusInfo.SplashAdInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((StatusInfo.SplashAdInfo) bVar, jSONObject);
    }
}
