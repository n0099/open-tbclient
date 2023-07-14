package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.jshandler.a;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class ci implements com.kwad.sdk.core.d<a.C0663a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(a.C0663a c0663a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0663a.Ld = jSONObject.optString("target");
        if (jSONObject.opt("target") == JSONObject.NULL) {
            c0663a.Ld = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(a.C0663a c0663a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0663a.Ld;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "target", c0663a.Ld);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0663a c0663a, JSONObject jSONObject) {
        a2(c0663a, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0663a c0663a, JSONObject jSONObject) {
        return b2(c0663a, jSONObject);
    }
}
