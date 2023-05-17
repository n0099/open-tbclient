package com.kwad.components.core.k;

import com.kwad.sdk.utils.r;
import com.kwad.sdk.utils.w;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class d extends com.kwad.sdk.core.network.d {
    public d() {
        JSONArray jSONArray = new JSONArray();
        r.putValue(jSONArray, new JSONObject());
        putBody("impInfo", jSONArray);
        putBody("appTag", w.zD());
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return com.kwad.sdk.b.qP();
    }

    @Override // com.kwad.sdk.core.network.d
    public final boolean isAddAppPackageNameParam() {
        return true;
    }
}
