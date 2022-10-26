package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.report.m;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class as implements com.kwad.sdk.core.d {
    public static void a(m.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.abo = jSONObject.optInt("posIdWidth");
        aVar.abp = jSONObject.optInt("posIdHeight");
    }

    public static JSONObject b(m.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.abo;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "posIdWidth", i);
        }
        int i2 = aVar.abp;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "posIdHeight", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((m.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((m.a) bVar, jSONObject);
    }
}
