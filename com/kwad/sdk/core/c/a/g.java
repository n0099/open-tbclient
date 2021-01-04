package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class g implements com.kwad.sdk.core.c<AdInfo.AdSplashInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(AdInfo.AdSplashInfo adSplashInfo) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "logoPosition", adSplashInfo.logoPosition);
        com.kwad.sdk.utils.o.a(jSONObject, "skipSecond", adSplashInfo.skipSecond);
        com.kwad.sdk.utils.o.a(jSONObject, "mute", adSplashInfo.mute);
        com.kwad.sdk.utils.o.a(jSONObject, "skipTips", adSplashInfo.skipTips);
        com.kwad.sdk.utils.o.a(jSONObject, "speakerMuteIconUrl", adSplashInfo.speakerMuteIconUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "speakerIconUrl", adSplashInfo.speakerIconUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "imageDisplaySecond", adSplashInfo.imageDisplaySecond);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adSplashInfo.logoPosition = jSONObject.optInt("logoPosition", new Integer("1").intValue());
        adSplashInfo.skipSecond = jSONObject.optInt("skipSecond");
        adSplashInfo.mute = jSONObject.optInt("mute", new Integer("1").intValue());
        adSplashInfo.skipTips = jSONObject.optString("skipTips");
        adSplashInfo.speakerMuteIconUrl = jSONObject.optString("speakerMuteIconUrl");
        adSplashInfo.speakerIconUrl = jSONObject.optString("speakerIconUrl");
        adSplashInfo.imageDisplaySecond = jSONObject.optInt("imageDisplaySecond", new Integer("5").intValue());
    }
}
