package com.kwad.sdk.core.b.kwai;

import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkItem;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
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
        com.kwad.sdk.utils.r.a(jSONObject, "h5Url", adConversionInfo.h5Url);
        com.kwad.sdk.utils.r.a(jSONObject, "h5Type", adConversionInfo.h5Type);
        com.kwad.sdk.utils.r.a(jSONObject, "deeplinkUrl", adConversionInfo.deeplinkUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "appDownloadUrl", adConversionInfo.appDownloadUrl);
        com.kwad.sdk.utils.r.a(jSONObject, DeepLinkItem.DEEPLINK_MARKETURL_KEY, adConversionInfo.marketUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "supportThirdDownload", adConversionInfo.supportThirdDownload);
        com.kwad.sdk.utils.r.a(jSONObject, "retryH5TimeStep", adConversionInfo.retryH5TimeStep);
        com.kwad.sdk.utils.r.a(jSONObject, "playableUrl", adConversionInfo.playableUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "playableStyleInfo", adConversionInfo.playableStyleInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "smallAppJumpInfo", adConversionInfo.smallAppJumpInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "callbackUrl", adConversionInfo.callbackUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "callbackUrlInfo", adConversionInfo.callbackUrlInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "blockCallbackIfSpam", adConversionInfo.blockCallbackIfSpam);
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
