package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class e implements com.kwad.sdk.core.d {
    public static void a(ActivityInfo activityInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        activityInfo.actTypeId = jSONObject.optInt("actTypeId");
        activityInfo.sceneTypeId = jSONObject.optInt("sceneTypeId");
    }

    public static JSONObject b(ActivityInfo activityInfo, JSONObject jSONObject) {
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

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((ActivityInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((ActivityInfo) bVar, jSONObject);
    }
}
