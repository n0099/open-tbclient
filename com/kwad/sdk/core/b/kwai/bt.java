package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class bt implements com.kwad.sdk.core.d {
    public static void a(AdStyleInfo.PlayDetailInfo.DrawAdInfo drawAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        drawAdInfo.forcedWatch = jSONObject.optBoolean("forcedWatch");
    }

    public static JSONObject b(AdStyleInfo.PlayDetailInfo.DrawAdInfo drawAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = drawAdInfo.forcedWatch;
        if (z) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "forcedWatch", z);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo.PlayDetailInfo.DrawAdInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo.PlayDetailInfo.DrawAdInfo) bVar, jSONObject);
    }
}
