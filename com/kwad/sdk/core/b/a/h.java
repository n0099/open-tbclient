package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class h implements com.kwad.sdk.core.d<AdInfo.AdAggregateInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdInfo.AdAggregateInfo adAggregateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adAggregateInfo.aggregateAdType = jSONObject.optInt("aggregateAdType");
        adAggregateInfo.upperTab = jSONObject.optString("upperTab");
        if (JSONObject.NULL.toString().equals(adAggregateInfo.upperTab)) {
            adAggregateInfo.upperTab = "";
        }
        adAggregateInfo.hotTagUrl = jSONObject.optString("hotTagUrl");
        if (JSONObject.NULL.toString().equals(adAggregateInfo.hotTagUrl)) {
            adAggregateInfo.hotTagUrl = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdInfo.AdAggregateInfo adAggregateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = adAggregateInfo.aggregateAdType;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "aggregateAdType", i);
        }
        String str = adAggregateInfo.upperTab;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "upperTab", adAggregateInfo.upperTab);
        }
        String str2 = adAggregateInfo.hotTagUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "hotTagUrl", adAggregateInfo.hotTagUrl);
        }
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
