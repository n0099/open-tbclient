package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.webview.a.b;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class eh implements com.kwad.sdk.core.d<b.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            aVar.a = "";
        }
        aVar.b = jSONObject.optString("method");
        if (jSONObject.opt("method") == JSONObject.NULL) {
            aVar.b = "";
        }
        aVar.c = jSONObject.optString("params");
        if (jSONObject.opt("params") == JSONObject.NULL) {
            aVar.c = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "url", aVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "method", aVar.b);
        com.kwad.sdk.utils.r.a(jSONObject, "params", aVar.c);
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
