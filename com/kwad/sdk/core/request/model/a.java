package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a implements com.kwad.sdk.core.b {
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f54703b;

    /* renamed from: c  reason: collision with root package name */
    public String f54704c;

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "level", this.a);
        t.a(jSONObject, "ssid", this.f54703b);
        t.a(jSONObject, "bssid", this.f54704c);
        return jSONObject;
    }
}
