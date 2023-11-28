package com.kwad.sdk.core.b.a;

import com.kwad.components.core.request.model.b;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class bf implements com.kwad.sdk.core.d<b.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.streamType = jSONObject.optInt("streamType");
        aVar.RQ = jSONObject.optInt("maxVolume");
        aVar.RR = jSONObject.optInt("minVolume");
        aVar.RS = jSONObject.optInt("currentVolume");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.streamType;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "streamType", i);
        }
        int i2 = aVar.RQ;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "maxVolume", i2);
        }
        int i3 = aVar.RR;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "minVolume", i3);
        }
        int i4 = aVar.RS;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentVolume", i4);
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
