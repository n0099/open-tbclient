package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class br implements com.kwad.sdk.core.c<WebCardVideoPositionHandler.VideoPosition> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        videoPosition.leftMarginRation = jSONObject.optDouble("leftMarginRation");
        videoPosition.topMarginRation = jSONObject.optDouble("topMarginRation");
        videoPosition.widthRation = jSONObject.optDouble("widthRation");
        videoPosition.heightWidthRation = jSONObject.optDouble("heightWidthRation");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "leftMarginRation", videoPosition.leftMarginRation);
        com.kwad.sdk.utils.o.a(jSONObject, "topMarginRation", videoPosition.topMarginRation);
        com.kwad.sdk.utils.o.a(jSONObject, "widthRation", videoPosition.widthRation);
        com.kwad.sdk.utils.o.a(jSONObject, "heightWidthRation", videoPosition.heightWidthRation);
        return jSONObject;
    }
}
