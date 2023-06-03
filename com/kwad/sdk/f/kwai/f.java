package com.kwad.sdk.f.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class f extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public int amE = -1;
    public int amF = -1;

    private void a(f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.amE = jSONObject.optInt("phoneCount", -1);
        fVar.amF = jSONObject.optInt("activePhoneCount", -1);
        super.afterToJson(jSONObject);
    }

    public static JSONObject b(f fVar, JSONObject jSONObject) {
        r.putValue(jSONObject, "phoneCount", fVar.amE);
        r.putValue(jSONObject, "activePhoneCount", fVar.amF);
        return jSONObject;
    }

    public static synchronized f yT() {
        synchronized (f.class) {
            if (((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).lx()) {
                return at.yT();
            }
            return null;
        }
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
