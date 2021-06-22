package com.kwad.sdk.core.g.a;

import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public int f34360a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f34361b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f34362c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f34363d = 0;

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "contentType", this.f34360a);
        o.a(jSONObject, "allowInsertThirdAd", this.f34361b);
        o.a(jSONObject, "slideType", this.f34362c);
        o.a(jSONObject, "requestCount", this.f34363d);
        return jSONObject;
    }
}
