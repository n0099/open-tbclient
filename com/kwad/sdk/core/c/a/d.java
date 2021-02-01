package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements com.kwad.sdk.core.c<AdInfo.AdConversionInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(AdInfo.AdConversionInfo adConversionInfo) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "h5Url", adConversionInfo.h5Url);
        com.kwad.sdk.utils.o.a(jSONObject, "h5Type", adConversionInfo.h5Type);
        com.kwad.sdk.utils.o.a(jSONObject, "deeplinkUrl", adConversionInfo.deeplinkUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "appDownloadUrl", adConversionInfo.appDownloadUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "marketUrl", adConversionInfo.marketUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "retryH5TimeStep", adConversionInfo.retryH5TimeStep);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adConversionInfo.h5Url = jSONObject.optString("h5Url");
        adConversionInfo.h5Type = jSONObject.optInt("h5Type");
        adConversionInfo.deeplinkUrl = jSONObject.optString("deeplinkUrl");
        adConversionInfo.appDownloadUrl = jSONObject.optString("appDownloadUrl");
        adConversionInfo.marketUrl = jSONObject.optString("marketUrl");
        adConversionInfo.retryH5TimeStep = jSONObject.optInt("retryH5TimeStep", new Integer("2000").intValue());
    }
}
