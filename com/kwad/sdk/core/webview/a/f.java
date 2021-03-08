package com.kwad.sdk.core.webview.a;

import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public final int f6323a = 1;
    public final com.kwad.sdk.core.b b;

    public f(com.kwad.sdk.core.b bVar) {
        this.b = bVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "result", this.f6323a);
        o.a(jSONObject, "data", this.b);
        return jSONObject;
    }
}
