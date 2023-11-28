package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.report.q;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class bw implements com.kwad.sdk.core.d<q.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(q.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.awQ = jSONObject.optInt("posIdWidth");
        aVar.awR = jSONObject.optInt("posIdHeight");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(q.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.awQ;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "posIdWidth", i);
        }
        int i2 = aVar.awR;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "posIdHeight", i2);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(q.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(q.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
