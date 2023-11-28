package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.a.a;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class cz implements com.kwad.sdk.core.d<a.C0663a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(a.C0663a c0663a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0663a.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(c0663a.url)) {
            c0663a.url = "";
        }
        c0663a.packageName = jSONObject.optString("packageName");
        if (JSONObject.NULL.toString().equals(c0663a.packageName)) {
            c0663a.packageName = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(a.C0663a c0663a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0663a.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", c0663a.url);
        }
        String str2 = c0663a.packageName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "packageName", c0663a.packageName);
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
