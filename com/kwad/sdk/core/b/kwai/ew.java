package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ew implements com.kwad.sdk.core.d<com.kwad.sdk.internal.api.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.internal.api.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.a = jSONObject.optBoolean("disableShake");
        bVar.b = jSONObject.optBoolean("disableRotate");
        bVar.c = jSONObject.optBoolean("disableSlide");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.internal.api.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "disableShake", bVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "disableRotate", bVar.b);
        com.kwad.sdk.utils.r.a(jSONObject, "disableSlide", bVar.c);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.internal.api.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.internal.api.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
