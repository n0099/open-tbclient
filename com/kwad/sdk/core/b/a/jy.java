package com.kwad.sdk.core.b.a;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class jy implements com.kwad.sdk.core.d<com.kwad.sdk.core.threads.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.azz = jSONObject.optString("pool_name");
        if (JSONObject.NULL.toString().equals(bVar.azz)) {
            bVar.azz = "";
        }
        bVar.azA = jSONObject.optInt("core_pool_size");
        bVar.azB = jSONObject.optInt("max_pool_size");
        bVar.azC = jSONObject.optInt("current_pool_size");
        bVar.azD = jSONObject.optInt("active_count");
        bVar.azE = jSONObject.optLong("task_wait_avg_ms");
        bVar.azF = jSONObject.optLong("task_succ_count");
        bVar.interval = jSONObject.optLong("interval_ms");
        bVar.azG = jSONObject.optInt("queue_size");
        bVar.azH = jSONObject.optLong("pass_timestamp");
        bVar.azI = jSONObject.optInt("func_ratio_count");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.azz;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pool_name", bVar.azz);
        }
        int i = bVar.azA;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "core_pool_size", i);
        }
        int i2 = bVar.azB;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "max_pool_size", i2);
        }
        int i3 = bVar.azC;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "current_pool_size", i3);
        }
        int i4 = bVar.azD;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "active_count", i4);
        }
        long j = bVar.azE;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "task_wait_avg_ms", j);
        }
        long j2 = bVar.azF;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "task_succ_count", j2);
        }
        long j3 = bVar.interval;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "interval_ms", j3);
        }
        int i5 = bVar.azG;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "queue_size", i5);
        }
        long j4 = bVar.azH;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pass_timestamp", j4);
        }
        int i6 = bVar.azI;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "func_ratio_count", i6);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
