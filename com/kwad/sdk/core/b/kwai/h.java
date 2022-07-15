package com.kwad.sdk.core.b.kwai;

import com.kwad.components.ad.adbit.AdBid;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class h implements com.kwad.sdk.core.d<AdBid> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdBid adBid, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adBid.creativeId = jSONObject.optLong("creativeId");
        adBid.ecpm = jSONObject.optLong("ecpm");
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
        com.kwad.sdk.utils.r.a(jSONObject, "creativeId", adBid.creativeId);
        com.kwad.sdk.utils.r.a(jSONObject, "ecpm", adBid.ecpm);
        com.kwad.sdk.utils.r.a(jSONObject, "bidEcpm", adBid.bidEcpm);
        com.kwad.sdk.utils.r.a(jSONObject, "winNoticeUrl", adBid.winNoticeUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "materialId", adBid.materialId);
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
