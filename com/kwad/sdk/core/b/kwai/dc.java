package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.jshandler.ag;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class dc implements com.kwad.sdk.core.d<ag.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(ag.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.gJ = jSONObject.optInt("itemClickType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(ag.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.gJ;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "itemClickType", i);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ag.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ag.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
