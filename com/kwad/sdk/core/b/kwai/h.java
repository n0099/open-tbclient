package com.kwad.sdk.core.b.kwai;

import com.kwad.components.ad.adbit.AdBid;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class h implements com.kwad.sdk.core.d {
    public static void a(AdBid adBid, JSONObject jSONObject) {
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

    public static JSONObject b(AdBid adBid, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = adBid.creativeId;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "creativeId", j);
        }
        long j2 = adBid.ecpm;
        if (j2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "ecpm", j2);
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

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdBid) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdBid) bVar, jSONObject);
    }
}
