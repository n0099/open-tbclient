package com.kwad.sdk.core.webview.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f32874a;

    /* renamed from: b  reason: collision with root package name */
    public String f32875b;

    /* renamed from: c  reason: collision with root package name */
    public String f32876c;

    public void a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f32874a = jSONObject.optString("action");
        this.f32875b = jSONObject.optString("data");
        this.f32876c = jSONObject.optString("callback");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "action", this.f32874a);
        o.a(jSONObject, "data", this.f32875b);
        o.a(jSONObject, "callback", this.f32876c);
        return jSONObject;
    }
}
