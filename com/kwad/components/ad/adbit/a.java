package com.kwad.components.ad.adbit;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.r;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class a {
    @NonNull
    public Map<String, String> aA;
    @NonNull
    public JSONObject az;

    public a(@NonNull JSONObject jSONObject, @NonNull Map<String, String> map) {
        this.az = jSONObject;
        this.aA = map;
    }

    public final String ac() {
        for (String str : this.aA.keySet()) {
            r.putValue(this.az, str, this.aA.get(str));
        }
        return this.az.toString();
    }
}
