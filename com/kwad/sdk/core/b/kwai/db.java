package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.jshandler.v;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class db implements com.kwad.sdk.core.d<v.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(v.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.MD = jSONObject.optDouble("progress");
        bVar.status = jSONObject.optInt("status");
        bVar.totalBytes = jSONObject.optLong("totalBytes");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(v.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d = bVar.MD;
        if (d != 0.0d) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "progress", d);
        }
        int i = bVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "status", i);
        }
        long j = bVar.totalBytes;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "totalBytes", j);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(v.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(v.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
