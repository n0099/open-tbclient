package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ap implements com.kwad.sdk.core.d {
    public static void a(AdMatrixInfo.BottomBannerInfo bottomBannerInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bottomBannerInfo.bannerSizeType = jSONObject.optInt("bannerSizeType");
        bottomBannerInfo.bannerAdType = jSONObject.optInt("bannerAdType");
    }

    public static JSONObject b(AdMatrixInfo.BottomBannerInfo bottomBannerInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bottomBannerInfo.bannerSizeType;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "bannerSizeType", i);
        }
        int i2 = bottomBannerInfo.bannerAdType;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "bannerAdType", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.BottomBannerInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.BottomBannerInfo) bVar, jSONObject);
    }
}
