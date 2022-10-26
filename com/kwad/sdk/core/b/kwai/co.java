package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.jshandler.q;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class co implements com.kwad.sdk.core.d {
    public static void a(q.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.type = jSONObject.optInt("type");
        aVar.Mh = jSONObject.optInt("playDuration");
    }

    public static JSONObject b(q.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.type;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "type", i);
        }
        int i2 = aVar.Mh;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "playDuration", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((q.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((q.a) bVar, jSONObject);
    }
}
