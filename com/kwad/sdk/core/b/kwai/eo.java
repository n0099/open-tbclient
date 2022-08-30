package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class eo implements com.kwad.sdk.core.d<com.kwad.components.ad.reward.e.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.ad.reward.e.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.en = jSONObject.optLong("lastShowTimestamp");
        bVar.oV = jSONObject.optInt("jumpDirectCount");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.ad.reward.e.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = bVar.en;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "lastShowTimestamp", j);
        }
        int i = bVar.oV;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "jumpDirectCount", i);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.ad.reward.e.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.ad.reward.e.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
