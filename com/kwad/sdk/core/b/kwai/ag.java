package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.jshandler.v;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ag implements com.kwad.sdk.core.d<v.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(v.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optDouble("progress");
        aVar.b = jSONObject.optInt("status");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(v.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "progress", aVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "status", aVar.b);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(v.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(v.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
