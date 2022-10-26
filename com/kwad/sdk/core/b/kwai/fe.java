package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class fe implements com.kwad.sdk.core.d {
    public static void a(com.kwad.sdk.internal.api.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.disableShake = jSONObject.optBoolean("disableShake");
        bVar.disableRotate = jSONObject.optBoolean("disableRotate");
        bVar.disableSlide = jSONObject.optBoolean("disableSlide");
    }

    public static JSONObject b(com.kwad.sdk.internal.api.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = bVar.disableShake;
        if (z) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "disableShake", z);
        }
        boolean z2 = bVar.disableRotate;
        if (z2) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "disableRotate", z2);
        }
        boolean z3 = bVar.disableSlide;
        if (z3) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "disableSlide", z3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.internal.api.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.internal.api.b) bVar, jSONObject);
    }
}
