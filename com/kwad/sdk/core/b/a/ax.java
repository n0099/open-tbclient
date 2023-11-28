package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.ar;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class ax implements com.kwad.sdk.core.d<ar.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(ar.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.id = jSONObject.optInt("id");
        aVar.status = jSONObject.optInt("status");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(ar.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.id;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "id", i);
        }
        int i2 = aVar.status;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i2);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ar.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ar.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
