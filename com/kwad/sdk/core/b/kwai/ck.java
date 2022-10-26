package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ck implements com.kwad.sdk.core.d {
    public static void a(AdInfo.H5Config h5Config, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        h5Config.apiMisTouch = jSONObject.optInt("apiMisTouch");
        h5Config.apiAdTag = jSONObject.optInt("apiAdTag");
        h5Config.apiBreathLamp = jSONObject.optInt("apiBreathLamp");
        h5Config.tagTip = jSONObject.optString("tagTip");
        if (jSONObject.opt("tagTip") == JSONObject.NULL) {
            h5Config.tagTip = "";
        }
    }

    public static JSONObject b(AdInfo.H5Config h5Config, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = h5Config.apiMisTouch;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "apiMisTouch", i);
        }
        int i2 = h5Config.apiAdTag;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "apiAdTag", i2);
        }
        int i3 = h5Config.apiBreathLamp;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "apiBreathLamp", i3);
        }
        String str = h5Config.tagTip;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "tagTip", h5Config.tagTip);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.H5Config) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.H5Config) bVar, jSONObject);
    }
}
