package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStatusInfo;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class al implements com.kwad.sdk.core.d<AdStatusInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adStatusInfo.loadFromCache = jSONObject.optBoolean("loadFromCache");
        adStatusInfo.loadDataTime = jSONObject.optLong("loadDataTime");
        adStatusInfo.downloadFinishTime = jSONObject.optLong("downloadFinishTime");
        adStatusInfo.downloadType = jSONObject.optInt("downloadType");
        adStatusInfo.downloadSize = jSONObject.optLong("downloadSize");
        adStatusInfo.downloadStatus = jSONObject.optInt("downloadStatus");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = adStatusInfo.loadFromCache;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "loadFromCache", z);
        }
        long j = adStatusInfo.loadDataTime;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "loadDataTime", j);
        }
        long j2 = adStatusInfo.downloadFinishTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadFinishTime", j2);
        }
        int i = adStatusInfo.downloadType;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadType", i);
        }
        long j3 = adStatusInfo.downloadSize;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadSize", j3);
        }
        int i2 = adStatusInfo.downloadStatus;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadStatus", i2);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        a2(adStatusInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        return b2(adStatusInfo, jSONObject);
    }
}
