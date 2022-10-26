package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.report.a;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class bw implements com.kwad.sdk.core.d {
    public static void a(a.C0604a c0604a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0604a.code = jSONObject.optInt("code");
        c0604a.Qd = jSONObject.optString("msg");
        if (jSONObject.opt("msg") == JSONObject.NULL) {
            c0604a.Qd = "";
        }
    }

    public static JSONObject b(a.C0604a c0604a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c0604a.code;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "code", i);
        }
        String str = c0604a.Qd;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "msg", c0604a.Qd);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.C0604a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.C0604a) bVar, jSONObject);
    }
}
