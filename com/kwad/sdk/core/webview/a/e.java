package com.kwad.sdk.core.webview.a;

import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public final int f35036a;

    /* renamed from: b  reason: collision with root package name */
    public final String f35037b;

    public e(int i2, String str) {
        this.f35036a = i2;
        this.f35037b = str;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "result", this.f35036a);
        o.a(jSONObject, "error_msg", this.f35037b);
        return jSONObject;
    }
}
