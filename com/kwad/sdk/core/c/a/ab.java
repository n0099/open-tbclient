package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ab implements com.kwad.sdk.core.c<AdStyleInfo.PlayEndInfo.EndTopToolBarInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(AdStyleInfo.PlayEndInfo.EndTopToolBarInfo endTopToolBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        endTopToolBarInfo.callButtonDescription = jSONObject.optString("callButtonDescription");
        endTopToolBarInfo.rewardIconUrl = jSONObject.optString("rewardIconUrl");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(AdStyleInfo.PlayEndInfo.EndTopToolBarInfo endTopToolBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "callButtonDescription", endTopToolBarInfo.callButtonDescription);
        com.kwad.sdk.utils.o.a(jSONObject, "rewardIconUrl", endTopToolBarInfo.rewardIconUrl);
        return jSONObject;
    }
}
