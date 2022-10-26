package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class al implements com.kwad.sdk.core.d {
    public static void a(com.kwad.components.ad.reward.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.pg = jSONObject.optLong("lastShowCardTimeStamp");
        bVar.ph = jSONObject.optInt("cardShowCount");
    }

    public static JSONObject b(com.kwad.components.ad.reward.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = bVar.pg;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "lastShowCardTimeStamp", j);
        }
        int i = bVar.ph;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "cardShowCount", i);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.reward.model.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.reward.model.b) bVar, jSONObject);
    }
}
