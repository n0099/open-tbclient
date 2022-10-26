package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.jshandler.a;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class cj implements com.kwad.sdk.core.d {
    public static void a(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.Le = jSONObject.optInt("playableSrc");
        bVar.Lf = jSONObject.optInt("isPlayAgainScene");
        bVar.Lg = jSONObject.optInt("isMiddleEnd");
        bVar.oQ = jSONObject.optInt("adType");
    }

    public static JSONObject b(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.Le;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "playableSrc", i);
        }
        int i2 = bVar.Lf;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "isPlayAgainScene", i2);
        }
        int i3 = bVar.Lg;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "isMiddleEnd", i3);
        }
        int i4 = bVar.oQ;
        if (i4 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adType", i4);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.b) bVar, jSONObject);
    }
}
