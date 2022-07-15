package com.kwad.sdk.core.b.kwai;

import com.baidu.webkit.sdk.LoadErrorCode;
import com.kwad.sdk.commercial.model.SDKInitMsg;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class el implements com.kwad.sdk.core.d<SDKInitMsg> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        sDKInitMsg.launchIntervalTime = jSONObject.optLong("init_launch_interval_time");
        sDKInitMsg.totalDurationTime = jSONObject.optLong("init_total_duration_time");
        sDKInitMsg.initStatus = jSONObject.optInt("init_status", new Integer("0").intValue());
        sDKInitMsg.errorReason = jSONObject.optString(LoadErrorCode.Statistics.KEY_ERROR_REASON);
        if (jSONObject.opt(LoadErrorCode.Statistics.KEY_ERROR_REASON) == JSONObject.NULL) {
            sDKInitMsg.errorReason = "";
        }
        sDKInitMsg.initCount = jSONObject.optInt("init_count");
        sDKInitMsg.initProcess = jSONObject.optInt("init_process");
        sDKInitMsg.initThread = jSONObject.optInt("init_thread");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "init_launch_interval_time", sDKInitMsg.launchIntervalTime);
        com.kwad.sdk.utils.r.a(jSONObject, "init_total_duration_time", sDKInitMsg.totalDurationTime);
        com.kwad.sdk.utils.r.a(jSONObject, "init_status", sDKInitMsg.initStatus);
        com.kwad.sdk.utils.r.a(jSONObject, LoadErrorCode.Statistics.KEY_ERROR_REASON, sDKInitMsg.errorReason);
        com.kwad.sdk.utils.r.a(jSONObject, "init_count", sDKInitMsg.initCount);
        com.kwad.sdk.utils.r.a(jSONObject, "init_process", sDKInitMsg.initProcess);
        com.kwad.sdk.utils.r.a(jSONObject, "init_thread", sDKInitMsg.initThread);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
        a2(sDKInitMsg, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
        return b2(sDKInitMsg, jSONObject);
    }
}
