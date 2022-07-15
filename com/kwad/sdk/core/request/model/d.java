package com.kwad.sdk.core.request.model;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class d implements com.kwad.sdk.core.b {
    public String a;
    public int b;
    public int c;

    public static d a() {
        Context a = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a();
        d dVar = new d();
        dVar.a = ao.d(a);
        dVar.b = ac.f(a);
        dVar.c = ac.a(a, ao.g(a));
        return dVar;
    }

    public static d b() {
        d dVar = new d();
        dVar.b = ac.f(((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a());
        return dVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        r.a(jSONObject, "mac", this.a);
        r.a(jSONObject, "connectionType", this.b);
        r.a(jSONObject, "operatorType", this.c);
        return jSONObject;
    }
}
