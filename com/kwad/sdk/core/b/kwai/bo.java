package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.a.a;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class bo implements com.kwad.sdk.core.d<a.C0586a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(a.C0586a c0586a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0586a.url = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            c0586a.url = "";
        }
        c0586a.packageName = jSONObject.optString("packageName");
        if (jSONObject.opt("packageName") == JSONObject.NULL) {
            c0586a.packageName = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(a.C0586a c0586a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0586a.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "url", c0586a.url);
        }
        String str2 = c0586a.packageName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "packageName", c0586a.packageName);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0586a c0586a, JSONObject jSONObject) {
        a2(c0586a, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0586a c0586a, JSONObject jSONObject) {
        return b2(c0586a, jSONObject);
    }
}
