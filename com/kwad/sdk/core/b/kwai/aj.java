package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.k.kwai.c;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class aj implements com.kwad.sdk.core.d<c.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.streamType = jSONObject.optInt("streamType");
        aVar.It = jSONObject.optInt("maxVolume");
        aVar.Iu = jSONObject.optInt("minVolume");
        aVar.Iv = jSONObject.optInt("currentVolume");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.streamType;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "streamType", i);
        }
        int i2 = aVar.It;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "maxVolume", i2);
        }
        int i3 = aVar.Iu;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "minVolume", i3);
        }
        int i4 = aVar.Iv;
        if (i4 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "currentVolume", i4);
        }
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
