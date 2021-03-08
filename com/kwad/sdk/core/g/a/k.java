package com.kwad.sdk.core.g.a;

import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    private h f6105a;

    public static k a() {
        k kVar = new k();
        kVar.f6105a = h.a();
        return kVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "modeInfo", this.f6105a);
        return jSONObject;
    }
}
