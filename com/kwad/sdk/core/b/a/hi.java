package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class hi implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.PatchEcInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdStyleInfo.PlayDetailInfo.PatchEcInfo patchEcInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        patchEcInfo.strongStyleItemId = jSONObject.optString("strongStyleItemId");
        if (JSONObject.NULL.toString().equals(patchEcInfo.strongStyleItemId)) {
            patchEcInfo.strongStyleItemId = "";
        }
        patchEcInfo.strongStylePicUrl = jSONObject.optString("strongStylePicUrl");
        if (JSONObject.NULL.toString().equals(patchEcInfo.strongStylePicUrl)) {
            patchEcInfo.strongStylePicUrl = "";
        }
        patchEcInfo.strongStyleItemUrl = jSONObject.optString("strongStyleItemUrl");
        if (JSONObject.NULL.toString().equals(patchEcInfo.strongStyleItemUrl)) {
            patchEcInfo.strongStyleItemUrl = "";
        }
        patchEcInfo.strongStyleItemPrice = jSONObject.optString("strongStyleItemPrice");
        if (JSONObject.NULL.toString().equals(patchEcInfo.strongStyleItemPrice)) {
            patchEcInfo.strongStyleItemPrice = "";
        }
        patchEcInfo.strongStylePriceAfterComm = jSONObject.optString("strongStylePriceAfterComm");
        if (JSONObject.NULL.toString().equals(patchEcInfo.strongStylePriceAfterComm)) {
            patchEcInfo.strongStylePriceAfterComm = "";
        }
        patchEcInfo.strongStyleUserCommAmountBuying = jSONObject.optString("strongStyleUserCommAmountBuying");
        if (JSONObject.NULL.toString().equals(patchEcInfo.strongStyleUserCommAmountBuying)) {
            patchEcInfo.strongStyleUserCommAmountBuying = "";
        }
        patchEcInfo.strongStyleUserCommAmountSharing = jSONObject.optString("strongStyleUserCommAmountSharing");
        if (JSONObject.NULL.toString().equals(patchEcInfo.strongStyleUserCommAmountSharing)) {
            patchEcInfo.strongStyleUserCommAmountSharing = "";
        }
        patchEcInfo.nebulaKwaiLink = jSONObject.optString("nebulaKwaiLink");
        if (JSONObject.NULL.toString().equals(patchEcInfo.nebulaKwaiLink)) {
            patchEcInfo.nebulaKwaiLink = "";
        }
        patchEcInfo.linkCode = jSONObject.optString("linkCode");
        if (JSONObject.NULL.toString().equals(patchEcInfo.linkCode)) {
            patchEcInfo.linkCode = "";
        }
        patchEcInfo.platformTypeCode = jSONObject.optInt("platformTypeCode");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdStyleInfo.PlayDetailInfo.PatchEcInfo patchEcInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = patchEcInfo.strongStyleItemId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "strongStyleItemId", patchEcInfo.strongStyleItemId);
        }
        String str2 = patchEcInfo.strongStylePicUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "strongStylePicUrl", patchEcInfo.strongStylePicUrl);
        }
        String str3 = patchEcInfo.strongStyleItemUrl;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "strongStyleItemUrl", patchEcInfo.strongStyleItemUrl);
        }
        String str4 = patchEcInfo.strongStyleItemPrice;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "strongStyleItemPrice", patchEcInfo.strongStyleItemPrice);
        }
        String str5 = patchEcInfo.strongStylePriceAfterComm;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "strongStylePriceAfterComm", patchEcInfo.strongStylePriceAfterComm);
        }
        String str6 = patchEcInfo.strongStyleUserCommAmountBuying;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "strongStyleUserCommAmountBuying", patchEcInfo.strongStyleUserCommAmountBuying);
        }
        String str7 = patchEcInfo.strongStyleUserCommAmountSharing;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "strongStyleUserCommAmountSharing", patchEcInfo.strongStyleUserCommAmountSharing);
        }
        String str8 = patchEcInfo.nebulaKwaiLink;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "nebulaKwaiLink", patchEcInfo.nebulaKwaiLink);
        }
        String str9 = patchEcInfo.linkCode;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "linkCode", patchEcInfo.linkCode);
        }
        int i = patchEcInfo.platformTypeCode;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "platformTypeCode", i);
        }
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
