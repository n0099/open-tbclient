package com.kwad.sdk.core.b.kwai;

import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.kwad.sdk.core.response.model.AdProductInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class et implements com.kwad.sdk.core.d<AdProductInfo.SpikeInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        spikeInfo.endTime = jSONObject.optLong(FetchLog.END_TIME);
        spikeInfo.soldStock = jSONObject.optInt("soldStock");
        spikeInfo.originalStock = jSONObject.optInt("originalStock");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, FetchLog.END_TIME, spikeInfo.endTime);
        com.kwad.sdk.utils.r.a(jSONObject, "soldStock", spikeInfo.soldStock);
        com.kwad.sdk.utils.r.a(jSONObject, "originalStock", spikeInfo.originalStock);
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
