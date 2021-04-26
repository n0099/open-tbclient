package com.kwad.sdk.core.webview.a;

import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public final int f33632a;

    /* renamed from: b  reason: collision with root package name */
    public final String f33633b;

    public e(int i2, String str) {
        this.f33632a = i2;
        this.f33633b = str;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "result", this.f33632a);
        o.a(jSONObject, "error_msg", this.f33633b);
        return jSONObject;
    }
}
