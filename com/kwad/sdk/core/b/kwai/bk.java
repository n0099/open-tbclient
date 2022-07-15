package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class bk implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        detailTopToolBarInfo.callButtonShowTime = jSONObject.optLong("callButtonShowTime");
        detailTopToolBarInfo.callButtonDescription = jSONObject.optString("callButtonDescription");
        if (jSONObject.opt("callButtonDescription") == JSONObject.NULL) {
            detailTopToolBarInfo.callButtonDescription = "";
        }
        detailTopToolBarInfo.rewardIconUrl = jSONObject.optString("rewardIconUrl");
        if (jSONObject.opt("rewardIconUrl") == JSONObject.NULL) {
            detailTopToolBarInfo.rewardIconUrl = "";
        }
        detailTopToolBarInfo.rewardCallDescription = jSONObject.optString("rewardCallDescription");
        if (jSONObject.opt("rewardCallDescription") == JSONObject.NULL) {
            detailTopToolBarInfo.rewardCallDescription = "";
        }
        detailTopToolBarInfo.style = jSONObject.optInt("style");
        detailTopToolBarInfo.maxTimeOut = jSONObject.optLong("maxTimeOut");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "callButtonShowTime", detailTopToolBarInfo.callButtonShowTime);
        com.kwad.sdk.utils.r.a(jSONObject, "callButtonDescription", detailTopToolBarInfo.callButtonDescription);
        com.kwad.sdk.utils.r.a(jSONObject, "rewardIconUrl", detailTopToolBarInfo.rewardIconUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "rewardCallDescription", detailTopToolBarInfo.rewardCallDescription);
        com.kwad.sdk.utils.r.a(jSONObject, "style", detailTopToolBarInfo.style);
        com.kwad.sdk.utils.r.a(jSONObject, "maxTimeOut", detailTopToolBarInfo.maxTimeOut);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo, JSONObject jSONObject) {
        a2(detailTopToolBarInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo, JSONObject jSONObject) {
        return b2(detailTopToolBarInfo, jSONObject);
    }
}
