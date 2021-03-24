package com.kwad.sdk.core.g;

import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ae;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.core.network.d {
    public c() {
        JSONArray jSONArray = new JSONArray();
        com.kwad.sdk.utils.o.a(jSONArray, new JSONObject());
        a("impInfo", jSONArray);
        b("appTag", ae.g(KsAdSDKImpl.get().getContext()));
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.e();
    }

    @Override // com.kwad.sdk.core.network.d
    public boolean g() {
        return true;
    }
}
