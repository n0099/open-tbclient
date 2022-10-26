package com.kwad.sdk.core.b.kwai;

import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class fj implements com.kwad.sdk.core.d {
    public static void a(SplashSkipViewModel splashSkipViewModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashSkipViewModel.needShowMiniWindow = jSONObject.optBoolean("needShowMiniWindow");
        splashSkipViewModel.skipSecond = jSONObject.optInt("skipSecond");
    }

    public static JSONObject b(SplashSkipViewModel splashSkipViewModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = splashSkipViewModel.needShowMiniWindow;
        if (z) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "needShowMiniWindow", z);
        }
        int i = splashSkipViewModel.skipSecond;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "skipSecond", i);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((SplashSkipViewModel) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((SplashSkipViewModel) bVar, jSONObject);
    }
}
