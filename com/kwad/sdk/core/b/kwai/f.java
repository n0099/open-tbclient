package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class f implements com.kwad.sdk.core.d {
    public static void a(AdInfo.AdAggregateInfo adAggregateInfo, JSONObject jSONObject) {
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

    public static JSONObject b(AdInfo.AdAggregateInfo adAggregateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = adAggregateInfo.aggregateAdType;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "aggregateAdType", i);
        }
        String str = adAggregateInfo.upperTab;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "upperTab", adAggregateInfo.upperTab);
        }
        String str2 = adAggregateInfo.hotTagUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "hotTagUrl", adAggregateInfo.hotTagUrl);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdAggregateInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdAggregateInfo) bVar, jSONObject);
    }
}
