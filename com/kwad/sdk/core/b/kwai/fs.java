package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class fs implements com.kwad.sdk.core.d<WebCardVideoPositionHandler.VideoPosition> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
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

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "leftMarginRation", videoPosition.leftMarginRation);
        com.kwad.sdk.utils.r.a(jSONObject, "topMarginRation", videoPosition.topMarginRation);
        com.kwad.sdk.utils.r.a(jSONObject, "widthRation", videoPosition.widthRation);
        com.kwad.sdk.utils.r.a(jSONObject, "heightWidthRation", videoPosition.heightWidthRation);
        com.kwad.sdk.utils.r.a(jSONObject, "leftMargin", videoPosition.leftMargin);
        com.kwad.sdk.utils.r.a(jSONObject, "topMargin", videoPosition.topMargin);
        com.kwad.sdk.utils.r.a(jSONObject, "width", videoPosition.width);
        com.kwad.sdk.utils.r.a(jSONObject, "height", videoPosition.height);
        com.kwad.sdk.utils.r.a(jSONObject, "borderRadius", videoPosition.borderRadius);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        a2(videoPosition, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        return b2(videoPosition, jSONObject);
    }
}
