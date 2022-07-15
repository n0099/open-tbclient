package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class bu implements com.kwad.sdk.core.d<AdStyleInfo.PlayEndInfo.EndTopToolBarInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdStyleInfo.PlayEndInfo.EndTopToolBarInfo endTopToolBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        endTopToolBarInfo.callButtonDescription = jSONObject.optString("callButtonDescription");
        if (jSONObject.opt("callButtonDescription") == JSONObject.NULL) {
            endTopToolBarInfo.callButtonDescription = "";
        }
        endTopToolBarInfo.rewardIconUrl = jSONObject.optString("rewardIconUrl");
        if (jSONObject.opt("rewardIconUrl") == JSONObject.NULL) {
            endTopToolBarInfo.rewardIconUrl = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdStyleInfo.PlayEndInfo.EndTopToolBarInfo endTopToolBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "callButtonDescription", endTopToolBarInfo.callButtonDescription);
        com.kwad.sdk.utils.r.a(jSONObject, "rewardIconUrl", endTopToolBarInfo.rewardIconUrl);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayEndInfo.EndTopToolBarInfo endTopToolBarInfo, JSONObject jSONObject) {
        a2(endTopToolBarInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayEndInfo.EndTopToolBarInfo endTopToolBarInfo, JSONObject jSONObject) {
        return b2(endTopToolBarInfo, jSONObject);
    }
}
