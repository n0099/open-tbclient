package com.kwad.sdk.core.g.a;

import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public int f34262a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f34263b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f34264c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f34265d = 0;

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "contentType", this.f34262a);
        o.a(jSONObject, "allowInsertThirdAd", this.f34263b);
        o.a(jSONObject, "slideType", this.f34264c);
        o.a(jSONObject, "requestCount", this.f34265d);
        return jSONObject;
    }
}
