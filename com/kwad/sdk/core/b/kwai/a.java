package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.ABParams;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements com.kwad.sdk.core.d<ABParams> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(ABParams aBParams, JSONObject jSONObject) {
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(ABParams aBParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "videoBlackAreaClick", aBParams.videoBlackAreaClick);
        com.kwad.sdk.utils.t.a(jSONObject, "videoBlackAreaNewStyle", aBParams.videoBlackAreaNewStyle);
        com.kwad.sdk.utils.t.a(jSONObject, "drawActionBarTimes", aBParams.drawActionBarTimes);
        com.kwad.sdk.utils.t.a(jSONObject, "showVideoAtH5", aBParams.showVideoAtH5);
        return jSONObject;
    }
}
