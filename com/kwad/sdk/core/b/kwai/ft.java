package com.kwad.sdk.core.b.kwai;

import com.kwad.components.ad.f.kwai.kwai.b;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class ft implements com.kwad.sdk.core.d<b.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.kA = jSONObject.optInt("timerName");
        aVar.kB = jSONObject.optInt("time");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.kA;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "timerName", i);
        }
        int i2 = aVar.kB;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "time", i2);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
