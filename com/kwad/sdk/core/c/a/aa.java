package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class aa implements com.kwad.sdk.core.c<AdInfo.DownloadSafeInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        downloadSafeInfo.permissionInfo = jSONObject.optString("permissionInfo");
        downloadSafeInfo.appPrivacyUrl = jSONObject.optString("appPrivacyUrl");
        downloadSafeInfo.windowPopType = jSONObject.optInt("windowPopType", new Integer("0").intValue());
        downloadSafeInfo.downloadPauseEnable = jSONObject.optBoolean("downloadPauseEnable", new Boolean("false").booleanValue());
        downloadSafeInfo.windowPopUrl = jSONObject.optString("windowPopUrl");
        downloadSafeInfo.webPageTipbarSwitch = jSONObject.optBoolean("webPageTipbarSwitch", new Boolean("false").booleanValue());
        downloadSafeInfo.webPageTipbarText = jSONObject.optString("webPageTipbarText");
        downloadSafeInfo.autoDownloadUrl = jSONObject.optString("autoDownloadUrl");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "permissionInfo", downloadSafeInfo.permissionInfo);
        com.kwad.sdk.utils.o.a(jSONObject, "appPrivacyUrl", downloadSafeInfo.appPrivacyUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "windowPopType", downloadSafeInfo.windowPopType);
        com.kwad.sdk.utils.o.a(jSONObject, "downloadPauseEnable", downloadSafeInfo.downloadPauseEnable);
        com.kwad.sdk.utils.o.a(jSONObject, "windowPopUrl", downloadSafeInfo.windowPopUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "webPageTipbarSwitch", downloadSafeInfo.webPageTipbarSwitch);
        com.kwad.sdk.utils.o.a(jSONObject, "webPageTipbarText", downloadSafeInfo.webPageTipbarText);
        com.kwad.sdk.utils.o.a(jSONObject, "autoDownloadUrl", downloadSafeInfo.autoDownloadUrl);
        return jSONObject;
    }
}
