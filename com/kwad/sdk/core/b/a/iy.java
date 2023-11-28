package com.kwad.sdk.core.b.a;

import com.kwad.sdk.internal.api.SplashExtraDataImpl;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class iy implements com.kwad.sdk.core.d<SplashExtraDataImpl> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(SplashExtraDataImpl splashExtraDataImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashExtraDataImpl.disableShake = jSONObject.optBoolean("disableShake");
        splashExtraDataImpl.disableRotate = jSONObject.optBoolean("disableRotate");
        splashExtraDataImpl.disableSlide = jSONObject.optBoolean("disableSlide");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(SplashExtraDataImpl splashExtraDataImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = splashExtraDataImpl.disableShake;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "disableShake", z);
        }
        boolean z2 = splashExtraDataImpl.disableRotate;
        if (z2) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "disableRotate", z2);
        }
        boolean z3 = splashExtraDataImpl.disableSlide;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "disableSlide", z3);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SplashExtraDataImpl splashExtraDataImpl, JSONObject jSONObject) {
        a2(splashExtraDataImpl, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SplashExtraDataImpl splashExtraDataImpl, JSONObject jSONObject) {
        return b2(splashExtraDataImpl, jSONObject);
    }
}
