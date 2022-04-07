package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AggregatePageEntranceInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class y implements com.kwad.sdk.core.d<AggregatePageEntranceInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(AggregatePageEntranceInfo aggregatePageEntranceInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aggregatePageEntranceInfo.aggregatePageEntranceButton = jSONObject.optString("aggregatePageEntranceButton", new String("更多推荐"));
        aggregatePageEntranceInfo.aggregatePageDesc = jSONObject.optString("aggregatePageDesc", new String("点击查看更多相关推荐"));
        aggregatePageEntranceInfo.aggregatePageEntranceDynamicNs = jSONObject.optInt("aggregatePageEntranceDynamicNs", new Integer("3").intValue());
        aggregatePageEntranceInfo.aggregatePageH5Url = jSONObject.optString("aggregatePageH5Url");
        if (jSONObject.opt("aggregatePageH5Url") == JSONObject.NULL) {
            aggregatePageEntranceInfo.aggregatePageH5Url = "";
        }
        aggregatePageEntranceInfo.aggregatePageBottomImageUrl = jSONObject.optString("aggregatePageBottomImageUrl");
        if (jSONObject.opt("aggregatePageBottomImageUrl") == JSONObject.NULL) {
            aggregatePageEntranceInfo.aggregatePageBottomImageUrl = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AggregatePageEntranceInfo aggregatePageEntranceInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "aggregatePageEntranceButton", aggregatePageEntranceInfo.aggregatePageEntranceButton);
        com.kwad.sdk.utils.t.a(jSONObject, "aggregatePageDesc", aggregatePageEntranceInfo.aggregatePageDesc);
        com.kwad.sdk.utils.t.a(jSONObject, "aggregatePageEntranceDynamicNs", aggregatePageEntranceInfo.aggregatePageEntranceDynamicNs);
        com.kwad.sdk.utils.t.a(jSONObject, "aggregatePageH5Url", aggregatePageEntranceInfo.aggregatePageH5Url);
        com.kwad.sdk.utils.t.a(jSONObject, "aggregatePageBottomImageUrl", aggregatePageEntranceInfo.aggregatePageBottomImageUrl);
        return jSONObject;
    }
}
