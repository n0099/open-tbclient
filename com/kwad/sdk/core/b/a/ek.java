package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.h;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class ek implements com.kwad.sdk.core.d<h.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(h.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.VL = jSONObject.optInt("playableSrc");
        bVar.VM = jSONObject.optInt("isMiddleEnd");
        bVar.LX = jSONObject.optInt("adType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(h.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.VL;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playableSrc", i);
        }
        int i2 = bVar.VM;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isMiddleEnd", i2);
        }
        int i3 = bVar.LX;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adType", i3);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(h.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(h.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
