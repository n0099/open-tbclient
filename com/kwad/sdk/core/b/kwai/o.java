package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.jshandler.c;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class o implements com.kwad.sdk.core.d<c.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optLong("creativeId", new Long("-1").longValue());
        aVar.b = jSONObject.optInt("adStyle", new Integer("-1").intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "creativeId", aVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "adStyle", aVar.b);
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
