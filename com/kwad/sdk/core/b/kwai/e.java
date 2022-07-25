package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class e implements com.kwad.sdk.core.d<ActivityInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(ActivityInfo activityInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        activityInfo.actTypeId = jSONObject.optInt("actTypeId");
        activityInfo.sceneTypeId = jSONObject.optInt("sceneTypeId");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(ActivityInfo activityInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = activityInfo.actTypeId;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "actTypeId", i);
        }
        int i2 = activityInfo.sceneTypeId;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "sceneTypeId", i2);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ActivityInfo activityInfo, JSONObject jSONObject) {
        a2(activityInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ActivityInfo activityInfo, JSONObject jSONObject) {
        return b2(activityInfo, jSONObject);
    }
}
