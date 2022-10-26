package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class cf implements com.kwad.sdk.core.d {
    public static void a(AdMatrixInfo.FullPageActionBarInfo fullPageActionBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fullPageActionBarInfo.maxTimeOut = jSONObject.optLong("maxTimeOut");
    }

    public static JSONObject b(AdMatrixInfo.FullPageActionBarInfo fullPageActionBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = fullPageActionBarInfo.maxTimeOut;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "maxTimeOut", j);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.FullPageActionBarInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.FullPageActionBarInfo) bVar, jSONObject);
    }
}
