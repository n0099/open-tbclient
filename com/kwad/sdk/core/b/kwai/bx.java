package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.config.item.h;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bx implements com.kwad.sdk.core.d<h.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optString("imei");
        if (jSONObject.opt("imei") == JSONObject.NULL) {
            aVar.a = "";
        }
        aVar.f55858b = jSONObject.optString("oaid");
        if (jSONObject.opt("oaid") == JSONObject.NULL) {
            aVar.f55858b = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "imei", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "oaid", aVar.f55858b);
        return jSONObject;
    }
}
