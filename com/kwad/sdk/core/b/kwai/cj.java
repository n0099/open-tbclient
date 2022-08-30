package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.jshandler.a;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class cj implements com.kwad.sdk.core.d<a.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.Le = jSONObject.optInt("playableSrc");
        bVar.Lf = jSONObject.optInt("isPlayAgainScene");
        bVar.Lg = jSONObject.optInt("isMiddleEnd");
        bVar.oQ = jSONObject.optInt("adType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(a.b bVar, JSONObject jSONObject) {
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
