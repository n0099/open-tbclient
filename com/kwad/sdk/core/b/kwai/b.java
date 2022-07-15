package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.ActionBarInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdStyleInfo.PlayDetailInfo.ActionBarInfo actionBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        actionBarInfo.translateBtnShowTime = jSONObject.optLong("translateBtnShowTime");
        actionBarInfo.lightBtnShowTime = jSONObject.optLong("lightBtnShowTime");
        actionBarInfo.cardShowTime = jSONObject.optLong("cardShowTime");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdStyleInfo.PlayDetailInfo.ActionBarInfo actionBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "translateBtnShowTime", actionBarInfo.translateBtnShowTime);
        com.kwad.sdk.utils.r.a(jSONObject, "lightBtnShowTime", actionBarInfo.lightBtnShowTime);
        com.kwad.sdk.utils.r.a(jSONObject, "cardShowTime", actionBarInfo.cardShowTime);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo.ActionBarInfo actionBarInfo, JSONObject jSONObject) {
        a2(actionBarInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo.ActionBarInfo actionBarInfo, JSONObject jSONObject) {
        return b2(actionBarInfo, jSONObject);
    }
}
