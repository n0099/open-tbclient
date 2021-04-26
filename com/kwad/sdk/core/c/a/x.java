package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class x implements com.kwad.sdk.core.c<AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        detailTopToolBarInfo.callButtonShowTime = jSONObject.optLong("callButtonShowTime");
        detailTopToolBarInfo.callButtonDescription = jSONObject.optString("callButtonDescription");
        detailTopToolBarInfo.rewardIconUrl = jSONObject.optString("rewardIconUrl");
        detailTopToolBarInfo.rewardCallDescription = jSONObject.optString("rewardCallDescription");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "callButtonShowTime", detailTopToolBarInfo.callButtonShowTime);
        com.kwad.sdk.utils.o.a(jSONObject, "callButtonDescription", detailTopToolBarInfo.callButtonDescription);
        com.kwad.sdk.utils.o.a(jSONObject, "rewardIconUrl", detailTopToolBarInfo.rewardIconUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "rewardCallDescription", detailTopToolBarInfo.rewardCallDescription);
        return jSONObject;
    }
}
