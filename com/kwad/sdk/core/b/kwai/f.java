package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class f implements com.kwad.sdk.core.d<AdInfo.AdAggregateInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdInfo.AdAggregateInfo adAggregateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adAggregateInfo.aggregateAdType = jSONObject.optInt("aggregateAdType");
        adAggregateInfo.upperTab = jSONObject.optString("upperTab");
        if (jSONObject.opt("upperTab") == JSONObject.NULL) {
            adAggregateInfo.upperTab = "";
        }
        adAggregateInfo.hotTagUrl = jSONObject.optString("hotTagUrl");
        if (jSONObject.opt("hotTagUrl") == JSONObject.NULL) {
            adAggregateInfo.hotTagUrl = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdInfo.AdAggregateInfo adAggregateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "aggregateAdType", adAggregateInfo.aggregateAdType);
        com.kwad.sdk.utils.r.a(jSONObject, "upperTab", adAggregateInfo.upperTab);
        com.kwad.sdk.utils.r.a(jSONObject, "hotTagUrl", adAggregateInfo.hotTagUrl);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdAggregateInfo adAggregateInfo, JSONObject jSONObject) {
        a2(adAggregateInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdAggregateInfo adAggregateInfo, JSONObject jSONObject) {
        return b2(adAggregateInfo, jSONObject);
    }
}
