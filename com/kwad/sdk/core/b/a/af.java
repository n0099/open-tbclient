package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.a;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class af implements com.kwad.sdk.core.d<a.C0664a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(a.C0664a c0664a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0664a.Jw = jSONObject.optString("creativeId");
        if (JSONObject.NULL.toString().equals(c0664a.Jw)) {
            c0664a.Jw = "";
        }
        c0664a.VE = jSONObject.optString("targetMethod");
        if (JSONObject.NULL.toString().equals(c0664a.VE)) {
            c0664a.VE = "";
        }
        c0664a.VF = jSONObject.optString("methodParams");
        if (JSONObject.NULL.toString().equals(c0664a.VF)) {
            c0664a.VF = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(a.C0664a c0664a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0664a.Jw;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", c0664a.Jw);
        }
        String str2 = c0664a.VE;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "targetMethod", c0664a.VE);
        }
        String str3 = c0664a.VF;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "methodParams", c0664a.VF);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0664a c0664a, JSONObject jSONObject) {
        a2(c0664a, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0664a c0664a, JSONObject jSONObject) {
        return b2(c0664a, jSONObject);
    }
}
