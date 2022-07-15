package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ao implements com.kwad.sdk.core.d<AdMatrixInfo.BottomBannerInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdMatrixInfo.BottomBannerInfo bottomBannerInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bottomBannerInfo.bannerSizeType = jSONObject.optInt("bannerSizeType");
        bottomBannerInfo.bannerAdType = jSONObject.optInt("bannerAdType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdMatrixInfo.BottomBannerInfo bottomBannerInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "bannerSizeType", bottomBannerInfo.bannerSizeType);
        com.kwad.sdk.utils.r.a(jSONObject, "bannerAdType", bottomBannerInfo.bannerAdType);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.BottomBannerInfo bottomBannerInfo, JSONObject jSONObject) {
        a2(bottomBannerInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.BottomBannerInfo bottomBannerInfo, JSONObject jSONObject) {
        return b2(bottomBannerInfo, jSONObject);
    }
}
