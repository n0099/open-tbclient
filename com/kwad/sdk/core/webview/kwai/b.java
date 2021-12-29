package com.kwad.sdk.core.webview.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements com.kwad.sdk.core.b {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f58676b;

    /* renamed from: c  reason: collision with root package name */
    public String f58677c;

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.a = jSONObject.optString("action");
        this.f58676b = jSONObject.optString("data");
        this.f58677c = jSONObject.optString("callback");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "action", this.a);
        t.a(jSONObject, "data", this.f58676b);
        t.a(jSONObject, "callback", this.f58677c);
        return jSONObject;
    }
}
