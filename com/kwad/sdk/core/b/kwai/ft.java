package com.kwad.sdk.core.b.kwai;

import com.kwad.components.ad.f.kwai.kwai.b;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ft implements com.kwad.sdk.core.d {
    public static void a(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.kA = jSONObject.optInt("timerName");
        aVar.kB = jSONObject.optInt("time");
    }

    public static JSONObject b(b.a aVar, JSONObject jSONObject) {
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

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((b.a) bVar, jSONObject);
    }
}
