package com.kwad.sdk.core.webview.a;

import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public final int f34938a;

    /* renamed from: b  reason: collision with root package name */
    public final String f34939b;

    public e(int i2, String str) {
        this.f34938a = i2;
        this.f34939b = str;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "result", this.f34938a);
        o.a(jSONObject, "error_msg", this.f34939b);
        return jSONObject;
    }
}
