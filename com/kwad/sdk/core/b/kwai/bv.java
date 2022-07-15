package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.report.a;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class bv implements com.kwad.sdk.core.d<a.C0544a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(a.C0544a c0544a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0544a.a = jSONObject.optInt("code");
        c0544a.b = jSONObject.optString("msg");
        if (jSONObject.opt("msg") == JSONObject.NULL) {
            c0544a.b = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(a.C0544a c0544a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "code", c0544a.a);
        com.kwad.sdk.utils.r.a(jSONObject, "msg", c0544a.b);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0544a c0544a, JSONObject jSONObject) {
        a2(c0544a, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0544a c0544a, JSONObject jSONObject) {
        return b2(c0544a, jSONObject);
    }
}
