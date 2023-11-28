package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.reward.k.s;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class io implements com.kwad.sdk.core.d<s.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(s.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.xq = jSONObject.optBoolean("needCloseNeo");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(s.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = aVar.xq;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "needCloseNeo", z);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(s.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(s.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
