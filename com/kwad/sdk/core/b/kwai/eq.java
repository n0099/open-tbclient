package com.kwad.sdk.core.b.kwai;

import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.kwad.components.ad.reward.monitor.RewardWebViewInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class eq implements com.kwad.sdk.core.d {
    public static void a(RewardWebViewInfo rewardWebViewInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardWebViewInfo.event = jSONObject.optString("event");
        if (jSONObject.opt("event") == JSONObject.NULL) {
            rewardWebViewInfo.event = "";
        }
        rewardWebViewInfo.status = jSONObject.optInt("status");
        rewardWebViewInfo.url = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            rewardWebViewInfo.url = "";
        }
        rewardWebViewInfo.source = jSONObject.optString("source");
        if (jSONObject.opt("source") == JSONObject.NULL) {
            rewardWebViewInfo.source = "";
        }
        rewardWebViewInfo.sceneId = jSONObject.optString(MemberPayActivityConfig.SCENE_ID);
        if (jSONObject.opt(MemberPayActivityConfig.SCENE_ID) == JSONObject.NULL) {
            rewardWebViewInfo.sceneId = "";
        }
        rewardWebViewInfo.pageType = jSONObject.optString("page_type");
        if (jSONObject.opt("page_type") == JSONObject.NULL) {
            rewardWebViewInfo.pageType = "";
        }
        rewardWebViewInfo.durationMs = jSONObject.optLong("duration_ms");
        rewardWebViewInfo.ratioCount = jSONObject.optDouble("ratio_count");
    }

    public static JSONObject b(RewardWebViewInfo rewardWebViewInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = rewardWebViewInfo.event;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "event", rewardWebViewInfo.event);
        }
        int i = rewardWebViewInfo.status;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "status", i);
        }
        String str2 = rewardWebViewInfo.url;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "url", rewardWebViewInfo.url);
        }
        String str3 = rewardWebViewInfo.source;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "source", rewardWebViewInfo.source);
        }
        String str4 = rewardWebViewInfo.sceneId;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, MemberPayActivityConfig.SCENE_ID, rewardWebViewInfo.sceneId);
        }
        String str5 = rewardWebViewInfo.pageType;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "page_type", rewardWebViewInfo.pageType);
        }
        long j = rewardWebViewInfo.durationMs;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "duration_ms", j);
        }
        double d = rewardWebViewInfo.ratioCount;
        if (d != 0.0d) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "ratio_count", d);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((RewardWebViewInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((RewardWebViewInfo) bVar, jSONObject);
    }
}
