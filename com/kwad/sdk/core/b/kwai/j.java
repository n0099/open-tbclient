package com.kwad.sdk.core.b.kwai;

import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkItem;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class j implements com.kwad.sdk.core.d<AdInfo.AdConversionInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adConversionInfo.h5Url = jSONObject.optString("h5Url");
        if (jSONObject.opt("h5Url") == JSONObject.NULL) {
            adConversionInfo.h5Url = "";
        }
        adConversionInfo.h5Type = jSONObject.optInt("h5Type");
        adConversionInfo.deeplinkUrl = jSONObject.optString("deeplinkUrl");
        if (jSONObject.opt("deeplinkUrl") == JSONObject.NULL) {
            adConversionInfo.deeplinkUrl = "";
        }
        adConversionInfo.appDownloadUrl = jSONObject.optString("appDownloadUrl");
        if (jSONObject.opt("appDownloadUrl") == JSONObject.NULL) {
            adConversionInfo.appDownloadUrl = "";
        }
        adConversionInfo.marketUrl = jSONObject.optString(DeepLinkItem.DEEPLINK_MARKETURL_KEY);
        if (jSONObject.opt(DeepLinkItem.DEEPLINK_MARKETURL_KEY) == JSONObject.NULL) {
            adConversionInfo.marketUrl = "";
        }
        adConversionInfo.supportThirdDownload = jSONObject.optInt("supportThirdDownload");
        adConversionInfo.retryH5TimeStep = jSONObject.optInt("retryH5TimeStep", new Integer("2000").intValue());
        adConversionInfo.playableUrl = jSONObject.optString("playableUrl");
        if (jSONObject.opt("playableUrl") == JSONObject.NULL) {
            adConversionInfo.playableUrl = "";
        }
        AdInfo.PlayableStyleInfo playableStyleInfo = new AdInfo.PlayableStyleInfo();
        adConversionInfo.playableStyleInfo = playableStyleInfo;
        playableStyleInfo.parseJson(jSONObject.optJSONObject("playableStyleInfo"));
        AdInfo.SmallAppJumpInfo smallAppJumpInfo = new AdInfo.SmallAppJumpInfo();
        adConversionInfo.smallAppJumpInfo = smallAppJumpInfo;
        smallAppJumpInfo.parseJson(jSONObject.optJSONObject("smallAppJumpInfo"));
        adConversionInfo.callbackUrl = jSONObject.optString("callbackUrl");
        if (jSONObject.opt("callbackUrl") == JSONObject.NULL) {
            adConversionInfo.callbackUrl = "";
        }
        adConversionInfo.callbackUrlInfo = jSONObject.optString("callbackUrlInfo");
        if (jSONObject.opt("callbackUrlInfo") == JSONObject.NULL) {
            adConversionInfo.callbackUrlInfo = "";
        }
        adConversionInfo.blockCallbackIfSpam = jSONObject.optBoolean("blockCallbackIfSpam");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = adConversionInfo.h5Url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "h5Url", adConversionInfo.h5Url);
        }
        int i = adConversionInfo.h5Type;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "h5Type", i);
        }
        String str2 = adConversionInfo.deeplinkUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "deeplinkUrl", adConversionInfo.deeplinkUrl);
        }
        String str3 = adConversionInfo.appDownloadUrl;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "appDownloadUrl", adConversionInfo.appDownloadUrl);
        }
        String str4 = adConversionInfo.marketUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, DeepLinkItem.DEEPLINK_MARKETURL_KEY, adConversionInfo.marketUrl);
        }
        int i2 = adConversionInfo.supportThirdDownload;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "supportThirdDownload", i2);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "retryH5TimeStep", adConversionInfo.retryH5TimeStep);
        String str5 = adConversionInfo.playableUrl;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "playableUrl", adConversionInfo.playableUrl);
        }
        com.kwad.sdk.utils.r.a(jSONObject, "playableStyleInfo", adConversionInfo.playableStyleInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "smallAppJumpInfo", adConversionInfo.smallAppJumpInfo);
        String str6 = adConversionInfo.callbackUrl;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "callbackUrl", adConversionInfo.callbackUrl);
        }
        String str7 = adConversionInfo.callbackUrlInfo;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "callbackUrlInfo", adConversionInfo.callbackUrlInfo);
        }
        boolean z = adConversionInfo.blockCallbackIfSpam;
        if (z) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "blockCallbackIfSpam", z);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        a2(adConversionInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        return b2(adConversionInfo, jSONObject);
    }
}
