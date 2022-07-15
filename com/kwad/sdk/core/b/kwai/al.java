package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class al implements com.kwad.sdk.core.d<com.kwad.components.ad.reward.model.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.ad.reward.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.a = jSONObject.optLong("lastShowCardTimeStamp");
        bVar.b = jSONObject.optInt("cardShowCount");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.ad.reward.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "lastShowCardTimeStamp", bVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "cardShowCount", bVar.b);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.ad.reward.model.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.ad.reward.model.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
