package com.kwad.sdk.core.g.a;

import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.v;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f33663a;

    /* renamed from: b  reason: collision with root package name */
    public String f33664b;

    /* renamed from: c  reason: collision with root package name */
    public int f33665c;

    /* renamed from: d  reason: collision with root package name */
    public int f33666d;

    public static i a() {
        i iVar = new i();
        iVar.f33663a = ah.l();
        iVar.f33664b = ah.k(KsAdSDKImpl.get().getContext());
        iVar.f33665c = v.d(KsAdSDKImpl.get().getContext());
        iVar.f33666d = v.e(KsAdSDKImpl.get().getContext());
        return iVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "ip", this.f33663a);
        o.a(jSONObject, "mac", this.f33664b);
        o.a(jSONObject, "connectionType", this.f33665c);
        o.a(jSONObject, "operatorType", this.f33666d);
        return jSONObject;
    }
}
