package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class cr implements com.kwad.sdk.core.d<AdMatrixInfo.CycleAggregateInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdMatrixInfo.CycleAggregateInfo cycleAggregateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cycleAggregateInfo.cutIconUrl = jSONObject.optString("cutIconUrl");
        if (JSONObject.NULL.toString().equals(cycleAggregateInfo.cutIconUrl)) {
            cycleAggregateInfo.cutIconUrl = "";
        }
        cycleAggregateInfo.refreshIconUrl = jSONObject.optString("refreshIconUrl");
        if (JSONObject.NULL.toString().equals(cycleAggregateInfo.refreshIconUrl)) {
            cycleAggregateInfo.refreshIconUrl = "";
        }
        cycleAggregateInfo.convertIconUrl = jSONObject.optString("convertIconUrl");
        if (JSONObject.NULL.toString().equals(cycleAggregateInfo.convertIconUrl)) {
            cycleAggregateInfo.convertIconUrl = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdMatrixInfo.CycleAggregateInfo cycleAggregateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = cycleAggregateInfo.cutIconUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cutIconUrl", cycleAggregateInfo.cutIconUrl);
        }
        String str2 = cycleAggregateInfo.refreshIconUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "refreshIconUrl", cycleAggregateInfo.refreshIconUrl);
        }
        String str3 = cycleAggregateInfo.convertIconUrl;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "convertIconUrl", cycleAggregateInfo.convertIconUrl);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.CycleAggregateInfo cycleAggregateInfo, JSONObject jSONObject) {
        a2(cycleAggregateInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.CycleAggregateInfo cycleAggregateInfo, JSONObject jSONObject) {
        return b2(cycleAggregateInfo, jSONObject);
    }
}
