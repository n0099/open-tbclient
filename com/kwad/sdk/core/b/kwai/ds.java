package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.jshandler.u;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ds implements com.kwad.sdk.core.d<u.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(u.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt("status");
        aVar.b = jSONObject.optString("errorMsg");
        if (jSONObject.opt("errorMsg") == JSONObject.NULL) {
            aVar.b = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(u.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "status", aVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "errorMsg", aVar.b);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(u.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(u.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
