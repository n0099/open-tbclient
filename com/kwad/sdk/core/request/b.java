package com.kwad.sdk.core.request;

import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.t;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.core.network.d {
    public b() {
        JSONArray jSONArray = new JSONArray();
        t.a(jSONArray, new JSONObject());
        a("impInfo", jSONArray);
        b("appTag", as.d(KsAdSDKImpl.get().getContext()));
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.e();
    }

    @Override // com.kwad.sdk.core.network.d
    public boolean j() {
        return true;
    }
}
