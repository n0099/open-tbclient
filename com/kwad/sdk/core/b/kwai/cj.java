package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.jshandler.r;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class cj implements com.kwad.sdk.core.d<r.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(r.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.a = jSONObject.optLong("creativeId", new Long("-1").longValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(r.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "creativeId", bVar.a);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(r.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(r.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
