package com.kwad.sdk.core.g.a;

import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public int f9155a;

    /* renamed from: b  reason: collision with root package name */
    public String f9156b;
    public String c;

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "level", this.f9155a);
        o.a(jSONObject, "ssid", this.f9156b);
        o.a(jSONObject, "bssid", this.c);
        return jSONObject;
    }
}
