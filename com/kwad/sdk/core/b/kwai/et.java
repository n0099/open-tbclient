package com.kwad.sdk.core.b.kwai;

import com.baidu.webkit.sdk.LoadErrorCode;
import com.kwad.sdk.commercial.model.SDKInitMsg;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class et implements com.kwad.sdk.core.d {
    public static void a(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
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
        sDKInitMsg.ratioCount = jSONObject.optDouble("ratio_count");
    }

    public static JSONObject b(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = sDKInitMsg.launchIntervalTime;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "init_launch_interval_time", j);
        }
        long j2 = sDKInitMsg.totalDurationTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "init_total_duration_time", j2);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "init_status", sDKInitMsg.initStatus);
        String str = sDKInitMsg.errorReason;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, LoadErrorCode.Statistics.KEY_ERROR_REASON, sDKInitMsg.errorReason);
        }
        int i = sDKInitMsg.initCount;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "init_count", i);
        }
        int i2 = sDKInitMsg.initProcess;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "init_process", i2);
        }
        int i3 = sDKInitMsg.initThread;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "init_thread", i3);
        }
        double d = sDKInitMsg.ratioCount;
        if (d != 0.0d) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "ratio_count", d);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((SDKInitMsg) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((SDKInitMsg) bVar, jSONObject);
    }
}
