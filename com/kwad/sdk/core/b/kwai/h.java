package com.kwad.sdk.core.b.kwai;

import com.baidu.mobads.sdk.api.SplashAd;
import com.kwad.components.ad.adbit.AdBid;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class h implements com.kwad.sdk.core.d<AdBid> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdBid adBid, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adBid.creativeId = jSONObject.optLong("creativeId");
        adBid.ecpm = jSONObject.optLong(SplashAd.KEY_BIDFAIL_ECPM);
        adBid.bidEcpm = jSONObject.optInt("bidEcpm");
        adBid.winNoticeUrl = jSONObject.optString("winNoticeUrl");
        if (jSONObject.opt("winNoticeUrl") == JSONObject.NULL) {
            adBid.winNoticeUrl = "";
        }
        adBid.materialId = jSONObject.optString("materialId");
        if (jSONObject.opt("materialId") == JSONObject.NULL) {
            adBid.materialId = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdBid adBid, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = adBid.creativeId;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "creativeId", j);
        }
        long j2 = adBid.ecpm;
        if (j2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, SplashAd.KEY_BIDFAIL_ECPM, j2);
        }
        int i = adBid.bidEcpm;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "bidEcpm", i);
        }
        String str = adBid.winNoticeUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "winNoticeUrl", adBid.winNoticeUrl);
        }
        String str2 = adBid.materialId;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "materialId", adBid.materialId);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdBid adBid, JSONObject jSONObject) {
        a2(adBid, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdBid adBid, JSONObject jSONObject) {
        return b2(adBid, jSONObject);
    }
}
