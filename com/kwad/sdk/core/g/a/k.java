package com.kwad.sdk.core.g.a;

import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class k implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public h f34397a;

    public static k a() {
        k kVar = new k();
        kVar.f34397a = h.a();
        return kVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "modeInfo", this.f34397a);
        return jSONObject;
    }
}
