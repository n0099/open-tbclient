package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class x implements com.kwad.sdk.core.d {
    public static void a(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adRewardInfo.skipShowTime = jSONObject.optInt("skipShowTime", new Integer("30").intValue());
        adRewardInfo.rewardTime = jSONObject.optInt("rewardTime", new Integer("30").intValue());
        adRewardInfo.showLandingPage = jSONObject.optInt("showLandingPage");
        adRewardInfo.rewardVideoEndCardSwitch = jSONObject.optBoolean("rewardVideoEndCardSwitch");
        adRewardInfo.recommendAggregateSwitch = jSONObject.optBoolean("recommendAggregateSwitch");
    }

    public static JSONObject b(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "skipShowTime", adRewardInfo.skipShowTime);
        com.kwad.sdk.utils.r.putValue(jSONObject, "rewardTime", adRewardInfo.rewardTime);
        int i = adRewardInfo.showLandingPage;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "showLandingPage", i);
        }
        boolean z = adRewardInfo.rewardVideoEndCardSwitch;
        if (z) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "rewardVideoEndCardSwitch", z);
        }
        boolean z2 = adRewardInfo.recommendAggregateSwitch;
        if (z2) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "recommendAggregateSwitch", z2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdRewardInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdRewardInfo) bVar, jSONObject);
    }
}
