package com.kwad.sdk.core.b.kwai;

import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.kwad.components.ad.reward.monitor.RewardMonitorInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ei implements com.kwad.sdk.core.d<RewardMonitorInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(RewardMonitorInfo rewardMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardMonitorInfo.radioCount = jSONObject.optLong("radio_count");
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

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(RewardMonitorInfo rewardMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "radio_count", rewardMonitorInfo.radioCount);
        com.kwad.sdk.utils.r.a(jSONObject, "load_type", rewardMonitorInfo.loadType);
        com.kwad.sdk.utils.r.a(jSONObject, "load_status", rewardMonitorInfo.loadStatus);
        com.kwad.sdk.utils.r.a(jSONObject, "ad_count", rewardMonitorInfo.adCount);
        com.kwad.sdk.utils.r.a(jSONObject, "load_data_duration_ms", rewardMonitorInfo.loadDataDuration);
        com.kwad.sdk.utils.r.a(jSONObject, "download_duration_ms", rewardMonitorInfo.downloadDuration);
        com.kwad.sdk.utils.r.a(jSONObject, "total_duration_ms", rewardMonitorInfo.totalDuration);
        com.kwad.sdk.utils.r.a(jSONObject, "download_type", rewardMonitorInfo.downloadType);
        com.kwad.sdk.utils.r.a(jSONObject, "download_size", rewardMonitorInfo.downloadSize);
        com.kwad.sdk.utils.r.a(jSONObject, "error_code", rewardMonitorInfo.errorCode);
        com.kwad.sdk.utils.r.a(jSONObject, GameCodeGetResponseMsg.PARAM_ERROR_MSG, rewardMonitorInfo.errorMsg);
        com.kwad.sdk.utils.r.a(jSONObject, "creative_id", rewardMonitorInfo.creativeId);
        com.kwad.sdk.utils.r.a(jSONObject, "video_url", rewardMonitorInfo.videoUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "video_duration_ms", rewardMonitorInfo.videoDuration);
        com.kwad.sdk.utils.r.a(jSONObject, "data_load_interval_duration_ms", rewardMonitorInfo.dataLoadInterval);
        com.kwad.sdk.utils.r.a(jSONObject, "data_download_interval_duration_ms", rewardMonitorInfo.dataDownloadInterval);
        com.kwad.sdk.utils.r.a(jSONObject, "render_duration_ms", rewardMonitorInfo.renderDuration);
        com.kwad.sdk.utils.r.a(jSONObject, "video_duration_ms", rewardMonitorInfo.currentDuration);
        com.kwad.sdk.utils.r.a(jSONObject, "page_status", rewardMonitorInfo.pageStatus);
        com.kwad.sdk.utils.r.a(jSONObject, "reward_type", rewardMonitorInfo.rewardType);
        com.kwad.sdk.utils.r.a(jSONObject, "task_type", rewardMonitorInfo.taskType);
        com.kwad.sdk.utils.r.a(jSONObject, "task_step", rewardMonitorInfo.taskStep);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(RewardMonitorInfo rewardMonitorInfo, JSONObject jSONObject) {
        a2(rewardMonitorInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(RewardMonitorInfo rewardMonitorInfo, JSONObject jSONObject) {
        return b2(rewardMonitorInfo, jSONObject);
    }
}
