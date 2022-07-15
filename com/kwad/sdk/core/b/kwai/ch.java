package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.jshandler.a;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ch implements com.kwad.sdk.core.d<a.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.a = jSONObject.optInt("playableSrc");
        bVar.b = jSONObject.optInt("isPlayAgainScene");
        bVar.c = jSONObject.optInt("isMiddleEnd");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "playableSrc", bVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "isPlayAgainScene", bVar.b);
        com.kwad.sdk.utils.r.a(jSONObject, "isMiddleEnd", bVar.c);
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
