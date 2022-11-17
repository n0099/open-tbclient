package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.ABParams;
import org.json.JSONObject;
/* loaded from: classes8.dex */
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
        int i = aBParams.videoBlackAreaClick;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "videoBlackAreaClick", i);
        }
        int i2 = aBParams.videoBlackAreaNewStyle;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "videoBlackAreaNewStyle", i2);
        }
        String str = aBParams.drawActionBarTimes;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "drawActionBarTimes", aBParams.drawActionBarTimes);
        }
        int i3 = aBParams.showVideoAtH5;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "showVideoAtH5", i3);
        }
        int i4 = aBParams.playableStyle;
        if (i4 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "playableStyle", i4);
        }
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
