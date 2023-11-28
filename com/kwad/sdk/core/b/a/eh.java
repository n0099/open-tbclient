package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.f;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class eh implements com.kwad.sdk.core.d<f.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(f.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.loadType = jSONObject.optInt("loadType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(f.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.loadType;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "loadType", i);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(f.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(f.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
