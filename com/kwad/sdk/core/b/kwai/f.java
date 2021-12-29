package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f implements com.kwad.sdk.core.d<AdInfo.AdAggregateInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(AdInfo.AdAggregateInfo adAggregateInfo, JSONObject jSONObject) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdInfo.AdAggregateInfo adAggregateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "aggregateAdType", adAggregateInfo.aggregateAdType);
        com.kwad.sdk.utils.t.a(jSONObject, "upperTab", adAggregateInfo.upperTab);
        com.kwad.sdk.utils.t.a(jSONObject, "hotTagUrl", adAggregateInfo.hotTagUrl);
        return jSONObject;
    }
}
