package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class gr implements com.kwad.sdk.core.d<AdGlobalConfigInfo.NeoScanAggregationSceneInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdGlobalConfigInfo.NeoScanAggregationSceneInfo neoScanAggregationSceneInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        neoScanAggregationSceneInfo.neoCountDownNeedSwipeTrigger = jSONObject.optBoolean("neoCountDownNeedSwipeTrigger");
        neoScanAggregationSceneInfo.neoCountDownTime = jSONObject.optInt("neoCountDownTime");
        neoScanAggregationSceneInfo.noActionStopCountDown = jSONObject.optBoolean("noActionStopCountDown");
        neoScanAggregationSceneInfo.noActionTime = jSONObject.optInt("noActionTime");
        neoScanAggregationSceneInfo.guidSwipezShowMore = jSONObject.optBoolean("guidSwipezShowMore");
        neoScanAggregationSceneInfo.mute = jSONObject.optBoolean("mute");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdGlobalConfigInfo.NeoScanAggregationSceneInfo neoScanAggregationSceneInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = neoScanAggregationSceneInfo.neoCountDownNeedSwipeTrigger;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "neoCountDownNeedSwipeTrigger", z);
        }
        int i = neoScanAggregationSceneInfo.neoCountDownTime;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "neoCountDownTime", i);
        }
        boolean z2 = neoScanAggregationSceneInfo.noActionStopCountDown;
        if (z2) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "noActionStopCountDown", z2);
        }
        int i2 = neoScanAggregationSceneInfo.noActionTime;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "noActionTime", i2);
        }
        boolean z3 = neoScanAggregationSceneInfo.guidSwipezShowMore;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "guidSwipezShowMore", z3);
        }
        boolean z4 = neoScanAggregationSceneInfo.mute;
        if (z4) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mute", z4);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdGlobalConfigInfo.NeoScanAggregationSceneInfo neoScanAggregationSceneInfo, JSONObject jSONObject) {
        a2(neoScanAggregationSceneInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdGlobalConfigInfo.NeoScanAggregationSceneInfo neoScanAggregationSceneInfo, JSONObject jSONObject) {
        return b2(neoScanAggregationSceneInfo, jSONObject);
    }
}
