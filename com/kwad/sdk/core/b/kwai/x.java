package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class x implements com.kwad.sdk.core.d<AdInfo.AdRewardInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adRewardInfo.skipShowTime = jSONObject.optInt("skipShowTime", new Integer("30").intValue());
        adRewardInfo.rewardTime = jSONObject.optInt("rewardTime", new Integer("30").intValue());
        adRewardInfo.showLandingPage = jSONObject.optInt("showLandingPage");
        adRewardInfo.rewardVideoEndCardSwitch = jSONObject.optBoolean("rewardVideoEndCardSwitch");
        adRewardInfo.recommendAggregateSwitch = jSONObject.optBoolean("recommendAggregateSwitch");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "skipShowTime", adRewardInfo.skipShowTime);
        com.kwad.sdk.utils.r.a(jSONObject, "rewardTime", adRewardInfo.rewardTime);
        com.kwad.sdk.utils.r.a(jSONObject, "showLandingPage", adRewardInfo.showLandingPage);
        com.kwad.sdk.utils.r.a(jSONObject, "rewardVideoEndCardSwitch", adRewardInfo.rewardVideoEndCardSwitch);
        com.kwad.sdk.utils.r.a(jSONObject, "recommendAggregateSwitch", adRewardInfo.recommendAggregateSwitch);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        a2(adRewardInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        return b2(adRewardInfo, jSONObject);
    }
}
