package com.kwad.sdk.core.b.kwai;

import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class fb implements com.kwad.sdk.core.d<SplashSkipViewModel> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(SplashSkipViewModel splashSkipViewModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashSkipViewModel.needShowMiniWindow = jSONObject.optBoolean("needShowMiniWindow");
        splashSkipViewModel.skipSecond = jSONObject.optInt("skipSecond");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(SplashSkipViewModel splashSkipViewModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "needShowMiniWindow", splashSkipViewModel.needShowMiniWindow);
        com.kwad.sdk.utils.r.a(jSONObject, "skipSecond", splashSkipViewModel.skipSecond);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SplashSkipViewModel splashSkipViewModel, JSONObject jSONObject) {
        a2(splashSkipViewModel, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SplashSkipViewModel splashSkipViewModel, JSONObject jSONObject) {
        return b2(splashSkipViewModel, jSONObject);
    }
}
