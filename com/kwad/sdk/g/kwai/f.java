package com.kwad.sdk.g.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class f extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public int a = -1;
    public int b = -1;

    public static synchronized f a() {
        synchronized (f.class) {
            if (((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a()) {
                return aq.c();
            }
            return null;
        }
    }

    private void a(f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.a = jSONObject.optInt("phoneCount", -1);
        fVar.b = jSONObject.optInt("activePhoneCount", -1);
        super.afterToJson(jSONObject);
    }

    public static JSONObject b(f fVar, JSONObject jSONObject) {
        r.a(jSONObject, "phoneCount", fVar.a);
        r.a(jSONObject, "activePhoneCount", fVar.b);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        a(this, jSONObject);
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject b = b(this, new JSONObject());
        afterToJson(b);
        return b;
    }
}
