package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class df implements com.kwad.sdk.core.d<com.kwad.components.ad.reward.b.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.ad.reward.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.oL = jSONObject.optInt("extraRewardType", new Integer("2").intValue());
        bVar.oM = jSONObject.optInt("extraRewardStatus");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.ad.reward.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "extraRewardType", bVar.oL);
        int i = bVar.oM;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "extraRewardStatus", i);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.ad.reward.b.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.ad.reward.b.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
