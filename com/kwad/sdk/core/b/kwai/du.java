package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class du implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.PatchEcInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdStyleInfo.PlayDetailInfo.PatchEcInfo patchEcInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        patchEcInfo.strongStyleItemId = jSONObject.optString("strongStyleItemId");
        if (jSONObject.opt("strongStyleItemId") == JSONObject.NULL) {
            patchEcInfo.strongStyleItemId = "";
        }
        patchEcInfo.strongStylePicUrl = jSONObject.optString("strongStylePicUrl");
        if (jSONObject.opt("strongStylePicUrl") == JSONObject.NULL) {
            patchEcInfo.strongStylePicUrl = "";
        }
        patchEcInfo.strongStyleItemUrl = jSONObject.optString("strongStyleItemUrl");
        if (jSONObject.opt("strongStyleItemUrl") == JSONObject.NULL) {
            patchEcInfo.strongStyleItemUrl = "";
        }
        patchEcInfo.strongStyleItemPrice = jSONObject.optString("strongStyleItemPrice");
        if (jSONObject.opt("strongStyleItemPrice") == JSONObject.NULL) {
            patchEcInfo.strongStyleItemPrice = "";
        }
        patchEcInfo.strongStylePriceAfterComm = jSONObject.optString("strongStylePriceAfterComm");
        if (jSONObject.opt("strongStylePriceAfterComm") == JSONObject.NULL) {
            patchEcInfo.strongStylePriceAfterComm = "";
        }
        patchEcInfo.strongStyleUserCommAmountBuying = jSONObject.optString("strongStyleUserCommAmountBuying");
        if (jSONObject.opt("strongStyleUserCommAmountBuying") == JSONObject.NULL) {
            patchEcInfo.strongStyleUserCommAmountBuying = "";
        }
        patchEcInfo.strongStyleUserCommAmountSharing = jSONObject.optString("strongStyleUserCommAmountSharing");
        if (jSONObject.opt("strongStyleUserCommAmountSharing") == JSONObject.NULL) {
            patchEcInfo.strongStyleUserCommAmountSharing = "";
        }
        patchEcInfo.nebulaKwaiLink = jSONObject.optString("nebulaKwaiLink");
        if (jSONObject.opt("nebulaKwaiLink") == JSONObject.NULL) {
            patchEcInfo.nebulaKwaiLink = "";
        }
        patchEcInfo.linkCode = jSONObject.optString("linkCode");
        if (jSONObject.opt("linkCode") == JSONObject.NULL) {
            patchEcInfo.linkCode = "";
        }
        patchEcInfo.platformTypeCode = jSONObject.optInt("platformTypeCode");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdStyleInfo.PlayDetailInfo.PatchEcInfo patchEcInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "strongStyleItemId", patchEcInfo.strongStyleItemId);
        com.kwad.sdk.utils.r.a(jSONObject, "strongStylePicUrl", patchEcInfo.strongStylePicUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "strongStyleItemUrl", patchEcInfo.strongStyleItemUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "strongStyleItemPrice", patchEcInfo.strongStyleItemPrice);
        com.kwad.sdk.utils.r.a(jSONObject, "strongStylePriceAfterComm", patchEcInfo.strongStylePriceAfterComm);
        com.kwad.sdk.utils.r.a(jSONObject, "strongStyleUserCommAmountBuying", patchEcInfo.strongStyleUserCommAmountBuying);
        com.kwad.sdk.utils.r.a(jSONObject, "strongStyleUserCommAmountSharing", patchEcInfo.strongStyleUserCommAmountSharing);
        com.kwad.sdk.utils.r.a(jSONObject, "nebulaKwaiLink", patchEcInfo.nebulaKwaiLink);
        com.kwad.sdk.utils.r.a(jSONObject, "linkCode", patchEcInfo.linkCode);
        com.kwad.sdk.utils.r.a(jSONObject, "platformTypeCode", patchEcInfo.platformTypeCode);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo.PatchEcInfo patchEcInfo, JSONObject jSONObject) {
        a2(patchEcInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo.PatchEcInfo patchEcInfo, JSONObject jSONObject) {
        return b2(patchEcInfo, jSONObject);
    }
}
