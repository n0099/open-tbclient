package com.kwad.sdk.core.g.a;

import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public int f32291a;

    /* renamed from: b  reason: collision with root package name */
    public String f32292b;

    /* renamed from: c  reason: collision with root package name */
    public String f32293c;

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "level", this.f32291a);
        o.a(jSONObject, "ssid", this.f32292b);
        o.a(jSONObject, "bssid", this.f32293c);
        return jSONObject;
    }
}
