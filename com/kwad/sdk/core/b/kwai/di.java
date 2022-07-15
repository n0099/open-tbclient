package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class di implements com.kwad.sdk.core.d<AdMatrixInfo.MerchantLiveReservationInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        merchantLiveReservationInfo.title = jSONObject.optString("title");
        if (jSONObject.opt("title") == JSONObject.NULL) {
            merchantLiveReservationInfo.title = "";
        }
        merchantLiveReservationInfo.userHeadUrl = jSONObject.optString("userHeadUrl");
        if (jSONObject.opt("userHeadUrl") == JSONObject.NULL) {
            merchantLiveReservationInfo.userHeadUrl = "";
        }
        merchantLiveReservationInfo.bookUserCount = jSONObject.optInt("bookUserCount");
        merchantLiveReservationInfo.liveStartTime = jSONObject.optString("liveStartTime");
        if (jSONObject.opt("liveStartTime") == JSONObject.NULL) {
            merchantLiveReservationInfo.liveStartTime = "";
        }
        merchantLiveReservationInfo.displayWeakCard = jSONObject.optBoolean("displayWeakCard");
        merchantLiveReservationInfo.bookUserUrlList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("bookUserUrlList");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                merchantLiveReservationInfo.bookUserUrlList.add((String) optJSONArray.opt(i));
            }
        }
        merchantLiveReservationInfo.displayBookCount = jSONObject.optBoolean("displayBookCount");
        AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo = new AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo();
        merchantLiveReservationInfo.playEndCard = liveReservationPlayEndInfo;
        liveReservationPlayEndInfo.parseJson(jSONObject.optJSONObject("playEndCard"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "title", merchantLiveReservationInfo.title);
        com.kwad.sdk.utils.r.a(jSONObject, "userHeadUrl", merchantLiveReservationInfo.userHeadUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "bookUserCount", merchantLiveReservationInfo.bookUserCount);
        com.kwad.sdk.utils.r.a(jSONObject, "liveStartTime", merchantLiveReservationInfo.liveStartTime);
        com.kwad.sdk.utils.r.a(jSONObject, "displayWeakCard", merchantLiveReservationInfo.displayWeakCard);
        com.kwad.sdk.utils.r.a(jSONObject, "bookUserUrlList", merchantLiveReservationInfo.bookUserUrlList);
        com.kwad.sdk.utils.r.a(jSONObject, "displayBookCount", merchantLiveReservationInfo.displayBookCount);
        com.kwad.sdk.utils.r.a(jSONObject, "playEndCard", merchantLiveReservationInfo.playEndCard);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo, JSONObject jSONObject) {
        a2(merchantLiveReservationInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo, JSONObject jSONObject) {
        return b2(merchantLiveReservationInfo, jSONObject);
    }
}
