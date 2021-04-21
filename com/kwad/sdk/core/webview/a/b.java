package com.kwad.sdk.core.webview.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f34676a;

    /* renamed from: b  reason: collision with root package name */
    public String f34677b;

    /* renamed from: c  reason: collision with root package name */
    public String f34678c;

    public void a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f34676a = jSONObject.optString("action");
        this.f34677b = jSONObject.optString("data");
        this.f34678c = jSONObject.optString("callback");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "action", this.f34676a);
        o.a(jSONObject, "data", this.f34677b);
        o.a(jSONObject, "callback", this.f34678c);
        return jSONObject;
    }
}
