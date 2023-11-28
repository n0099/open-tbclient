package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.report.a;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class dk implements com.kwad.sdk.core.d<a.C0711a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(a.C0711a c0711a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0711a.code = jSONObject.optInt("code");
        c0711a.msg = jSONObject.optString("msg");
        if (JSONObject.NULL.toString().equals(c0711a.msg)) {
            c0711a.msg = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(a.C0711a c0711a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c0711a.code;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "code", i);
        }
        String str = c0711a.msg;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "msg", c0711a.msg);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0711a c0711a, JSONObject jSONObject) {
        a2(c0711a, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0711a c0711a, JSONObject jSONObject) {
        return b2(c0711a, jSONObject);
    }
}
