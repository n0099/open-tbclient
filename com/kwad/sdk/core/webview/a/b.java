package com.kwad.sdk.core.webview.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f34935a;

    /* renamed from: b  reason: collision with root package name */
    public String f34936b;

    /* renamed from: c  reason: collision with root package name */
    public String f34937c;

    public void a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f34935a = jSONObject.optString("action");
        this.f34936b = jSONObject.optString("data");
        this.f34937c = jSONObject.optString("callback");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "action", this.f34935a);
        o.a(jSONObject, "data", this.f34936b);
        o.a(jSONObject, "callback", this.f34937c);
        return jSONObject;
    }
}
