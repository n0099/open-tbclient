package com.kwad.sdk.core.webview.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f33629a;

    /* renamed from: b  reason: collision with root package name */
    public String f33630b;

    /* renamed from: c  reason: collision with root package name */
    public String f33631c;

    public void a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f33629a = jSONObject.optString("action");
        this.f33630b = jSONObject.optString("data");
        this.f33631c = jSONObject.optString("callback");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "action", this.f33629a);
        o.a(jSONObject, "data", this.f33630b);
        o.a(jSONObject, "callback", this.f33631c);
        return jSONObject;
    }
}
