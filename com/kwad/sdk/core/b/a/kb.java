package com.kwad.sdk.core.b.a;

import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class kb implements com.kwad.sdk.core.d<BlockEvent.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(BlockEvent.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aFu = jSONObject.optLong("endTimestamp");
        aVar.repeatCount = jSONObject.optInt("repeatCount", new Integer("1").intValue());
        aVar.aFv = jSONObject.optBoolean("runIdle");
        aVar.aFw = jSONObject.optString("stackTraceDetail");
        if (JSONObject.NULL.toString().equals(aVar.aFw)) {
            aVar.aFw = "";
        }
        aVar.aFx = jSONObject.optLong("startTimestamp");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(BlockEvent.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = aVar.aFu;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "endTimestamp", j);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "repeatCount", aVar.repeatCount);
        boolean z = aVar.aFv;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "runIdle", z);
        }
        String str = aVar.aFw;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "stackTraceDetail", aVar.aFw);
        }
        long j2 = aVar.aFx;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "startTimestamp", j2);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(BlockEvent.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(BlockEvent.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
