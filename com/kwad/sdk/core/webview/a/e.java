package com.kwad.sdk.core.webview.a;

import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    private final int f9542a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9543b;

    public e(int i, String str) {
        this.f9542a = i;
        this.f9543b = str;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "result", this.f9542a);
        o.a(jSONObject, "error_msg", this.f9543b);
        return jSONObject;
    }
}
