package com.kwad.sdk.core.webview.a;

import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public final int f34679a;

    /* renamed from: b  reason: collision with root package name */
    public final String f34680b;

    public e(int i, String str) {
        this.f34679a = i;
        this.f34680b = str;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "result", this.f34679a);
        o.a(jSONObject, "error_msg", this.f34680b);
        return jSONObject;
    }
}
