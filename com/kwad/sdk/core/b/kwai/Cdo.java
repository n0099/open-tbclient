package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: com.kwad.sdk.core.b.kwai.do  reason: invalid class name */
/* loaded from: classes7.dex */
public final class Cdo implements com.kwad.sdk.core.d {
    public static void a(AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo, JSONObject jSONObject) {
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

    public static JSONObject b(AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = merchantLiveReservationInfo.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "title", merchantLiveReservationInfo.title);
        }
        String str2 = merchantLiveReservationInfo.userHeadUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "userHeadUrl", merchantLiveReservationInfo.userHeadUrl);
        }
        int i = merchantLiveReservationInfo.bookUserCount;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "bookUserCount", i);
        }
        String str3 = merchantLiveReservationInfo.liveStartTime;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "liveStartTime", merchantLiveReservationInfo.liveStartTime);
        }
        boolean z = merchantLiveReservationInfo.displayWeakCard;
        if (z) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "displayWeakCard", z);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "bookUserUrlList", merchantLiveReservationInfo.bookUserUrlList);
        boolean z2 = merchantLiveReservationInfo.displayBookCount;
        if (z2) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "displayBookCount", z2);
        }
        com.kwad.sdk.utils.r.a(jSONObject, "playEndCard", merchantLiveReservationInfo.playEndCard);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.MerchantLiveReservationInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.MerchantLiveReservationInfo) bVar, jSONObject);
    }
}
