package com.kwad.sdk.core.webview.a;

import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    private final int f6322a;
    private final String b;

    public e(int i, String str) {
        this.f6322a = i;
        this.b = str;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "result", this.f6322a);
        o.a(jSONObject, "error_msg", this.b);
        return jSONObject;
    }
}
