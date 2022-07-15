package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.CouponInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class w implements com.kwad.sdk.core.d<AdProductInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdProductInfo adProductInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adProductInfo.icon = jSONObject.optString("icon");
        if (jSONObject.opt("icon") == JSONObject.NULL) {
            adProductInfo.icon = "";
        }
        adProductInfo.name = jSONObject.optString("name");
        if (jSONObject.opt("name") == JSONObject.NULL) {
            adProductInfo.name = "";
        }
        adProductInfo.price = jSONObject.optString("price");
        if (jSONObject.opt("price") == JSONObject.NULL) {
            adProductInfo.price = "";
        }
        adProductInfo.originPrice = jSONObject.optString("originPrice");
        if (jSONObject.opt("originPrice") == JSONObject.NULL) {
            adProductInfo.originPrice = "";
        }
        adProductInfo.couponList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("couponList");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                CouponInfo couponInfo = new CouponInfo();
                couponInfo.parseJson(optJSONArray.optJSONObject(i));
                adProductInfo.couponList.add(couponInfo);
            }
        }
        adProductInfo.volume = jSONObject.optString("volume");
        if (jSONObject.opt("volume") == JSONObject.NULL) {
            adProductInfo.volume = "";
        }
        adProductInfo.rating = jSONObject.optString("rating");
        if (jSONObject.opt("rating") == JSONObject.NULL) {
            adProductInfo.rating = "";
        }
        AdProductInfo.SpikeInfo spikeInfo = new AdProductInfo.SpikeInfo();
        adProductInfo.seckillInfo = spikeInfo;
        spikeInfo.parseJson(jSONObject.optJSONObject("seckillInfo"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdProductInfo adProductInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "icon", adProductInfo.icon);
        com.kwad.sdk.utils.r.a(jSONObject, "name", adProductInfo.name);
        com.kwad.sdk.utils.r.a(jSONObject, "price", adProductInfo.price);
        com.kwad.sdk.utils.r.a(jSONObject, "originPrice", adProductInfo.originPrice);
        com.kwad.sdk.utils.r.a(jSONObject, "couponList", adProductInfo.couponList);
        com.kwad.sdk.utils.r.a(jSONObject, "volume", adProductInfo.volume);
        com.kwad.sdk.utils.r.a(jSONObject, "rating", adProductInfo.rating);
        com.kwad.sdk.utils.r.a(jSONObject, "seckillInfo", adProductInfo.seckillInfo);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdProductInfo adProductInfo, JSONObject jSONObject) {
        a2(adProductInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdProductInfo adProductInfo, JSONObject jSONObject) {
        return b2(adProductInfo, jSONObject);
    }
}
