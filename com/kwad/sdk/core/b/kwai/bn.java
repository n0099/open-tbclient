package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.a.a;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class bn implements com.kwad.sdk.core.d<a.C0519a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(a.C0519a c0519a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0519a.a = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            c0519a.a = "";
        }
        c0519a.b = jSONObject.optString("packageName");
        if (jSONObject.opt("packageName") == JSONObject.NULL) {
            c0519a.b = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(a.C0519a c0519a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "url", c0519a.a);
        com.kwad.sdk.utils.r.a(jSONObject, "packageName", c0519a.b);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0519a c0519a, JSONObject jSONObject) {
        a2(c0519a, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0519a c0519a, JSONObject jSONObject) {
        return b2(c0519a, jSONObject);
    }
}
