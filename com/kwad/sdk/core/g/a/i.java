package com.kwad.sdk.core.g.a;

import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.v;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f34291a;

    /* renamed from: b  reason: collision with root package name */
    public String f34292b;

    /* renamed from: c  reason: collision with root package name */
    public int f34293c;

    /* renamed from: d  reason: collision with root package name */
    public int f34294d;

    public static i a() {
        i iVar = new i();
        iVar.f34291a = ah.l();
        iVar.f34292b = ah.k(KsAdSDKImpl.get().getContext());
        iVar.f34293c = v.d(KsAdSDKImpl.get().getContext());
        iVar.f34294d = v.e(KsAdSDKImpl.get().getContext());
        return iVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "ip", this.f34291a);
        o.a(jSONObject, "mac", this.f34292b);
        o.a(jSONObject, "connectionType", this.f34293c);
        o.a(jSONObject, "operatorType", this.f34294d);
        return jSONObject;
    }
}
