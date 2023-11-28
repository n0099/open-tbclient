package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.tachikoma.a.x;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class be implements com.kwad.sdk.core.d<x.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(x.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.ZK = jSONObject.optBoolean("hasLoseAudioFocus");
        aVar.ZL = jSONObject.optInt("audioFocusStatus");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(x.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = aVar.ZK;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "hasLoseAudioFocus", z);
        }
        int i = aVar.ZL;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "audioFocusStatus", i);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(x.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(x.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
