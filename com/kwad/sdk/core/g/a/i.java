package com.kwad.sdk.core.g.a;

import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.v;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f33664a;

    /* renamed from: b  reason: collision with root package name */
    public String f33665b;

    /* renamed from: c  reason: collision with root package name */
    public int f33666c;

    /* renamed from: d  reason: collision with root package name */
    public int f33667d;

    public static i a() {
        i iVar = new i();
        iVar.f33664a = ah.l();
        iVar.f33665b = ah.k(KsAdSDKImpl.get().getContext());
        iVar.f33666c = v.d(KsAdSDKImpl.get().getContext());
        iVar.f33667d = v.e(KsAdSDKImpl.get().getContext());
        return iVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "ip", this.f33664a);
        o.a(jSONObject, "mac", this.f33665b);
        o.a(jSONObject, "connectionType", this.f33666c);
        o.a(jSONObject, "operatorType", this.f33667d);
        return jSONObject;
    }
}
