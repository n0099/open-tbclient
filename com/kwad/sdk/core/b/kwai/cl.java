package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.jshandler.u;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class cl implements com.kwad.sdk.core.d<u.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(u.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.creativeId = jSONObject.optLong("creativeId", new Long("-1").longValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(u.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "creativeId", bVar.creativeId);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(u.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(u.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
