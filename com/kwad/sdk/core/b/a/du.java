package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.FeedSlideConf;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class du implements com.kwad.sdk.core.d<FeedSlideConf> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(FeedSlideConf feedSlideConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedSlideConf.maxRange = jSONObject.optInt("maxRange");
        feedSlideConf.minRange = jSONObject.optInt("minRange");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(FeedSlideConf feedSlideConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = feedSlideConf.maxRange;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "maxRange", i);
        }
        int i2 = feedSlideConf.minRange;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "minRange", i2);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(FeedSlideConf feedSlideConf, JSONObject jSONObject) {
        a2(feedSlideConf, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(FeedSlideConf feedSlideConf, JSONObject jSONObject) {
        return b2(feedSlideConf, jSONObject);
    }
}
