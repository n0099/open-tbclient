package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.jshandler.y;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class ag implements com.kwad.sdk.core.d<y.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(y.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.MD = jSONObject.optDouble("progress");
        aVar.status = jSONObject.optInt("status");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(y.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d = aVar.MD;
        if (d != 0.0d) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "progress", d);
        }
        int i = aVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "status", i);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(y.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(y.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
