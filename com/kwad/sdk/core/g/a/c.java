package com.kwad.sdk.core.g.a;

import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public int f34021a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f34022b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f34023c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f34024d = 0;

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "contentType", this.f34021a);
        o.a(jSONObject, "allowInsertThirdAd", this.f34022b);
        o.a(jSONObject, "slideType", this.f34023c);
        o.a(jSONObject, "requestCount", this.f34024d);
        return jSONObject;
    }
}
