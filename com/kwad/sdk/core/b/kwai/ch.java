package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ch implements com.kwad.sdk.core.d<AdInfo.FullScreenVideoInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdInfo.FullScreenVideoInfo fullScreenVideoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fullScreenVideoInfo.fullScreenEndCardSwitch = jSONObject.optBoolean("fullScreenEndCardSwitch");
        fullScreenVideoInfo.showLandingPage = jSONObject.optInt("showLandingPage");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdInfo.FullScreenVideoInfo fullScreenVideoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = fullScreenVideoInfo.fullScreenEndCardSwitch;
        if (z) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "fullScreenEndCardSwitch", z);
        }
        int i = fullScreenVideoInfo.showLandingPage;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "showLandingPage", i);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.FullScreenVideoInfo fullScreenVideoInfo, JSONObject jSONObject) {
        a2(fullScreenVideoInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.FullScreenVideoInfo fullScreenVideoInfo, JSONObject jSONObject) {
        return b2(fullScreenVideoInfo, jSONObject);
    }
}
