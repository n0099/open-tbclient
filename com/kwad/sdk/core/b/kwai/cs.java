package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.config.item.i;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class cs implements com.kwad.sdk.core.d {
    public static void a(i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.VD = jSONObject.optInt("horizontalShowDuration", new Integer("180000").intValue());
        aVar.VE = jSONObject.optInt("verticalShowDuration", new Integer("90000").intValue());
    }

    public static JSONObject b(i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "horizontalShowDuration", aVar.VD);
        com.kwad.sdk.utils.r.putValue(jSONObject, "verticalShowDuration", aVar.VE);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((i.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((i.a) bVar, jSONObject);
    }
}
