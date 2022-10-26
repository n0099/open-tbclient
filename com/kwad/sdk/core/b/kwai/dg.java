package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class dg implements com.kwad.sdk.core.d {
    public static void a(com.kwad.sdk.utils.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aqu = jSONObject.optInt("put_count");
        aVar.aqv = jSONObject.optInt("get_failed_count");
        aVar.Yr = jSONObject.optInt("ratio_count");
    }

    public static JSONObject b(com.kwad.sdk.utils.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.aqu;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "put_count", i);
        }
        int i2 = aVar.aqv;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "get_failed_count", i2);
        }
        int i3 = aVar.Yr;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "ratio_count", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.utils.a.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.utils.a.a) bVar, jSONObject);
    }
}
