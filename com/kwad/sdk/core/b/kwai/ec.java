package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ec implements com.kwad.sdk.core.d<AdInfo.PlayableStyleInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdInfo.PlayableStyleInfo playableStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        playableStyleInfo.playableOrientation = jSONObject.optInt("playableOrientation");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdInfo.PlayableStyleInfo playableStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "playableOrientation", playableStyleInfo.playableOrientation);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.PlayableStyleInfo playableStyleInfo, JSONObject jSONObject) {
        a2(playableStyleInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.PlayableStyleInfo playableStyleInfo, JSONObject jSONObject) {
        return b2(playableStyleInfo, jSONObject);
    }
}
