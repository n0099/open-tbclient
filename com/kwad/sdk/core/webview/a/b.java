package com.kwad.sdk.core.webview.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f34291a;

    /* renamed from: b  reason: collision with root package name */
    public String f34292b;

    /* renamed from: c  reason: collision with root package name */
    public String f34293c;

    public void a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f34291a = jSONObject.optString("action");
        this.f34292b = jSONObject.optString("data");
        this.f34293c = jSONObject.optString("callback");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "action", this.f34291a);
        o.a(jSONObject, "data", this.f34292b);
        o.a(jSONObject, "callback", this.f34293c);
        return jSONObject;
    }
}
