package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class bt implements com.kwad.sdk.core.d<AdMatrixInfo.EndCardInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdMatrixInfo.EndCardInfo endCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        endCardInfo.cardShowPlayCount = jSONObject.optInt("cardShowPlayCount");
        endCardInfo.cardType = jSONObject.optInt("cardType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdMatrixInfo.EndCardInfo endCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "cardShowPlayCount", endCardInfo.cardShowPlayCount);
        com.kwad.sdk.utils.r.a(jSONObject, "cardType", endCardInfo.cardType);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.EndCardInfo endCardInfo, JSONObject jSONObject) {
        a2(endCardInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.EndCardInfo endCardInfo, JSONObject jSONObject) {
        return b2(endCardInfo, jSONObject);
    }
}
