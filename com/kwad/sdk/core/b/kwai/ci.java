package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.jshandler.a;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class ci implements com.kwad.sdk.core.d<a.C0665a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(a.C0665a c0665a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0665a.Ld = jSONObject.optString("target");
        if (jSONObject.opt("target") == JSONObject.NULL) {
            c0665a.Ld = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(a.C0665a c0665a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0665a.Ld;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "target", c0665a.Ld);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0665a c0665a, JSONObject jSONObject) {
        a2(c0665a, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0665a c0665a, JSONObject jSONObject) {
        return b2(c0665a, jSONObject);
    }
}
