package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j implements com.kwad.sdk.core.c<AdStyleInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(AdStyleInfo adStyleInfo, JSONObject jSONObject) {
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(AdStyleInfo adStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "playDetailInfo", adStyleInfo.playDetailInfo);
        com.kwad.sdk.utils.o.a(jSONObject, "playEndInfo", adStyleInfo.playEndInfo);
        com.kwad.sdk.utils.o.a(jSONObject, "feedAdInfo", adStyleInfo.feedAdInfo);
        return jSONObject;
    }
}
