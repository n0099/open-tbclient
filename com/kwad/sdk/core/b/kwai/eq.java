package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class eq implements com.kwad.sdk.core.d<WebCardVideoPositionHandler.VideoPosition> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        videoPosition.leftMarginRation = jSONObject.optDouble("leftMarginRation");
        videoPosition.topMarginRation = jSONObject.optDouble("topMarginRation");
        videoPosition.widthRation = jSONObject.optDouble("widthRation");
        videoPosition.heightWidthRation = jSONObject.optDouble("heightWidthRation");
        videoPosition.leftMargin = jSONObject.optInt("leftMargin");
        videoPosition.topMargin = jSONObject.optInt("topMargin");
        videoPosition.width = jSONObject.optInt("width");
        videoPosition.height = jSONObject.optInt("height");
        videoPosition.borderRadius = jSONObject.optInt("borderRadius");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "leftMarginRation", videoPosition.leftMarginRation);
        com.kwad.sdk.utils.t.a(jSONObject, "topMarginRation", videoPosition.topMarginRation);
        com.kwad.sdk.utils.t.a(jSONObject, "widthRation", videoPosition.widthRation);
        com.kwad.sdk.utils.t.a(jSONObject, "heightWidthRation", videoPosition.heightWidthRation);
        com.kwad.sdk.utils.t.a(jSONObject, "leftMargin", videoPosition.leftMargin);
        com.kwad.sdk.utils.t.a(jSONObject, "topMargin", videoPosition.topMargin);
        com.kwad.sdk.utils.t.a(jSONObject, "width", videoPosition.width);
        com.kwad.sdk.utils.t.a(jSONObject, "height", videoPosition.height);
        com.kwad.sdk.utils.t.a(jSONObject, "borderRadius", videoPosition.borderRadius);
        return jSONObject;
    }
}
