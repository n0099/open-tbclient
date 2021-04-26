package com.kwad.sdk.core.webview.a;

import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public final int f33634a = 1;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.b f33635b;

    public f(com.kwad.sdk.core.b bVar) {
        this.f33635b = bVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "result", this.f33634a);
        o.a(jSONObject, "data", this.f33635b);
        return jSONObject;
    }
}
