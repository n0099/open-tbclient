package com.kwad.sdk.core.b.kwai;

import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.kwad.components.splash.monitor.SplashMonitorInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class fi implements com.kwad.sdk.core.d<SplashMonitorInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashMonitorInfo.ratioCount = jSONObject.optDouble("ratio_count");
        splashMonitorInfo.status = jSONObject.optInt("status");
        splashMonitorInfo.type = jSONObject.optInt("type");
        splashMonitorInfo.preloadId = jSONObject.optString("preload_id");
        if (jSONObject.opt("preload_id") == JSONObject.NULL) {
            splashMonitorInfo.preloadId = "";
        }
        splashMonitorInfo.errorCode = jSONObject.optInt("error_code");
        splashMonitorInfo.errorMsg = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
        if (jSONObject.opt(GameCodeGetResponseMsg.PARAM_ERROR_MSG) == JSONObject.NULL) {
            splashMonitorInfo.errorMsg = "";
        }
        splashMonitorInfo.loadDataTime = jSONObject.optLong("load_data_duration_ms");
        splashMonitorInfo.checkDataTime = jSONObject.optLong("check_data_duration_ms");
        splashMonitorInfo.loadAndCheckDataTime = jSONObject.optLong("load_and_check_data_duration_ms");
        splashMonitorInfo.costTime = jSONObject.optLong("duration_ms");
        splashMonitorInfo.ids = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("ids");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                splashMonitorInfo.ids.add((String) optJSONArray.opt(i));
            }
        }
        splashMonitorInfo.count = jSONObject.optInt("count");
        splashMonitorInfo.cacheValidTime = jSONObject.optLong("validity_period_ms");
        splashMonitorInfo.size = jSONObject.optLong("size");
        splashMonitorInfo.failUrl = jSONObject.optString("fail_url");
        if (jSONObject.opt("fail_url") == JSONObject.NULL) {
            splashMonitorInfo.failUrl = "";
        }
        splashMonitorInfo.creativeId = jSONObject.optLong("creative_id");
        splashMonitorInfo.materialType = jSONObject.optInt("material_type");
        splashMonitorInfo.totalCount = jSONObject.optInt("total_count");
        splashMonitorInfo.creativeIds = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("creative_ids");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                splashMonitorInfo.creativeIds.add((String) optJSONArray2.opt(i2));
            }
        }
        splashMonitorInfo.preloadIds = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("preload_ids");
        if (optJSONArray3 != null) {
            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                splashMonitorInfo.preloadIds.add((String) optJSONArray3.opt(i3));
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d = splashMonitorInfo.ratioCount;
        if (d != 0.0d) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "ratio_count", d);
        }
        int i = splashMonitorInfo.status;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "status", i);
        }
        int i2 = splashMonitorInfo.type;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "type", i2);
        }
        String str = splashMonitorInfo.preloadId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "preload_id", splashMonitorInfo.preloadId);
        }
        int i3 = splashMonitorInfo.errorCode;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "error_code", i3);
        }
        String str2 = splashMonitorInfo.errorMsg;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, GameCodeGetResponseMsg.PARAM_ERROR_MSG, splashMonitorInfo.errorMsg);
        }
        long j = splashMonitorInfo.loadDataTime;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "load_data_duration_ms", j);
        }
        long j2 = splashMonitorInfo.checkDataTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "check_data_duration_ms", j2);
        }
        long j3 = splashMonitorInfo.loadAndCheckDataTime;
        if (j3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "load_and_check_data_duration_ms", j3);
        }
        long j4 = splashMonitorInfo.costTime;
        if (j4 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "duration_ms", j4);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "ids", splashMonitorInfo.ids);
        int i4 = splashMonitorInfo.count;
        if (i4 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "count", i4);
        }
        long j5 = splashMonitorInfo.cacheValidTime;
        if (j5 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "validity_period_ms", j5);
        }
        long j6 = splashMonitorInfo.size;
        if (j6 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "size", j6);
        }
        String str3 = splashMonitorInfo.failUrl;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "fail_url", splashMonitorInfo.failUrl);
        }
        long j7 = splashMonitorInfo.creativeId;
        if (j7 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "creative_id", j7);
        }
        int i5 = splashMonitorInfo.materialType;
        if (i5 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "material_type", i5);
        }
        int i6 = splashMonitorInfo.totalCount;
        if (i6 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "total_count", i6);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "creative_ids", splashMonitorInfo.creativeIds);
        com.kwad.sdk.utils.r.putValue(jSONObject, "preload_ids", splashMonitorInfo.preloadIds);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        a2(splashMonitorInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        return b2(splashMonitorInfo, jSONObject);
    }
}
