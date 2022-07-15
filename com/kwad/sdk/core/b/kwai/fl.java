package com.kwad.sdk.core.b.kwai;

import com.kwad.components.ad.f.kwai.kwai.a;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class fl implements com.kwad.sdk.core.d<a.C0461a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(a.C0461a c0461a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0461a.a = jSONObject.optInt("timerName");
        c0461a.b = jSONObject.optInt("time");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(a.C0461a c0461a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "timerName", c0461a.a);
        com.kwad.sdk.utils.r.a(jSONObject, "time", c0461a.b);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0461a c0461a, JSONObject jSONObject) {
        a2(c0461a, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0461a c0461a, JSONObject jSONObject) {
        return b2(c0461a, jSONObject);
    }
}
