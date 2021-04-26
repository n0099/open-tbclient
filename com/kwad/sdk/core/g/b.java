package com.kwad.sdk.core.g;

import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.o;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.core.network.d {
    public b() {
        JSONArray jSONArray = new JSONArray();
        o.a(jSONArray, new JSONObject());
        a("impInfo", jSONArray);
        b("appTag", af.c(KsAdSDKImpl.get().getContext()));
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.d();
    }

    @Override // com.kwad.sdk.core.network.d
    public boolean g() {
        return true;
    }
}
