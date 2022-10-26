package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class de implements com.kwad.sdk.core.d {
    public static void a(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kSAdJSCornerModel.topLeft = jSONObject.optDouble("topLeft");
        kSAdJSCornerModel.topRight = jSONObject.optDouble("topRight");
        kSAdJSCornerModel.bottomRight = jSONObject.optDouble("bottomRight");
        kSAdJSCornerModel.bottomLeft = jSONObject.optDouble("bottomLeft");
    }

    public static JSONObject b(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d = kSAdJSCornerModel.topLeft;
        if (d != 0.0d) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "topLeft", d);
        }
        double d2 = kSAdJSCornerModel.topRight;
        if (d2 != 0.0d) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "topRight", d2);
        }
        double d3 = kSAdJSCornerModel.bottomRight;
        if (d3 != 0.0d) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "bottomRight", d3);
        }
        double d4 = kSAdJSCornerModel.bottomLeft;
        if (d4 != 0.0d) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "bottomLeft", d4);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel) bVar, jSONObject);
    }
}
