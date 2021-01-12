package com.kwad.sdk.core.webview.a;

import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    private final int f9540a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9541b;

    public e(int i, String str) {
        this.f9540a = i;
        this.f9541b = str;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "result", this.f9540a);
        o.a(jSONObject, "error_msg", this.f9541b);
        return jSONObject;
    }
}
