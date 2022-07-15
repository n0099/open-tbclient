package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.ABParams;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a implements com.kwad.sdk.core.d<ABParams> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(ABParams aBParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aBParams.videoBlackAreaClick = jSONObject.optInt("videoBlackAreaClick");
        aBParams.videoBlackAreaNewStyle = jSONObject.optInt("videoBlackAreaNewStyle");
        aBParams.drawActionBarTimes = jSONObject.optString("drawActionBarTimes");
        if (jSONObject.opt("drawActionBarTimes") == JSONObject.NULL) {
            aBParams.drawActionBarTimes = "";
        }
        aBParams.showVideoAtH5 = jSONObject.optInt("showVideoAtH5");
        aBParams.playableStyle = jSONObject.optInt("playableStyle");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(ABParams aBParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "videoBlackAreaClick", aBParams.videoBlackAreaClick);
        com.kwad.sdk.utils.r.a(jSONObject, "videoBlackAreaNewStyle", aBParams.videoBlackAreaNewStyle);
        com.kwad.sdk.utils.r.a(jSONObject, "drawActionBarTimes", aBParams.drawActionBarTimes);
        com.kwad.sdk.utils.r.a(jSONObject, "showVideoAtH5", aBParams.showVideoAtH5);
        com.kwad.sdk.utils.r.a(jSONObject, "playableStyle", aBParams.playableStyle);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ABParams aBParams, JSONObject jSONObject) {
        a2(aBParams, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ABParams aBParams, JSONObject jSONObject) {
        return b2(aBParams, jSONObject);
    }
}
