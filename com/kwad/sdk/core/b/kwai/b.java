package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b implements com.kwad.sdk.core.d {
    public static void a(AdStyleInfo.PlayDetailInfo.ActionBarInfo actionBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        actionBarInfo.translateBtnShowTime = jSONObject.optLong("translateBtnShowTime");
        actionBarInfo.lightBtnShowTime = jSONObject.optLong("lightBtnShowTime");
        actionBarInfo.cardShowTime = jSONObject.optLong("cardShowTime");
    }

    public static JSONObject b(AdStyleInfo.PlayDetailInfo.ActionBarInfo actionBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = actionBarInfo.translateBtnShowTime;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "translateBtnShowTime", j);
        }
        long j2 = actionBarInfo.lightBtnShowTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "lightBtnShowTime", j2);
        }
        long j3 = actionBarInfo.cardShowTime;
        if (j3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "cardShowTime", j3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo.PlayDetailInfo.ActionBarInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo.PlayDetailInfo.ActionBarInfo) bVar, jSONObject);
    }
}
