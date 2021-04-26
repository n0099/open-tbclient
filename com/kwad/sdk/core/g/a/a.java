package com.kwad.sdk.core.g.a;

import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public int f33046a;

    /* renamed from: b  reason: collision with root package name */
    public String f33047b;

    /* renamed from: c  reason: collision with root package name */
    public String f33048c;

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "level", this.f33046a);
        o.a(jSONObject, "ssid", this.f33047b);
        o.a(jSONObject, "bssid", this.f33048c);
        return jSONObject;
    }
}
