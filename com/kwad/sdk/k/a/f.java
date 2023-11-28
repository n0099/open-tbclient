package com.kwad.sdk.k.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class f extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public int aLt = -1;
    public int aLu = -1;

    public static synchronized f IW() {
        synchronized (f.class) {
            if (!((h) ServiceProvider.get(h.class)).yk()) {
                return null;
            }
            return az.IW();
        }
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject b = b(this, new JSONObject());
        afterToJson(b);
        return b;
    }

    private void a(f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.aLt = jSONObject.optInt("phoneCount", -1);
        fVar.aLu = jSONObject.optInt("activePhoneCount", -1);
        super.afterToJson(jSONObject);
    }

    public static JSONObject b(f fVar, JSONObject jSONObject) {
        t.putValue(jSONObject, "phoneCount", fVar.aLt);
        t.putValue(jSONObject, "activePhoneCount", fVar.aLu);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        a(this, jSONObject);
        afterParseJson(jSONObject);
    }
}
