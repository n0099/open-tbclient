package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class q implements com.kwad.sdk.core.d<AdInfo.AdInsertScreenInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adInsertScreenInfo.cycleAggregateSwitch = jSONObject.optBoolean("cycleAggregateSwitch");
        adInsertScreenInfo.cycleAggregateDailyShowCount = jSONObject.optInt("cycleAggregateDailyShowCount", new Integer("10").intValue());
        adInsertScreenInfo.cycleAggregateStyle = jSONObject.optInt("cycleAggregateStyle");
        adInsertScreenInfo.cycleAggregateInterval = jSONObject.optInt("cycleAggregateInterval", new Integer("10").intValue());
        adInsertScreenInfo.autoCloseTime = jSONObject.optInt("autoCloseTime");
        adInsertScreenInfo.retainWindowStyle = jSONObject.optInt("retainWindowStyle");
        adInsertScreenInfo.retainWindowText = jSONObject.optString("retainWindowText");
        if (jSONObject.opt("retainWindowText") == JSONObject.NULL) {
            adInsertScreenInfo.retainWindowText = "";
        }
        adInsertScreenInfo.retainWindowBasedAdShowCount = jSONObject.optInt("retainWindowBasedAdShowCount");
        adInsertScreenInfo.retainWindowDailyShowCount = jSONObject.optInt("retainWindowDailyShowCount");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "cycleAggregateSwitch", adInsertScreenInfo.cycleAggregateSwitch);
        com.kwad.sdk.utils.r.a(jSONObject, "cycleAggregateDailyShowCount", adInsertScreenInfo.cycleAggregateDailyShowCount);
        com.kwad.sdk.utils.r.a(jSONObject, "cycleAggregateStyle", adInsertScreenInfo.cycleAggregateStyle);
        com.kwad.sdk.utils.r.a(jSONObject, "cycleAggregateInterval", adInsertScreenInfo.cycleAggregateInterval);
        com.kwad.sdk.utils.r.a(jSONObject, "autoCloseTime", adInsertScreenInfo.autoCloseTime);
        com.kwad.sdk.utils.r.a(jSONObject, "retainWindowStyle", adInsertScreenInfo.retainWindowStyle);
        com.kwad.sdk.utils.r.a(jSONObject, "retainWindowText", adInsertScreenInfo.retainWindowText);
        com.kwad.sdk.utils.r.a(jSONObject, "retainWindowBasedAdShowCount", adInsertScreenInfo.retainWindowBasedAdShowCount);
        com.kwad.sdk.utils.r.a(jSONObject, "retainWindowDailyShowCount", adInsertScreenInfo.retainWindowDailyShowCount);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        a2(adInsertScreenInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        return b2(adInsertScreenInfo, jSONObject);
    }
}
