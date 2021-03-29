package com.kwad.sdk.core.webview.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f34292a;

    /* renamed from: b  reason: collision with root package name */
    public String f34293b;

    /* renamed from: c  reason: collision with root package name */
    public String f34294c;

    public void a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f34292a = jSONObject.optString("action");
        this.f34293b = jSONObject.optString("data");
        this.f34294c = jSONObject.optString("callback");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "action", this.f34292a);
        o.a(jSONObject, "data", this.f34293b);
        o.a(jSONObject, "callback", this.f34294c);
        return jSONObject;
    }
}
