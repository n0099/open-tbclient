package com.kwad.sdk.core.b.kwai;

import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.kwad.components.ad.reward.monitor.RewardMonitorInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ep implements com.kwad.sdk.core.d {
    public static void a(RewardMonitorInfo rewardMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardMonitorInfo.ratioCount = jSONObject.optDouble("ratio_count");
        rewardMonitorInfo.loadType = jSONObject.optInt("load_type");
        rewardMonitorInfo.loadStatus = jSONObject.optInt("load_status");
        rewardMonitorInfo.adCount = jSONObject.optInt("ad_count");
        rewardMonitorInfo.loadDataDuration = jSONObject.optLong("load_data_duration_ms");
        rewardMonitorInfo.downloadDuration = jSONObject.optLong("download_duration_ms");
        rewardMonitorInfo.totalDuration = jSONObject.optLong("total_duration_ms");
        rewardMonitorInfo.downloadType = jSONObject.optInt("download_type");
        rewardMonitorInfo.downloadSize = jSONObject.optLong("download_size");
        rewardMonitorInfo.errorCode = jSONObject.optInt("error_code");
        rewardMonitorInfo.errorMsg = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
        if (jSONObject.opt(GameCodeGetResponseMsg.PARAM_ERROR_MSG) == JSONObject.NULL) {
            rewardMonitorInfo.errorMsg = "";
        }
        rewardMonitorInfo.creativeId = jSONObject.optLong("creative_id");
        rewardMonitorInfo.videoUrl = jSONObject.optString("video_url");
        if (jSONObject.opt("video_url") == JSONObject.NULL) {
            rewardMonitorInfo.videoUrl = "";
        }
        rewardMonitorInfo.videoDuration = jSONObject.optLong("video_duration_ms");
        rewardMonitorInfo.dataLoadInterval = jSONObject.optLong("data_load_interval_duration_ms");
        rewardMonitorInfo.dataDownloadInterval = jSONObject.optLong("data_download_interval_duration_ms");
        rewardMonitorInfo.renderDuration = jSONObject.optLong("render_duration_ms");
        rewardMonitorInfo.currentDuration = jSONObject.optLong("video_duration_ms");
        rewardMonitorInfo.pageStatus = jSONObject.optInt("page_status");
        rewardMonitorInfo.rewardType = jSONObject.optInt("reward_type");
        rewardMonitorInfo.taskType = jSONObject.optInt("task_type");
        rewardMonitorInfo.taskStep = jSONObject.optInt("task_step");
    }

    public static JSONObject b(RewardMonitorInfo rewardMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d = rewardMonitorInfo.ratioCount;
        if (d != 0.0d) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "ratio_count", d);
        }
        int i = rewardMonitorInfo.loadType;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "load_type", i);
        }
        int i2 = rewardMonitorInfo.loadStatus;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "load_status", i2);
        }
        int i3 = rewardMonitorInfo.adCount;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "ad_count", i3);
        }
        long j = rewardMonitorInfo.loadDataDuration;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "load_data_duration_ms", j);
        }
        long j2 = rewardMonitorInfo.downloadDuration;
        if (j2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "download_duration_ms", j2);
        }
        long j3 = rewardMonitorInfo.totalDuration;
        if (j3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "total_duration_ms", j3);
        }
        int i4 = rewardMonitorInfo.downloadType;
        if (i4 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "download_type", i4);
        }
        long j4 = rewardMonitorInfo.downloadSize;
        if (j4 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "download_size", j4);
        }
        int i5 = rewardMonitorInfo.errorCode;
        if (i5 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "error_code", i5);
        }
        String str = rewardMonitorInfo.errorMsg;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, GameCodeGetResponseMsg.PARAM_ERROR_MSG, rewardMonitorInfo.errorMsg);
        }
        long j5 = rewardMonitorInfo.creativeId;
        if (j5 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "creative_id", j5);
        }
        String str2 = rewardMonitorInfo.videoUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "video_url", rewardMonitorInfo.videoUrl);
        }
        long j6 = rewardMonitorInfo.videoDuration;
        if (j6 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "video_duration_ms", j6);
        }
        long j7 = rewardMonitorInfo.dataLoadInterval;
        if (j7 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "data_load_interval_duration_ms", j7);
        }
        long j8 = rewardMonitorInfo.dataDownloadInterval;
        if (j8 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "data_download_interval_duration_ms", j8);
        }
        long j9 = rewardMonitorInfo.renderDuration;
        if (j9 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "render_duration_ms", j9);
        }
        long j10 = rewardMonitorInfo.currentDuration;
        if (j10 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "video_duration_ms", j10);
        }
        int i6 = rewardMonitorInfo.pageStatus;
        if (i6 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "page_status", i6);
        }
        int i7 = rewardMonitorInfo.rewardType;
        if (i7 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "reward_type", i7);
        }
        int i8 = rewardMonitorInfo.taskType;
        if (i8 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "task_type", i8);
        }
        int i9 = rewardMonitorInfo.taskStep;
        if (i9 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "task_step", i9);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((RewardMonitorInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((RewardMonitorInfo) bVar, jSONObject);
    }
}
