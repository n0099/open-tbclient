package com.kwad.sdk.core.b.a;

import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkItem;
import com.baidu.tieba.im.dispatcher.AiBotChatDispatcher;
import com.kwad.sdk.core.response.model.AdInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class l implements com.kwad.sdk.core.d<AdInfo.AdConversionInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adConversionInfo.h5Url = jSONObject.optString(AiBotChatDispatcher.AI_SINGLE_H5_URL);
        if (JSONObject.NULL.toString().equals(adConversionInfo.h5Url)) {
            adConversionInfo.h5Url = "";
        }
        adConversionInfo.h5Type = jSONObject.optInt("h5Type");
        adConversionInfo.deeplinkUrl = jSONObject.optString("deeplinkUrl");
        if (JSONObject.NULL.toString().equals(adConversionInfo.deeplinkUrl)) {
            adConversionInfo.deeplinkUrl = "";
        }
        adConversionInfo.deeplinkConf = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("deeplinkConf");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo = new AdInfo.AdConversionInfo.DeeplinkItemInfo();
                deeplinkItemInfo.parseJson(optJSONArray.optJSONObject(i));
                adConversionInfo.deeplinkConf.add(deeplinkItemInfo);
            }
        }
        adConversionInfo.deeplinkExtra = jSONObject.optString("deeplinkExtra");
        if (JSONObject.NULL.toString().equals(adConversionInfo.deeplinkExtra)) {
            adConversionInfo.deeplinkExtra = "";
        }
        adConversionInfo.appSecondConfirmationSwitch = jSONObject.optBoolean("appSecondConfirmationSwitch");
        adConversionInfo.h5SecondConfirmationSwitch = jSONObject.optBoolean("h5SecondConfirmationSwitch");
        adConversionInfo.appDownloadUrl = jSONObject.optString("appDownloadUrl");
        if (JSONObject.NULL.toString().equals(adConversionInfo.appDownloadUrl)) {
            adConversionInfo.appDownloadUrl = "";
        }
        adConversionInfo.marketUrl = jSONObject.optString(DeepLinkItem.DEEPLINK_MARKETURL_KEY);
        if (JSONObject.NULL.toString().equals(adConversionInfo.marketUrl)) {
            adConversionInfo.marketUrl = "";
        }
        adConversionInfo.supportThirdDownload = jSONObject.optInt("supportThirdDownload");
        adConversionInfo.retryH5TimeStep = jSONObject.optInt("retryH5TimeStep", new Integer("2000").intValue());
        adConversionInfo.playableUrl = jSONObject.optString("playableUrl");
        if (JSONObject.NULL.toString().equals(adConversionInfo.playableUrl)) {
            adConversionInfo.playableUrl = "";
        }
        AdInfo.PlayableStyleInfo playableStyleInfo = new AdInfo.PlayableStyleInfo();
        adConversionInfo.playableStyleInfo = playableStyleInfo;
        playableStyleInfo.parseJson(jSONObject.optJSONObject("playableStyleInfo"));
        AdInfo.SmallAppJumpInfo smallAppJumpInfo = new AdInfo.SmallAppJumpInfo();
        adConversionInfo.smallAppJumpInfo = smallAppJumpInfo;
        smallAppJumpInfo.parseJson(jSONObject.optJSONObject("smallAppJumpInfo"));
        adConversionInfo.webUriSourceType = jSONObject.optInt("webUriSourceType");
        adConversionInfo.callbackUrl = jSONObject.optString("callbackUrl");
        if (JSONObject.NULL.toString().equals(adConversionInfo.callbackUrl)) {
            adConversionInfo.callbackUrl = "";
        }
        adConversionInfo.callbackUrlInfo = jSONObject.optString("callbackUrlInfo");
        if (JSONObject.NULL.toString().equals(adConversionInfo.callbackUrlInfo)) {
            adConversionInfo.callbackUrlInfo = "";
        }
        adConversionInfo.blockCallbackIfSpam = jSONObject.optBoolean("blockCallbackIfSpam");
        adConversionInfo.needDeeplinkReplaceAdapta = jSONObject.optBoolean("needDeeplinkReplaceAdapta");
        adConversionInfo.h5DeeplinkLimitedTimeMs = jSONObject.optInt("h5DeeplinkLimitedTimeMs", new Integer("0").intValue());
        adConversionInfo.playableDeeplinkLimitedTimeMs = jSONObject.optInt("playableDeeplinkLimitedTimeMs", new Integer("0").intValue());
        adConversionInfo.isSupportKeepPlaying = jSONObject.optBoolean("isSupportKeepPlaying");
        adConversionInfo.keepPlayingBackOffTime = jSONObject.optLong("keepPlayingBackOffTime", new Long("3000").longValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = adConversionInfo.h5Url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, AiBotChatDispatcher.AI_SINGLE_H5_URL, adConversionInfo.h5Url);
        }
        int i = adConversionInfo.h5Type;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "h5Type", i);
        }
        String str2 = adConversionInfo.deeplinkUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deeplinkUrl", adConversionInfo.deeplinkUrl);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "deeplinkConf", adConversionInfo.deeplinkConf);
        String str3 = adConversionInfo.deeplinkExtra;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deeplinkExtra", adConversionInfo.deeplinkExtra);
        }
        boolean z = adConversionInfo.appSecondConfirmationSwitch;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appSecondConfirmationSwitch", z);
        }
        boolean z2 = adConversionInfo.h5SecondConfirmationSwitch;
        if (z2) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "h5SecondConfirmationSwitch", z2);
        }
        String str4 = adConversionInfo.appDownloadUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appDownloadUrl", adConversionInfo.appDownloadUrl);
        }
        String str5 = adConversionInfo.marketUrl;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, DeepLinkItem.DEEPLINK_MARKETURL_KEY, adConversionInfo.marketUrl);
        }
        int i2 = adConversionInfo.supportThirdDownload;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "supportThirdDownload", i2);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "retryH5TimeStep", adConversionInfo.retryH5TimeStep);
        String str6 = adConversionInfo.playableUrl;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playableUrl", adConversionInfo.playableUrl);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "playableStyleInfo", adConversionInfo.playableStyleInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "smallAppJumpInfo", adConversionInfo.smallAppJumpInfo);
        int i3 = adConversionInfo.webUriSourceType;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "webUriSourceType", i3);
        }
        String str7 = adConversionInfo.callbackUrl;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "callbackUrl", adConversionInfo.callbackUrl);
        }
        String str8 = adConversionInfo.callbackUrlInfo;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "callbackUrlInfo", adConversionInfo.callbackUrlInfo);
        }
        boolean z3 = adConversionInfo.blockCallbackIfSpam;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "blockCallbackIfSpam", z3);
        }
        boolean z4 = adConversionInfo.needDeeplinkReplaceAdapta;
        if (z4) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "needDeeplinkReplaceAdapta", z4);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "h5DeeplinkLimitedTimeMs", adConversionInfo.h5DeeplinkLimitedTimeMs);
        com.kwad.sdk.utils.t.putValue(jSONObject, "playableDeeplinkLimitedTimeMs", adConversionInfo.playableDeeplinkLimitedTimeMs);
        boolean z5 = adConversionInfo.isSupportKeepPlaying;
        if (z5) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isSupportKeepPlaying", z5);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "keepPlayingBackOffTime", adConversionInfo.keepPlayingBackOffTime);
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
