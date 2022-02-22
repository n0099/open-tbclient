package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class di implements com.kwad.sdk.core.d<PhotoInfo.ProductInfo.ProductDetail> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(PhotoInfo.ProductInfo.ProductDetail productDetail, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        productDetail.weakStyleIcon = jSONObject.optString("weakStyleIcon");
        if (jSONObject.opt("weakStyleIcon") == JSONObject.NULL) {
            productDetail.weakStyleIcon = "";
        }
        productDetail.weakStyleTitle = jSONObject.optString("weakStyleTitle");
        if (jSONObject.opt("weakStyleTitle") == JSONObject.NULL) {
            productDetail.weakStyleTitle = "";
        }
        productDetail.weakStyleAppearTime = jSONObject.optInt("weakStyleAppearTime");
        productDetail.weakStyleShowTime = jSONObject.optInt("weakStyleShowTime");
        productDetail.weakStyleEnableClose = jSONObject.optBoolean("weakStyleEnableClose");
        productDetail.weakStyleAdMark = jSONObject.optString("weakStyleAdMark");
        if (jSONObject.opt("weakStyleAdMark") == JSONObject.NULL) {
            productDetail.weakStyleAdMark = "";
        }
        productDetail.strongStyleItemId = jSONObject.optLong("strongStyleItemId");
        productDetail.strongStylePicUrl = jSONObject.optString("strongStylePicUrl");
        if (jSONObject.opt("strongStylePicUrl") == JSONObject.NULL) {
            productDetail.strongStylePicUrl = "";
        }
        productDetail.strongStyleTitle = jSONObject.optString("strongStyleTitle");
        if (jSONObject.opt("strongStyleTitle") == JSONObject.NULL) {
            productDetail.strongStyleTitle = "";
        }
        productDetail.strongStyleItemPrice = jSONObject.optString("strongStyleItemPrice");
        if (jSONObject.opt("strongStyleItemPrice") == JSONObject.NULL) {
            productDetail.strongStyleItemPrice = "";
        }
        productDetail.strongStyleItemUrl = jSONObject.optString("strongStyleItemUrl");
        if (jSONObject.opt("strongStyleItemUrl") == JSONObject.NULL) {
            productDetail.strongStyleItemUrl = "";
        }
        productDetail.strongStyleCardUrl = jSONObject.optString("strongStyleCardUrl");
        if (jSONObject.opt("strongStyleCardUrl") == JSONObject.NULL) {
            productDetail.strongStyleCardUrl = "";
        }
        productDetail.strongStyleEnableClose = jSONObject.optBoolean("strongStyleEnableClose");
        productDetail.strongStyleAdMark = jSONObject.optString("strongStyleAdMark");
        if (jSONObject.opt("strongStyleAdMark") == JSONObject.NULL) {
            productDetail.strongStyleAdMark = "";
        }
        productDetail.strongStyleAppearTime = jSONObject.optInt("strongStyleAppearTime");
        productDetail.strongStylePriceAfterComm = jSONObject.optString("strongStylePriceAfterComm");
        if (jSONObject.opt("strongStylePriceAfterComm") == JSONObject.NULL) {
            productDetail.strongStylePriceAfterComm = "";
        }
        productDetail.strongStyleUserCommAmountBuying = jSONObject.optString("strongStyleUserCommAmountBuying");
        if (jSONObject.opt("strongStyleUserCommAmountBuying") == JSONObject.NULL) {
            productDetail.strongStyleUserCommAmountBuying = "";
        }
        productDetail.strongStyleUserCommAmountSharing = jSONObject.optString("strongStyleUserCommAmountSharing");
        if (jSONObject.opt("strongStyleUserCommAmountSharing") == JSONObject.NULL) {
            productDetail.strongStyleUserCommAmountSharing = "";
        }
        productDetail.platformTypeCode = jSONObject.optInt("platformTypeCode");
        productDetail.nebulaKwaiLink = jSONObject.optString("nebulaKwaiLink");
        if (jSONObject.opt("nebulaKwaiLink") == JSONObject.NULL) {
            productDetail.nebulaKwaiLink = "";
        }
        productDetail.linkCode = jSONObject.optString("linkCode");
        if (jSONObject.opt("linkCode") == JSONObject.NULL) {
            productDetail.linkCode = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(PhotoInfo.ProductInfo.ProductDetail productDetail, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "weakStyleIcon", productDetail.weakStyleIcon);
        com.kwad.sdk.utils.t.a(jSONObject, "weakStyleTitle", productDetail.weakStyleTitle);
        com.kwad.sdk.utils.t.a(jSONObject, "weakStyleAppearTime", productDetail.weakStyleAppearTime);
        com.kwad.sdk.utils.t.a(jSONObject, "weakStyleShowTime", productDetail.weakStyleShowTime);
        com.kwad.sdk.utils.t.a(jSONObject, "weakStyleEnableClose", productDetail.weakStyleEnableClose);
        com.kwad.sdk.utils.t.a(jSONObject, "weakStyleAdMark", productDetail.weakStyleAdMark);
        com.kwad.sdk.utils.t.a(jSONObject, "strongStyleItemId", productDetail.strongStyleItemId);
        com.kwad.sdk.utils.t.a(jSONObject, "strongStylePicUrl", productDetail.strongStylePicUrl);
        com.kwad.sdk.utils.t.a(jSONObject, "strongStyleTitle", productDetail.strongStyleTitle);
        com.kwad.sdk.utils.t.a(jSONObject, "strongStyleItemPrice", productDetail.strongStyleItemPrice);
        com.kwad.sdk.utils.t.a(jSONObject, "strongStyleItemUrl", productDetail.strongStyleItemUrl);
        com.kwad.sdk.utils.t.a(jSONObject, "strongStyleCardUrl", productDetail.strongStyleCardUrl);
        com.kwad.sdk.utils.t.a(jSONObject, "strongStyleEnableClose", productDetail.strongStyleEnableClose);
        com.kwad.sdk.utils.t.a(jSONObject, "strongStyleAdMark", productDetail.strongStyleAdMark);
        com.kwad.sdk.utils.t.a(jSONObject, "strongStyleAppearTime", productDetail.strongStyleAppearTime);
        com.kwad.sdk.utils.t.a(jSONObject, "strongStylePriceAfterComm", productDetail.strongStylePriceAfterComm);
        com.kwad.sdk.utils.t.a(jSONObject, "strongStyleUserCommAmountBuying", productDetail.strongStyleUserCommAmountBuying);
        com.kwad.sdk.utils.t.a(jSONObject, "strongStyleUserCommAmountSharing", productDetail.strongStyleUserCommAmountSharing);
        com.kwad.sdk.utils.t.a(jSONObject, "platformTypeCode", productDetail.platformTypeCode);
        com.kwad.sdk.utils.t.a(jSONObject, "nebulaKwaiLink", productDetail.nebulaKwaiLink);
        com.kwad.sdk.utils.t.a(jSONObject, "linkCode", productDetail.linkCode);
        return jSONObject;
    }
}
