package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.request.model.StatusInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class fl implements com.kwad.sdk.core.d<StatusInfo.SplashStyleControl> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(StatusInfo.SplashStyleControl splashStyleControl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashStyleControl.disableShake = jSONObject.optBoolean("disableShake");
        splashStyleControl.disableRotate = jSONObject.optBoolean("disableRotate");
        splashStyleControl.disableSlide = jSONObject.optBoolean("disableSlide");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(StatusInfo.SplashStyleControl splashStyleControl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = splashStyleControl.disableShake;
        if (z) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "disableShake", z);
        }
        boolean z2 = splashStyleControl.disableRotate;
        if (z2) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "disableRotate", z2);
        }
        boolean z3 = splashStyleControl.disableSlide;
        if (z3) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "disableSlide", z3);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(StatusInfo.SplashStyleControl splashStyleControl, JSONObject jSONObject) {
        a2(splashStyleControl, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(StatusInfo.SplashStyleControl splashStyleControl, JSONObject jSONObject) {
        return b2(splashStyleControl, jSONObject);
    }
}
