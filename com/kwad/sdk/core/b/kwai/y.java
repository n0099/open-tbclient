package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class y implements com.kwad.sdk.core.d<AdInfo.AdSplashInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adSplashInfo.logoPosition = jSONObject.optInt("logoPosition", new Integer("1").intValue());
        adSplashInfo.mute = jSONObject.optInt("mute", new Integer("1").intValue());
        adSplashInfo.skipType = jSONObject.optInt("skipType");
        adSplashInfo.skipTips = jSONObject.optString("skipTips");
        if (jSONObject.opt("skipTips") == JSONObject.NULL) {
            adSplashInfo.skipTips = "";
        }
        adSplashInfo.speakerMuteIconUrl = jSONObject.optString("speakerMuteIconUrl");
        if (jSONObject.opt("speakerMuteIconUrl") == JSONObject.NULL) {
            adSplashInfo.speakerMuteIconUrl = "";
        }
        adSplashInfo.speakerIconUrl = jSONObject.optString("speakerIconUrl");
        if (jSONObject.opt("speakerIconUrl") == JSONObject.NULL) {
            adSplashInfo.speakerIconUrl = "";
        }
        adSplashInfo.imageDisplaySecond = jSONObject.optInt("imageDisplaySecond", new Integer("5").intValue());
        adSplashInfo.videoDisplaySecond = jSONObject.optInt("videoDisplaySecond", new Integer("5").intValue());
        adSplashInfo.countdownShow = jSONObject.optInt("countdownShow");
        adSplashInfo.fullScreenClickSwitch = jSONObject.optInt("fullScreenClickSwitch");
        adSplashInfo.splashShowClickButtonSwitch = jSONObject.optInt("splashShowClickButtonSwitch", new Integer("1").intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "logoPosition", adSplashInfo.logoPosition);
        com.kwad.sdk.utils.r.a(jSONObject, "mute", adSplashInfo.mute);
        com.kwad.sdk.utils.r.a(jSONObject, "skipType", adSplashInfo.skipType);
        com.kwad.sdk.utils.r.a(jSONObject, "skipTips", adSplashInfo.skipTips);
        com.kwad.sdk.utils.r.a(jSONObject, "speakerMuteIconUrl", adSplashInfo.speakerMuteIconUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "speakerIconUrl", adSplashInfo.speakerIconUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "imageDisplaySecond", adSplashInfo.imageDisplaySecond);
        com.kwad.sdk.utils.r.a(jSONObject, "videoDisplaySecond", adSplashInfo.videoDisplaySecond);
        com.kwad.sdk.utils.r.a(jSONObject, "countdownShow", adSplashInfo.countdownShow);
        com.kwad.sdk.utils.r.a(jSONObject, "fullScreenClickSwitch", adSplashInfo.fullScreenClickSwitch);
        com.kwad.sdk.utils.r.a(jSONObject, "splashShowClickButtonSwitch", adSplashInfo.splashShowClickButtonSwitch);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        a2(adSplashInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        return b2(adSplashInfo, jSONObject);
    }
}
