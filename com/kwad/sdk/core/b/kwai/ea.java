package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ea implements com.kwad.sdk.core.d {
    public static void a(AdStyleInfo.PlayDetailInfo.PatchEcInfo patchEcInfo, JSONObject jSONObject) {
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

    public static JSONObject b(AdStyleInfo.PlayDetailInfo.PatchEcInfo patchEcInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = patchEcInfo.strongStyleItemId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "strongStyleItemId", patchEcInfo.strongStyleItemId);
        }
        String str2 = patchEcInfo.strongStylePicUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "strongStylePicUrl", patchEcInfo.strongStylePicUrl);
        }
        String str3 = patchEcInfo.strongStyleItemUrl;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "strongStyleItemUrl", patchEcInfo.strongStyleItemUrl);
        }
        String str4 = patchEcInfo.strongStyleItemPrice;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "strongStyleItemPrice", patchEcInfo.strongStyleItemPrice);
        }
        String str5 = patchEcInfo.strongStylePriceAfterComm;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "strongStylePriceAfterComm", patchEcInfo.strongStylePriceAfterComm);
        }
        String str6 = patchEcInfo.strongStyleUserCommAmountBuying;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "strongStyleUserCommAmountBuying", patchEcInfo.strongStyleUserCommAmountBuying);
        }
        String str7 = patchEcInfo.strongStyleUserCommAmountSharing;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "strongStyleUserCommAmountSharing", patchEcInfo.strongStyleUserCommAmountSharing);
        }
        String str8 = patchEcInfo.nebulaKwaiLink;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "nebulaKwaiLink", patchEcInfo.nebulaKwaiLink);
        }
        String str9 = patchEcInfo.linkCode;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "linkCode", patchEcInfo.linkCode);
        }
        int i = patchEcInfo.platformTypeCode;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "platformTypeCode", i);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo.PlayDetailInfo.PatchEcInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo.PlayDetailInfo.PatchEcInfo) bVar, jSONObject);
    }
}
