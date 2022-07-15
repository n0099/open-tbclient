package com.kwad.sdk.core.b.kwai;

import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class fa implements com.kwad.sdk.core.d<SplashMonitorInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashMonitorInfo.radioCount = jSONObject.optLong("radio_count");
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
        com.kwad.sdk.utils.r.a(jSONObject, "radio_count", splashMonitorInfo.radioCount);
        com.kwad.sdk.utils.r.a(jSONObject, "status", splashMonitorInfo.status);
        com.kwad.sdk.utils.r.a(jSONObject, "type", splashMonitorInfo.type);
        com.kwad.sdk.utils.r.a(jSONObject, "preload_id", splashMonitorInfo.preloadId);
        com.kwad.sdk.utils.r.a(jSONObject, "error_code", splashMonitorInfo.errorCode);
        com.kwad.sdk.utils.r.a(jSONObject, GameCodeGetResponseMsg.PARAM_ERROR_MSG, splashMonitorInfo.errorMsg);
        com.kwad.sdk.utils.r.a(jSONObject, "load_data_duration_ms", splashMonitorInfo.loadDataTime);
        com.kwad.sdk.utils.r.a(jSONObject, "check_data_duration_ms", splashMonitorInfo.checkDataTime);
        com.kwad.sdk.utils.r.a(jSONObject, "load_and_check_data_duration_ms", splashMonitorInfo.loadAndCheckDataTime);
        com.kwad.sdk.utils.r.a(jSONObject, "duration_ms", splashMonitorInfo.costTime);
        com.kwad.sdk.utils.r.a(jSONObject, "ids", splashMonitorInfo.ids);
        com.kwad.sdk.utils.r.a(jSONObject, "count", splashMonitorInfo.count);
        com.kwad.sdk.utils.r.a(jSONObject, "validity_period_ms", splashMonitorInfo.cacheValidTime);
        com.kwad.sdk.utils.r.a(jSONObject, "size", splashMonitorInfo.size);
        com.kwad.sdk.utils.r.a(jSONObject, "fail_url", splashMonitorInfo.failUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "creative_id", splashMonitorInfo.creativeId);
        com.kwad.sdk.utils.r.a(jSONObject, "material_type", splashMonitorInfo.materialType);
        com.kwad.sdk.utils.r.a(jSONObject, "total_count", splashMonitorInfo.totalCount);
        com.kwad.sdk.utils.r.a(jSONObject, "creative_ids", splashMonitorInfo.creativeIds);
        com.kwad.sdk.utils.r.a(jSONObject, "preload_ids", splashMonitorInfo.preloadIds);
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
