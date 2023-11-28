package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.reward.check.RewardCheckMonitorInfo;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class hy implements com.kwad.sdk.core.d<RewardCheckMonitorInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardCheckMonitorInfo.checkType = jSONObject.optInt("check_type");
        rewardCheckMonitorInfo.requestStatus = jSONObject.optInt("request_state");
        rewardCheckMonitorInfo.code = jSONObject.optInt("code");
        rewardCheckMonitorInfo.creativeId = jSONObject.optLong("creative_id");
        rewardCheckMonitorInfo.dataLoadInterval = jSONObject.optLong("data_load_interval_duration_ms");
        rewardCheckMonitorInfo.posId = jSONObject.optLong("pos_Id");
        rewardCheckMonitorInfo.enviType = jSONObject.optInt("enviType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = rewardCheckMonitorInfo.checkType;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "check_type", i);
        }
        int i2 = rewardCheckMonitorInfo.requestStatus;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_state", i2);
        }
        int i3 = rewardCheckMonitorInfo.code;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "code", i3);
        }
        long j = rewardCheckMonitorInfo.creativeId;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "creative_id", j);
        }
        long j2 = rewardCheckMonitorInfo.dataLoadInterval;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "data_load_interval_duration_ms", j2);
        }
        long j3 = rewardCheckMonitorInfo.posId;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pos_Id", j3);
        }
        int i4 = rewardCheckMonitorInfo.enviType;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "enviType", i4);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        a2(rewardCheckMonitorInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        return b2(rewardCheckMonitorInfo, jSONObject);
    }
}
