package com.kwad.sdk.core.webview.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f32803a;

    /* renamed from: b  reason: collision with root package name */
    public String f32804b;

    /* renamed from: c  reason: collision with root package name */
    public String f32805c;

    public void a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f32803a = jSONObject.optString("action");
        this.f32804b = jSONObject.optString("data");
        this.f32805c = jSONObject.optString("callback");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "action", this.f32803a);
        o.a(jSONObject, "data", this.f32804b);
        o.a(jSONObject, "callback", this.f32805c);
        return jSONObject;
    }
}
