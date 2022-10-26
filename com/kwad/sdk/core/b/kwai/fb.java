package com.kwad.sdk.core.b.kwai;

import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.kwad.sdk.core.response.model.AdProductInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class fb implements com.kwad.sdk.core.d {
    public static void a(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        spikeInfo.endTime = jSONObject.optLong(FetchLog.END_TIME);
        spikeInfo.soldStock = jSONObject.optInt("soldStock");
        spikeInfo.originalStock = jSONObject.optInt("originalStock");
    }

    public static JSONObject b(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = spikeInfo.endTime;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, FetchLog.END_TIME, j);
        }
        int i = spikeInfo.soldStock;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "soldStock", i);
        }
        int i2 = spikeInfo.originalStock;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "originalStock", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdProductInfo.SpikeInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdProductInfo.SpikeInfo) bVar, jSONObject);
    }
}
