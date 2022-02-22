package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements com.kwad.sdk.core.b {
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f56353b;

    /* renamed from: c  reason: collision with root package name */
    public String f56354c;

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "level", this.a);
        t.a(jSONObject, "ssid", this.f56353b);
        t.a(jSONObject, "bssid", this.f56354c);
        return jSONObject;
    }
}
