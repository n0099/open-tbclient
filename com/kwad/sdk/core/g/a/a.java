package com.kwad.sdk.core.g.a;

import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public int f34014a;

    /* renamed from: b  reason: collision with root package name */
    public String f34015b;

    /* renamed from: c  reason: collision with root package name */
    public String f34016c;

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "level", this.f34014a);
        o.a(jSONObject, "ssid", this.f34015b);
        o.a(jSONObject, "bssid", this.f34016c);
        return jSONObject;
    }
}
