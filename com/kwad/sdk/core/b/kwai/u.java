package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class u implements com.kwad.sdk.core.d {
    public static void a(AdMatrixInfo adMatrixInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdMatrixInfo.Styles styles = new AdMatrixInfo.Styles();
        adMatrixInfo.styles = styles;
        styles.parseJson(jSONObject.optJSONObject("styles"));
        AdMatrixInfo.AdDataV2 adDataV2 = new AdMatrixInfo.AdDataV2();
        adMatrixInfo.adDataV2 = adDataV2;
        adDataV2.parseJson(jSONObject.optJSONObject("adDataV2"));
    }

    public static JSONObject b(AdMatrixInfo adMatrixInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "styles", adMatrixInfo.styles);
        com.kwad.sdk.utils.r.a(jSONObject, "adDataV2", adMatrixInfo.adDataV2);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo) bVar, jSONObject);
    }
}
