package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class bk implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.DetailCommonInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdStyleInfo.PlayDetailInfo.DetailCommonInfo detailCommonInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        detailCommonInfo.middleEndcardShowTime = jSONObject.optInt("middleEndcardShowTime");
        detailCommonInfo.rewardFullClickSwitch = jSONObject.optInt("rewardFullClickSwitch");
        detailCommonInfo.rewardInteractionType = jSONObject.optInt("rewardInteractionType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdStyleInfo.PlayDetailInfo.DetailCommonInfo detailCommonInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = detailCommonInfo.middleEndcardShowTime;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "middleEndcardShowTime", i);
        }
        int i2 = detailCommonInfo.rewardFullClickSwitch;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "rewardFullClickSwitch", i2);
        }
        int i3 = detailCommonInfo.rewardInteractionType;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "rewardInteractionType", i3);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo.DetailCommonInfo detailCommonInfo, JSONObject jSONObject) {
        a2(detailCommonInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo.DetailCommonInfo detailCommonInfo, JSONObject jSONObject) {
        return b2(detailCommonInfo, jSONObject);
    }
}
