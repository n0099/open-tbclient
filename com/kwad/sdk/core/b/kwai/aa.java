package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class aa implements com.kwad.sdk.core.d<AdStyleInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdStyleInfo adStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdStyleInfo.PlayDetailInfo playDetailInfo = new AdStyleInfo.PlayDetailInfo();
        adStyleInfo.playDetailInfo = playDetailInfo;
        playDetailInfo.parseJson(jSONObject.optJSONObject("playDetailInfo"));
        AdStyleInfo.PlayEndInfo playEndInfo = new AdStyleInfo.PlayEndInfo();
        adStyleInfo.playEndInfo = playEndInfo;
        playEndInfo.parseJson(jSONObject.optJSONObject("playEndInfo"));
        AdStyleInfo.FeedAdInfo feedAdInfo = new AdStyleInfo.FeedAdInfo();
        adStyleInfo.feedAdInfo = feedAdInfo;
        feedAdInfo.parseJson(jSONObject.optJSONObject("feedAdInfo"));
        AdStyleInfo.AdBrowseInfo adBrowseInfo = new AdStyleInfo.AdBrowseInfo();
        adStyleInfo.adBrowseInfo = adBrowseInfo;
        adBrowseInfo.parseJson(jSONObject.optJSONObject("adBrowseInfo"));
        AdStyleInfo.ExtraDisplayInfo extraDisplayInfo = new AdStyleInfo.ExtraDisplayInfo();
        adStyleInfo.extraDisplayInfo = extraDisplayInfo;
        extraDisplayInfo.parseJson(jSONObject.optJSONObject("extraDisplayInfo"));
        adStyleInfo.playableExtraData = jSONObject.optString("playableExtraData");
        if (jSONObject.opt("playableExtraData") == JSONObject.NULL) {
            adStyleInfo.playableExtraData = "";
        }
        adStyleInfo.slideClick = jSONObject.optBoolean("slideClick");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdStyleInfo adStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "playDetailInfo", adStyleInfo.playDetailInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "playEndInfo", adStyleInfo.playEndInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "feedAdInfo", adStyleInfo.feedAdInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "adBrowseInfo", adStyleInfo.adBrowseInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "extraDisplayInfo", adStyleInfo.extraDisplayInfo);
        String str = adStyleInfo.playableExtraData;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "playableExtraData", adStyleInfo.playableExtraData);
        }
        boolean z = adStyleInfo.slideClick;
        if (z) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "slideClick", z);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo adStyleInfo, JSONObject jSONObject) {
        a2(adStyleInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo adStyleInfo, JSONObject jSONObject) {
        return b2(adStyleInfo, jSONObject);
    }
}
