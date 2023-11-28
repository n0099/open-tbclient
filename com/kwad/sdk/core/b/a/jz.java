package com.kwad.sdk.core.b.a;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class jz implements com.kwad.sdk.core.d<com.kwad.sdk.core.threads.d> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.azK = jSONObject.optInt("rate_reciprocal");
        dVar.azQ = jSONObject.optInt("threshold");
        dVar.interval = jSONObject.optLong("interval");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = dVar.azK;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "rate_reciprocal", i);
        }
        int i2 = dVar.azQ;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "threshold", i2);
        }
        long j = dVar.interval;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "interval", j);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }
}
