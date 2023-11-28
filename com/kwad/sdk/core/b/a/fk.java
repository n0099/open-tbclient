package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.interstitial.report.realtime.model.InterstitialRealTimeInfo;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class fk implements com.kwad.sdk.core.d<InterstitialRealTimeInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(InterstitialRealTimeInfo interstitialRealTimeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        interstitialRealTimeInfo.renderType = jSONObject.optLong("render_type");
        interstitialRealTimeInfo.monitorIndex = jSONObject.optLong("monitor_index");
        interstitialRealTimeInfo.materialUrl = jSONObject.optString("material_url");
        if (JSONObject.NULL.toString().equals(interstitialRealTimeInfo.materialUrl)) {
            interstitialRealTimeInfo.materialUrl = "";
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(InterstitialRealTimeInfo interstitialRealTimeInfo, JSONObject jSONObject) {
        return b2(interstitialRealTimeInfo, jSONObject);
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(InterstitialRealTimeInfo interstitialRealTimeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = interstitialRealTimeInfo.renderType;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "render_type", j);
        }
        long j2 = interstitialRealTimeInfo.monitorIndex;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "monitor_index", j2);
        }
        String str = interstitialRealTimeInfo.materialUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "material_url", interstitialRealTimeInfo.materialUrl);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(InterstitialRealTimeInfo interstitialRealTimeInfo, JSONObject jSONObject) {
        a2(interstitialRealTimeInfo, jSONObject);
    }
}
