package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.jshandler.s;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class cx implements com.kwad.sdk.core.d<s.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(s.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.a = jSONObject.optDouble("progress");
        bVar.b = jSONObject.optInt("status");
        bVar.c = jSONObject.optLong("totalBytes");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(s.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "progress", bVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "status", bVar.b);
        com.kwad.sdk.utils.r.a(jSONObject, "totalBytes", bVar.c);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(s.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(s.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
