package com.kwad.sdk.core.g.a;

import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.v;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class i implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f34389a;

    /* renamed from: b  reason: collision with root package name */
    public String f34390b;

    /* renamed from: c  reason: collision with root package name */
    public int f34391c;

    /* renamed from: d  reason: collision with root package name */
    public int f34392d;

    public static i a() {
        i iVar = new i();
        iVar.f34389a = ah.l();
        iVar.f34390b = ah.k(KsAdSDKImpl.get().getContext());
        iVar.f34391c = v.d(KsAdSDKImpl.get().getContext());
        iVar.f34392d = v.e(KsAdSDKImpl.get().getContext());
        return iVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "ip", this.f34389a);
        o.a(jSONObject, "mac", this.f34390b);
        o.a(jSONObject, "connectionType", this.f34391c);
        o.a(jSONObject, "operatorType", this.f34392d);
        return jSONObject;
    }
}
