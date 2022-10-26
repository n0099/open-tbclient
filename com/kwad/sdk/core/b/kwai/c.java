package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class c implements com.kwad.sdk.core.d {
    public static void a(AdMatrixInfo.ActionBarInfoNew actionBarInfoNew, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        actionBarInfoNew.maxTimeOut = jSONObject.optLong("maxTimeOut");
        actionBarInfoNew.cardType = jSONObject.optInt("cardType");
    }

    public static JSONObject b(AdMatrixInfo.ActionBarInfoNew actionBarInfoNew, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = actionBarInfoNew.maxTimeOut;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "maxTimeOut", j);
        }
        int i = actionBarInfoNew.cardType;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "cardType", i);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.ActionBarInfoNew) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.ActionBarInfoNew) bVar, jSONObject);
    }
}
