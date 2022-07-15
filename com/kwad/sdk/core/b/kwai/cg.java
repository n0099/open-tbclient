package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.jshandler.a;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class cg implements com.kwad.sdk.core.d<a.C0521a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(a.C0521a c0521a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0521a.a = jSONObject.optString("target");
        if (jSONObject.opt("target") == JSONObject.NULL) {
            c0521a.a = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(a.C0521a c0521a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "target", c0521a.a);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0521a c0521a, JSONObject jSONObject) {
        a2(c0521a, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0521a c0521a, JSONObject jSONObject) {
        return b2(c0521a, jSONObject);
    }
}
