package com.kwad.sdk.core.webview.a;

import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public final int f32806a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32807b;

    public e(int i2, String str) {
        this.f32806a = i2;
        this.f32807b = str;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "result", this.f32806a);
        o.a(jSONObject, "error_msg", this.f32807b);
        return jSONObject;
    }
}
