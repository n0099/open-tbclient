package com.kwad.sdk.core.webview.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f35033a;

    /* renamed from: b  reason: collision with root package name */
    public String f35034b;

    /* renamed from: c  reason: collision with root package name */
    public String f35035c;

    public void a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f35033a = jSONObject.optString("action");
        this.f35034b = jSONObject.optString("data");
        this.f35035c = jSONObject.optString("callback");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "action", this.f35033a);
        o.a(jSONObject, "data", this.f35034b);
        o.a(jSONObject, "callback", this.f35035c);
        return jSONObject;
    }
}
