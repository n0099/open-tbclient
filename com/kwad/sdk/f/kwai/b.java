package com.kwad.sdk.f.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public int amt;
    public int amu;
    public int amv;

    public b(int i, int i2, int i3) {
        this.amt = i;
        this.amu = i2;
        this.amv = i3;
    }

    public static void a(b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.amt = jSONObject.optInt("cellId", -1);
        bVar.amu = jSONObject.optInt("lac", -1);
        bVar.amv = jSONObject.optInt("bsss", -1);
    }

    public static JSONObject b(b bVar, JSONObject jSONObject) {
        r.putValue(jSONObject, "cellId", bVar.amt);
        r.putValue(jSONObject, "lac", bVar.amu);
        r.putValue(jSONObject, "bsss", bVar.amv);
        return jSONObject;
    }

    public static synchronized b yS() {
        synchronized (b.class) {
            if (((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).lz()) {
                return at.yS();
            }
            return null;
        }
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
