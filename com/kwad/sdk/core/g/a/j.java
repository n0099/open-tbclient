package com.kwad.sdk.core.g.a;

import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public h f33090a;

    public static j a() {
        j jVar = new j();
        jVar.f33090a = h.a();
        return jVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "modeInfo", this.f33090a);
        return jSONObject;
    }
}
