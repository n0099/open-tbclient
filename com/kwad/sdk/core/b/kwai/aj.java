package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.j.kwai.c;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class aj implements com.kwad.sdk.core.d<c.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt("streamType");
        aVar.b = jSONObject.optInt("maxVolume");
        aVar.c = jSONObject.optInt("minVolume");
        aVar.d = jSONObject.optInt("currentVolume");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "streamType", aVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "maxVolume", aVar.b);
        com.kwad.sdk.utils.r.a(jSONObject, "minVolume", aVar.c);
        com.kwad.sdk.utils.r.a(jSONObject, "currentVolume", aVar.d);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(c.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(c.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
