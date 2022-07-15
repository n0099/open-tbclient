package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class bp implements com.kwad.sdk.core.d<AdInfo.DownloadSafeInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
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

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "permissionInfo", downloadSafeInfo.permissionInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "appPrivacyUrl", downloadSafeInfo.appPrivacyUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "appPermissionInfoUrl", downloadSafeInfo.appPermissionInfoUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "secWindowPopNoWifiSwitch", downloadSafeInfo.secWindowPopNoWifiSwitch);
        com.kwad.sdk.utils.r.a(jSONObject, "secWindowPopSwitch", downloadSafeInfo.secWindowPopSwitch);
        com.kwad.sdk.utils.r.a(jSONObject, "downloadPauseEnable", downloadSafeInfo.downloadPauseEnable);
        com.kwad.sdk.utils.r.a(jSONObject, "windowPopUrl", downloadSafeInfo.windowPopUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "webPageTipbarSwitch", downloadSafeInfo.webPageTipbarSwitch);
        com.kwad.sdk.utils.r.a(jSONObject, "webPageTipbarText", downloadSafeInfo.webPageTipbarText);
        com.kwad.sdk.utils.r.a(jSONObject, "autoDownloadUrl", downloadSafeInfo.autoDownloadUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "complianceInfo", downloadSafeInfo.complianceInfo);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        a2(downloadSafeInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        return b2(downloadSafeInfo, jSONObject);
    }
}
