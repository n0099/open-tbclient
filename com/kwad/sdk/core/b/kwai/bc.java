package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class bc implements com.kwad.sdk.core.d<AdInfo.DownloadSafeInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        downloadSafeInfo.permissionInfo = jSONObject.optString("permissionInfo");
        if (jSONObject.opt("permissionInfo") == JSONObject.NULL) {
            downloadSafeInfo.permissionInfo = "";
        }
        downloadSafeInfo.appPrivacyUrl = jSONObject.optString("appPrivacyUrl");
        if (jSONObject.opt("appPrivacyUrl") == JSONObject.NULL) {
            downloadSafeInfo.appPrivacyUrl = "";
        }
        downloadSafeInfo.appPermissionInfoUrl = jSONObject.optString("appPermissionInfoUrl");
        if (jSONObject.opt("appPermissionInfoUrl") == JSONObject.NULL) {
            downloadSafeInfo.appPermissionInfoUrl = "";
        }
        downloadSafeInfo.secWindowPopNoWifiSwitch = jSONObject.optBoolean("secWindowPopNoWifiSwitch");
        downloadSafeInfo.secWindowPopSwitch = jSONObject.optBoolean("secWindowPopSwitch");
        downloadSafeInfo.downloadPauseEnable = jSONObject.optBoolean("downloadPauseEnable", new Boolean("false").booleanValue());
        downloadSafeInfo.windowPopUrl = jSONObject.optString("windowPopUrl");
        if (jSONObject.opt("windowPopUrl") == JSONObject.NULL) {
            downloadSafeInfo.windowPopUrl = "";
        }
        downloadSafeInfo.webPageTipbarSwitch = jSONObject.optBoolean("webPageTipbarSwitch", new Boolean("false").booleanValue());
        downloadSafeInfo.webPageTipbarText = jSONObject.optString("webPageTipbarText");
        if (jSONObject.opt("webPageTipbarText") == JSONObject.NULL) {
            downloadSafeInfo.webPageTipbarText = "";
        }
        downloadSafeInfo.autoDownloadUrl = jSONObject.optString("autoDownloadUrl");
        if (jSONObject.opt("autoDownloadUrl") == JSONObject.NULL) {
            downloadSafeInfo.autoDownloadUrl = "";
        }
        AdInfo.ComplianceInfo complianceInfo = new AdInfo.ComplianceInfo();
        downloadSafeInfo.complianceInfo = complianceInfo;
        complianceInfo.parseJson(jSONObject.optJSONObject("complianceInfo"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "permissionInfo", downloadSafeInfo.permissionInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "appPrivacyUrl", downloadSafeInfo.appPrivacyUrl);
        com.kwad.sdk.utils.t.a(jSONObject, "appPermissionInfoUrl", downloadSafeInfo.appPermissionInfoUrl);
        com.kwad.sdk.utils.t.a(jSONObject, "secWindowPopNoWifiSwitch", downloadSafeInfo.secWindowPopNoWifiSwitch);
        com.kwad.sdk.utils.t.a(jSONObject, "secWindowPopSwitch", downloadSafeInfo.secWindowPopSwitch);
        com.kwad.sdk.utils.t.a(jSONObject, "downloadPauseEnable", downloadSafeInfo.downloadPauseEnable);
        com.kwad.sdk.utils.t.a(jSONObject, "windowPopUrl", downloadSafeInfo.windowPopUrl);
        com.kwad.sdk.utils.t.a(jSONObject, "webPageTipbarSwitch", downloadSafeInfo.webPageTipbarSwitch);
        com.kwad.sdk.utils.t.a(jSONObject, "webPageTipbarText", downloadSafeInfo.webPageTipbarText);
        com.kwad.sdk.utils.t.a(jSONObject, "autoDownloadUrl", downloadSafeInfo.autoDownloadUrl);
        com.kwad.sdk.utils.t.a(jSONObject, "complianceInfo", downloadSafeInfo.complianceInfo);
        return jSONObject;
    }
}
