package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.report.m;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ar implements com.kwad.sdk.core.d<m.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(m.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt("posIdWidth");
        aVar.b = jSONObject.optInt("posIdHeight");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(m.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "posIdWidth", aVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "posIdHeight", aVar.b);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(m.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(m.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
