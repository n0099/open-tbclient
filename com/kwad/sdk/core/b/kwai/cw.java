package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cw implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.PatchEcInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(AdStyleInfo.PlayDetailInfo.PatchEcInfo patchEcInfo, JSONObject jSONObject) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdStyleInfo.PlayDetailInfo.PatchEcInfo patchEcInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "strongStyleItemId", patchEcInfo.strongStyleItemId);
        com.kwad.sdk.utils.t.a(jSONObject, "strongStylePicUrl", patchEcInfo.strongStylePicUrl);
        com.kwad.sdk.utils.t.a(jSONObject, "strongStyleItemUrl", patchEcInfo.strongStyleItemUrl);
        com.kwad.sdk.utils.t.a(jSONObject, "strongStyleItemPrice", patchEcInfo.strongStyleItemPrice);
        com.kwad.sdk.utils.t.a(jSONObject, "strongStylePriceAfterComm", patchEcInfo.strongStylePriceAfterComm);
        com.kwad.sdk.utils.t.a(jSONObject, "strongStyleUserCommAmountBuying", patchEcInfo.strongStyleUserCommAmountBuying);
        com.kwad.sdk.utils.t.a(jSONObject, "strongStyleUserCommAmountSharing", patchEcInfo.strongStyleUserCommAmountSharing);
        com.kwad.sdk.utils.t.a(jSONObject, "nebulaKwaiLink", patchEcInfo.nebulaKwaiLink);
        com.kwad.sdk.utils.t.a(jSONObject, "linkCode", patchEcInfo.linkCode);
        com.kwad.sdk.utils.t.a(jSONObject, "platformTypeCode", patchEcInfo.platformTypeCode);
        return jSONObject;
    }
}
