package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.a.a;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class bo implements com.kwad.sdk.core.d {
    public static void a(a.C0578a c0578a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0578a.url = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            c0578a.url = "";
        }
        c0578a.packageName = jSONObject.optString("packageName");
        if (jSONObject.opt("packageName") == JSONObject.NULL) {
            c0578a.packageName = "";
        }
    }

    public static JSONObject b(a.C0578a c0578a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0578a.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "url", c0578a.url);
        }
        String str2 = c0578a.packageName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "packageName", c0578a.packageName);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.C0578a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.C0578a) bVar, jSONObject);
    }
}
