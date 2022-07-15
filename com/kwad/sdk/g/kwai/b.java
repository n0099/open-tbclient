package com.kwad.sdk.g.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public int a;
    public int b;
    public int c;

    public b(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public static synchronized b a() {
        synchronized (b.class) {
            if (((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).c()) {
                return aq.a();
            }
            return null;
        }
    }

    public static void a(b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.a = jSONObject.optInt("cellId", -1);
        bVar.b = jSONObject.optInt("lac", -1);
        bVar.c = jSONObject.optInt("bsss", -1);
    }

    public static JSONObject b(b bVar, JSONObject jSONObject) {
        r.a(jSONObject, "cellId", bVar.a);
        r.a(jSONObject, "lac", bVar.b);
        r.a(jSONObject, "bsss", bVar.c);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        a(this, jSONObject);
        super.afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        return b(this, new JSONObject());
    }
}
