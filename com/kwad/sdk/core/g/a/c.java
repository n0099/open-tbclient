package com.kwad.sdk.core.g.a;

import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public int f33926a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f33927b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f33928c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f33929d = 0;

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "contentType", this.f33926a);
        o.a(jSONObject, "allowInsertThirdAd", this.f33927b);
        o.a(jSONObject, "slideType", this.f33928c);
        o.a(jSONObject, "requestCount", this.f33929d);
        return jSONObject;
    }
}
