package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.feed.monitor.FeedWebViewInfo;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class dv implements com.kwad.sdk.core.d<FeedWebViewInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(FeedWebViewInfo feedWebViewInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedWebViewInfo.event = jSONObject.optString("event");
        if (JSONObject.NULL.toString().equals(feedWebViewInfo.event)) {
            feedWebViewInfo.event = "";
        }
        feedWebViewInfo.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(feedWebViewInfo.url)) {
            feedWebViewInfo.url = "";
        }
        feedWebViewInfo.sceneId = jSONObject.optString("scene_id");
        if (JSONObject.NULL.toString().equals(feedWebViewInfo.sceneId)) {
            feedWebViewInfo.sceneId = "";
        }
        feedWebViewInfo.durationMs = jSONObject.optLong("duration_ms");
        feedWebViewInfo.timeType = jSONObject.optInt("time_type");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(FeedWebViewInfo feedWebViewInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = feedWebViewInfo.event;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "event", feedWebViewInfo.event);
        }
        String str2 = feedWebViewInfo.url;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", feedWebViewInfo.url);
        }
        String str3 = feedWebViewInfo.sceneId;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "scene_id", feedWebViewInfo.sceneId);
        }
        long j = feedWebViewInfo.durationMs;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "duration_ms", j);
        }
        int i = feedWebViewInfo.timeType;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "time_type", i);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(FeedWebViewInfo feedWebViewInfo, JSONObject jSONObject) {
        a2(feedWebViewInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(FeedWebViewInfo feedWebViewInfo, JSONObject jSONObject) {
        return b2(feedWebViewInfo, jSONObject);
    }
}
