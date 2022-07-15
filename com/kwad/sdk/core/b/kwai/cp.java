package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.config.item.f;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class cp implements com.kwad.sdk.core.d<f.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(f.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optString("imei");
        if (jSONObject.opt("imei") == JSONObject.NULL) {
            aVar.a = "";
        }
        aVar.b = jSONObject.optString("oaid");
        if (jSONObject.opt("oaid") == JSONObject.NULL) {
            aVar.b = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(f.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "imei", aVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "oaid", aVar.b);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(f.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(f.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
