package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.request.model.StatusInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class fd implements com.kwad.sdk.core.d<StatusInfo.SplashStyleControl> {
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
        com.kwad.sdk.utils.r.a(jSONObject, "disableShake", splashStyleControl.disableShake);
        com.kwad.sdk.utils.r.a(jSONObject, "disableRotate", splashStyleControl.disableRotate);
        com.kwad.sdk.utils.r.a(jSONObject, "disableSlide", splashStyleControl.disableSlide);
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
