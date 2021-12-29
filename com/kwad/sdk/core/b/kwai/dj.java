package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class dj implements com.kwad.sdk.core.d<PhotoInfo.ProductInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(PhotoInfo.ProductInfo productInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        productInfo.productId = jSONObject.optLong("productId");
        productInfo.shennongjiaLog = jSONObject.optString("shennongjiaLog");
        if (jSONObject.opt("shennongjiaLog") == JSONObject.NULL) {
            productInfo.shennongjiaLog = "";
        }
        productInfo.productDetails = jSONObject.optString("productDetail");
        if (jSONObject.opt("productDetail") == JSONObject.NULL) {
            productInfo.productDetails = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(PhotoInfo.ProductInfo productInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "productId", productInfo.productId);
        com.kwad.sdk.utils.t.a(jSONObject, "shennongjiaLog", productInfo.shennongjiaLog);
        com.kwad.sdk.utils.t.a(jSONObject, "productDetail", productInfo.productDetails);
        return jSONObject;
    }
}
