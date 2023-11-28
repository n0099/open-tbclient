package com.kwad.sdk.k.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public int aLi;
    public int aLj;
    public int aLk;

    public b(int i, int i2, int i3) {
        this.aLi = i;
        this.aLj = i2;
        this.aLk = i3;
    }

    public static synchronized b IV() {
        synchronized (b.class) {
            if (!((h) ServiceProvider.get(h.class)).ym()) {
                return null;
            }
            return az.IV();
        }
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        return b(this, new JSONObject());
    }

    public static void a(b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aLi = jSONObject.optInt("cellId", -1);
        bVar.aLj = jSONObject.optInt("lac", -1);
        bVar.aLk = jSONObject.optInt("bsss", -1);
    }

    public static JSONObject b(b bVar, JSONObject jSONObject) {
        t.putValue(jSONObject, "cellId", bVar.aLi);
        t.putValue(jSONObject, "lac", bVar.aLj);
        t.putValue(jSONObject, "bsss", bVar.aLk);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        a(this, jSONObject);
        super.afterParseJson(jSONObject);
    }
}
