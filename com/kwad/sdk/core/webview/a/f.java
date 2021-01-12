package com.kwad.sdk.core.webview.a;

import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public final int f9542a = 1;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.b f9543b;

    public f(com.kwad.sdk.core.b bVar) {
        this.f9543b = bVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "result", this.f9542a);
        o.a(jSONObject, "data", this.f9543b);
        return jSONObject;
    }
}
