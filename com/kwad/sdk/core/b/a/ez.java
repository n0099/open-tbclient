package com.kwad.sdk.core.b.a;

import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class ez implements com.kwad.sdk.core.d<ImpInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(ImpInfo impInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        impInfo.pageScene = jSONObject.optLong("pageScene");
        impInfo.subPageScene = jSONObject.optLong("subPageScene");
        impInfo.sdkExtraData = jSONObject.optString("sdkExtraData");
        if (JSONObject.NULL.toString().equals(impInfo.sdkExtraData)) {
            impInfo.sdkExtraData = "";
        }
        impInfo.posId = jSONObject.optLong("posId");
        impInfo.entryScene = jSONObject.optLong("entryScene");
        impInfo.adNum = jSONObject.optInt("adNum");
        impInfo.action = jSONObject.optInt("action");
        impInfo.width = jSONObject.optInt("width");
        impInfo.height = jSONObject.optInt("height");
        impInfo.cpmBidFloor = jSONObject.optLong("cpmBidFloor");
        impInfo.adStyle = jSONObject.optInt("adStyle");
        URLPackage uRLPackage = new URLPackage();
        impInfo.urlPackage = uRLPackage;
        uRLPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        impInfo.promoteId = jSONObject.optString("promoteId");
        if (JSONObject.NULL.toString().equals(impInfo.promoteId)) {
            impInfo.promoteId = "";
        }
        impInfo.comment = jSONObject.optString("comment");
        if (JSONObject.NULL.toString().equals(impInfo.comment)) {
            impInfo.comment = "";
        }
        impInfo.backUrl = jSONObject.optString("backUrl");
        if (JSONObject.NULL.toString().equals(impInfo.backUrl)) {
            impInfo.backUrl = "";
        }
        impInfo.userCommRateBuying = jSONObject.optLong("userCommRateBuying");
        impInfo.userCommRateSharing = jSONObject.optLong("userCommRateSharing");
        impInfo.screenOrientation = jSONObject.optInt("screenOrientation");
        impInfo.extraData = jSONObject.optString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
        if (JSONObject.NULL.toString().equals(impInfo.extraData)) {
            impInfo.extraData = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(ImpInfo impInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = impInfo.pageScene;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pageScene", j);
        }
        long j2 = impInfo.subPageScene;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "subPageScene", j2);
        }
        String str = impInfo.sdkExtraData;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkExtraData", impInfo.sdkExtraData);
        }
        long j3 = impInfo.posId;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "posId", j3);
        }
        long j4 = impInfo.entryScene;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "entryScene", j4);
        }
        int i = impInfo.adNum;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adNum", i);
        }
        int i2 = impInfo.action;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "action", i2);
        }
        int i3 = impInfo.width;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "width", i3);
        }
        int i4 = impInfo.height;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", i4);
        }
        long j5 = impInfo.cpmBidFloor;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cpmBidFloor", j5);
        }
        int i5 = impInfo.adStyle;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adStyle", i5);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "urlPackage", impInfo.urlPackage);
        String str2 = impInfo.promoteId;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "promoteId", impInfo.promoteId);
        }
        String str3 = impInfo.comment;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "comment", impInfo.comment);
        }
        String str4 = impInfo.backUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "backUrl", impInfo.backUrl);
        }
        long j6 = impInfo.userCommRateBuying;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "userCommRateBuying", j6);
        }
        long j7 = impInfo.userCommRateSharing;
        if (j7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "userCommRateSharing", j7);
        }
        int i6 = impInfo.screenOrientation;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenOrientation", i6);
        }
        String str5 = impInfo.extraData;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, PrefetchEvent.EVENT_DATA_EXTRA_DATA, impInfo.extraData);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ImpInfo impInfo, JSONObject jSONObject) {
        a2(impInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ImpInfo impInfo, JSONObject jSONObject) {
        return b2(impInfo, jSONObject);
    }
}
