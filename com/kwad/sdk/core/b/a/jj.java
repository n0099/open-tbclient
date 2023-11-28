package com.kwad.sdk.core.b.a;

import com.kwad.sdk.m.k;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class jj implements com.kwad.sdk.core.d<k.a.C0724a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(k.a.C0724a c0724a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0724a.aRM = jSONObject.optString("s_cn");
        if (JSONObject.NULL.toString().equals(c0724a.aRM)) {
            c0724a.aRM = "";
        }
        c0724a.aRN = jSONObject.optString("s_mn");
        if (JSONObject.NULL.toString().equals(c0724a.aRN)) {
            c0724a.aRN = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(k.a.C0724a c0724a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0724a.aRM;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "s_cn", c0724a.aRM);
        }
        String str2 = c0724a.aRN;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "s_mn", c0724a.aRN);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(k.a.C0724a c0724a, JSONObject jSONObject) {
        a2(c0724a, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(k.a.C0724a c0724a, JSONObject jSONObject) {
        return b2(c0724a, jSONObject);
    }
}
