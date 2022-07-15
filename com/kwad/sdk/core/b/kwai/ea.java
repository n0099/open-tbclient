package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.jshandler.j;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ea implements com.kwad.sdk.core.d<j.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(j.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optString("playableExtraData");
        if (jSONObject.opt("playableExtraData") == JSONObject.NULL) {
            aVar.a = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(j.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "playableExtraData", aVar.a);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(j.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(j.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
