package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdProductInfo;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class fb implements com.kwad.sdk.core.d<AdProductInfo.SpikeInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        spikeInfo.endTime = jSONObject.optLong("endTime");
        spikeInfo.soldStock = jSONObject.optInt("soldStock");
        spikeInfo.originalStock = jSONObject.optInt("originalStock");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = spikeInfo.endTime;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "endTime", j);
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        a2(spikeInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        return b2(spikeInfo, jSONObject);
    }
}
