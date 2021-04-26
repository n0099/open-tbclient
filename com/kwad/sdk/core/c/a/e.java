package com.kwad.sdk.core.c.a;

import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e implements com.kwad.sdk.core.c<AdInfo.AdConversionInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adConversionInfo.h5Url = jSONObject.optString("h5Url");
        adConversionInfo.h5Type = jSONObject.optInt("h5Type");
        adConversionInfo.deeplinkUrl = jSONObject.optString(BaiduAppJsBridgeHandler.INPUT_PARAM_DEEP_LINK_URL);
        adConversionInfo.appDownloadUrl = jSONObject.optString("appDownloadUrl");
        adConversionInfo.marketUrl = jSONObject.optString("marketUrl");
        adConversionInfo.retryH5TimeStep = jSONObject.optInt("retryH5TimeStep", new Integer("2000").intValue());
        adConversionInfo.playableUrl = jSONObject.optString("playableUrl");
        AdInfo.PlayableStyleInfo playableStyleInfo = new AdInfo.PlayableStyleInfo();
        adConversionInfo.playableStyleInfo = playableStyleInfo;
        playableStyleInfo.parseJson(jSONObject.optJSONObject("playableStyleInfo"));
        adConversionInfo.callbackUrl = jSONObject.optString("callbackUrl");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "h5Url", adConversionInfo.h5Url);
        com.kwad.sdk.utils.o.a(jSONObject, "h5Type", adConversionInfo.h5Type);
        com.kwad.sdk.utils.o.a(jSONObject, BaiduAppJsBridgeHandler.INPUT_PARAM_DEEP_LINK_URL, adConversionInfo.deeplinkUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "appDownloadUrl", adConversionInfo.appDownloadUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "marketUrl", adConversionInfo.marketUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "retryH5TimeStep", adConversionInfo.retryH5TimeStep);
        com.kwad.sdk.utils.o.a(jSONObject, "playableUrl", adConversionInfo.playableUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "playableStyleInfo", adConversionInfo.playableStyleInfo);
        com.kwad.sdk.utils.o.a(jSONObject, "callbackUrl", adConversionInfo.callbackUrl);
        return jSONObject;
    }
}
