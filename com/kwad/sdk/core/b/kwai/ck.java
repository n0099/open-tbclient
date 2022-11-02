package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class ck implements com.kwad.sdk.core.d<AdInfo.H5Config> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdInfo.H5Config h5Config, JSONObject jSONObject) {
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

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdInfo.H5Config h5Config, JSONObject jSONObject) {
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.H5Config h5Config, JSONObject jSONObject) {
        a2(h5Config, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.H5Config h5Config, JSONObject jSONObject) {
        return b2(h5Config, jSONObject);
    }
}
