package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class cd implements com.kwad.sdk.core.d<AdMatrixInfo.FullPageActionBarInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdMatrixInfo.FullPageActionBarInfo fullPageActionBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fullPageActionBarInfo.maxTimeOut = jSONObject.optLong("maxTimeOut");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdMatrixInfo.FullPageActionBarInfo fullPageActionBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "maxTimeOut", fullPageActionBarInfo.maxTimeOut);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.FullPageActionBarInfo fullPageActionBarInfo, JSONObject jSONObject) {
        a2(fullPageActionBarInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.FullPageActionBarInfo fullPageActionBarInfo, JSONObject jSONObject) {
        return b2(fullPageActionBarInfo, jSONObject);
    }
}
