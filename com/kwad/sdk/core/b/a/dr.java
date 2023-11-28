package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.feed.monitor.FeedErrorInfo;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class dr implements com.kwad.sdk.core.d<FeedErrorInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(FeedErrorInfo feedErrorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedErrorInfo.materialType = jSONObject.optLong("material_type");
        feedErrorInfo.width = jSONObject.optLong("width");
        feedErrorInfo.feedType = jSONObject.optLong("feed_type");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(FeedErrorInfo feedErrorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = feedErrorInfo.materialType;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "material_type", j);
        }
        long j2 = feedErrorInfo.width;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "width", j2);
        }
        long j3 = feedErrorInfo.feedType;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "feed_type", j3);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(FeedErrorInfo feedErrorInfo, JSONObject jSONObject) {
        a2(feedErrorInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(FeedErrorInfo feedErrorInfo, JSONObject jSONObject) {
        return b2(feedErrorInfo, jSONObject);
    }
}
