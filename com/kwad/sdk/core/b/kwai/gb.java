package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class gb implements com.kwad.sdk.core.d<WebCardVideoPositionHandler.VideoPosition> {
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
        double d = videoPosition.leftMarginRation;
        if (d != 0.0d) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "leftMarginRation", d);
        }
        double d2 = videoPosition.topMarginRation;
        if (d2 != 0.0d) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "topMarginRation", d2);
        }
        double d3 = videoPosition.widthRation;
        if (d3 != 0.0d) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "widthRation", d3);
        }
        double d4 = videoPosition.heightWidthRation;
        if (d4 != 0.0d) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "heightWidthRation", d4);
        }
        int i = videoPosition.leftMargin;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "leftMargin", i);
        }
        int i2 = videoPosition.topMargin;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "topMargin", i2);
        }
        int i3 = videoPosition.width;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "width", i3);
        }
        int i4 = videoPosition.height;
        if (i4 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "height", i4);
        }
        int i5 = videoPosition.borderRadius;
        if (i5 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "borderRadius", i5);
        }
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
