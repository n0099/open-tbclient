package com.kwad.sdk.core.webview.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f implements com.kwad.sdk.core.b {
    public final int a = 1;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.b f56680b;

    public f(com.kwad.sdk.core.b bVar) {
        this.f56680b = bVar;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "result", this.a);
        t.a(jSONObject, "data", this.f56680b);
        return jSONObject;
    }
}
