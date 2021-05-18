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
    public String f32331a;

    /* renamed from: b  reason: collision with root package name */
    public String f32332b;

    /* renamed from: c  reason: collision with root package name */
    public int f32333c;

    /* renamed from: d  reason: collision with root package name */
    public int f32334d;

    public static i a() {
        i iVar = new i();
        iVar.f32331a = ai.m();
        iVar.f32332b = ai.m(KsAdSDKImpl.get().getContext());
        iVar.f32333c = t.c(KsAdSDKImpl.get().getContext());
        iVar.f32334d = t.d(KsAdSDKImpl.get().getContext());
        return iVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "ip", this.f32331a);
        o.a(jSONObject, IAdRequestParam.MAC, this.f32332b);
        o.a(jSONObject, "connectionType", this.f32333c);
        o.a(jSONObject, "operatorType", this.f32334d);
        return jSONObject;
    }
}
