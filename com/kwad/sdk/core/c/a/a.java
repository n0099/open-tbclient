package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.ABParams;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements com.kwad.sdk.core.c<ABParams> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(ABParams aBParams) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "videoBlackAreaClick", aBParams.videoBlackAreaClick);
        com.kwad.sdk.utils.o.a(jSONObject, "videoBlackAreaNewStyle", aBParams.videoBlackAreaNewStyle);
        com.kwad.sdk.utils.o.a(jSONObject, "drawActionBarTimes", aBParams.drawActionBarTimes);
        com.kwad.sdk.utils.o.a(jSONObject, "showVideoAtH5", aBParams.showVideoAtH5);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(ABParams aBParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aBParams.videoBlackAreaClick = jSONObject.optInt("videoBlackAreaClick");
        aBParams.videoBlackAreaNewStyle = jSONObject.optInt("videoBlackAreaNewStyle");
        aBParams.drawActionBarTimes = jSONObject.optString("drawActionBarTimes");
        aBParams.showVideoAtH5 = jSONObject.optInt("showVideoAtH5");
    }
}
