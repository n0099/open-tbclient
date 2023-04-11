package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.report.a;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class bw implements com.kwad.sdk.core.d<a.C0632a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(a.C0632a c0632a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0632a.code = jSONObject.optInt("code");
        c0632a.Qd = jSONObject.optString("msg");
        if (jSONObject.opt("msg") == JSONObject.NULL) {
            c0632a.Qd = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(a.C0632a c0632a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c0632a.code;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "code", i);
        }
        String str = c0632a.Qd;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "msg", c0632a.Qd);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0632a c0632a, JSONObject jSONObject) {
        a2(c0632a, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0632a c0632a, JSONObject jSONObject) {
        return b2(c0632a, jSONObject);
    }
}
