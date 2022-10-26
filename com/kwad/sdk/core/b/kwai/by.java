package com.kwad.sdk.core.b.kwai;

import com.kwad.components.ad.reward.b.e;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class by implements com.kwad.sdk.core.d {
    public static void a(e.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.oN = jSONObject.optString("dialogEvent");
        if (jSONObject.opt("dialogEvent") == JSONObject.NULL) {
            aVar.oN = "";
        }
    }

    public static JSONObject b(e.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.oN;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "dialogEvent", aVar.oN);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((e.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((e.a) bVar, jSONObject);
    }
}
