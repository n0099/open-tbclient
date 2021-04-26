package com.kwad.sdk.core.g.a;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f33086a;

    /* renamed from: b  reason: collision with root package name */
    public String f33087b;

    /* renamed from: c  reason: collision with root package name */
    public int f33088c;

    /* renamed from: d  reason: collision with root package name */
    public int f33089d;

    public static i a() {
        i iVar = new i();
        iVar.f33086a = ai.m();
        iVar.f33087b = ai.m(KsAdSDKImpl.get().getContext());
        iVar.f33088c = t.c(KsAdSDKImpl.get().getContext());
        iVar.f33089d = t.d(KsAdSDKImpl.get().getContext());
        return iVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "ip", this.f33086a);
        o.a(jSONObject, IAdRequestParam.MAC, this.f33087b);
        o.a(jSONObject, "connectionType", this.f33088c);
        o.a(jSONObject, "operatorType", this.f33089d);
        return jSONObject;
    }
}
