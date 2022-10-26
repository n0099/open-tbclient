package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class df implements com.kwad.sdk.core.d {
    public static void a(com.kwad.components.ad.reward.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.oL = jSONObject.optInt("extraRewardType", new Integer("2").intValue());
        bVar.oM = jSONObject.optInt("extraRewardStatus");
    }

    public static JSONObject b(com.kwad.components.ad.reward.b.b bVar, JSONObject jSONObject) {
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

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.reward.b.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.reward.b.b) bVar, jSONObject);
    }
}
