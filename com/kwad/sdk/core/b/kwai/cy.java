package com.kwad.sdk.core.b.kwai;

import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.kwad.components.ad.interstitial.monitor.InterstitialMonitorInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class cy implements com.kwad.sdk.core.d {
    public static void a(InterstitialMonitorInfo interstitialMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        interstitialMonitorInfo.ratioCount = jSONObject.optDouble("ratio_count");
        interstitialMonitorInfo.status = jSONObject.optInt("status");
        interstitialMonitorInfo.type = jSONObject.optInt("type");
        interstitialMonitorInfo.loadDataTime = jSONObject.optLong("load_data_duration_ms");
        interstitialMonitorInfo.renderDuration = jSONObject.optLong("render_duration_ms");
        interstitialMonitorInfo.renderType = jSONObject.optInt("render_type");
        interstitialMonitorInfo.materialType = jSONObject.optInt("material_type");
        interstitialMonitorInfo.downloadDuration = jSONObject.optLong("download_duration_ms");
        interstitialMonitorInfo.downloadType = jSONObject.optInt("download_type");
        interstitialMonitorInfo.downloadSize = jSONObject.optLong("download_size");
        interstitialMonitorInfo.errorCode = jSONObject.optInt("error_code");
        interstitialMonitorInfo.errorMsg = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
        if (jSONObject.opt(GameCodeGetResponseMsg.PARAM_ERROR_MSG) == JSONObject.NULL) {
            interstitialMonitorInfo.errorMsg = "";
        }
        interstitialMonitorInfo.creativeId = jSONObject.optLong("creative_id");
        interstitialMonitorInfo.videoUrl = jSONObject.optString("video_url");
        if (jSONObject.opt("video_url") == JSONObject.NULL) {
            interstitialMonitorInfo.videoUrl = "";
        }
        interstitialMonitorInfo.videoDuration = jSONObject.optLong("video_duration_ms");
    }

    public static JSONObject b(InterstitialMonitorInfo interstitialMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d = interstitialMonitorInfo.ratioCount;
        if (d != 0.0d) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "ratio_count", d);
        }
        int i = interstitialMonitorInfo.status;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "status", i);
        }
        int i2 = interstitialMonitorInfo.type;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "type", i2);
        }
        long j = interstitialMonitorInfo.loadDataTime;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "load_data_duration_ms", j);
        }
        long j2 = interstitialMonitorInfo.renderDuration;
        if (j2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "render_duration_ms", j2);
        }
        int i3 = interstitialMonitorInfo.renderType;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "render_type", i3);
        }
        int i4 = interstitialMonitorInfo.materialType;
        if (i4 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "material_type", i4);
        }
        long j3 = interstitialMonitorInfo.downloadDuration;
        if (j3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "download_duration_ms", j3);
        }
        int i5 = interstitialMonitorInfo.downloadType;
        if (i5 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "download_type", i5);
        }
        long j4 = interstitialMonitorInfo.downloadSize;
        if (j4 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "download_size", j4);
        }
        int i6 = interstitialMonitorInfo.errorCode;
        if (i6 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "error_code", i6);
        }
        String str = interstitialMonitorInfo.errorMsg;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, GameCodeGetResponseMsg.PARAM_ERROR_MSG, interstitialMonitorInfo.errorMsg);
        }
        long j5 = interstitialMonitorInfo.creativeId;
        if (j5 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "creative_id", j5);
        }
        String str2 = interstitialMonitorInfo.videoUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "video_url", interstitialMonitorInfo.videoUrl);
        }
        long j6 = interstitialMonitorInfo.videoDuration;
        if (j6 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "video_duration_ms", j6);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((InterstitialMonitorInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((InterstitialMonitorInfo) bVar, jSONObject);
    }
}
