package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.config.item.i;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class cs implements com.kwad.sdk.core.d<i.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.VD = jSONObject.optInt("horizontalShowDuration", new Integer("180000").intValue());
        aVar.VE = jSONObject.optInt("verticalShowDuration", new Integer("90000").intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "horizontalShowDuration", aVar.VD);
        com.kwad.sdk.utils.r.putValue(jSONObject, "verticalShowDuration", aVar.VE);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(i.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(i.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
