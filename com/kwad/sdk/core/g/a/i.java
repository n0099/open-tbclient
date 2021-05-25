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
    public String f32260a;

    /* renamed from: b  reason: collision with root package name */
    public String f32261b;

    /* renamed from: c  reason: collision with root package name */
    public int f32262c;

    /* renamed from: d  reason: collision with root package name */
    public int f32263d;

    public static i a() {
        i iVar = new i();
        iVar.f32260a = ai.m();
        iVar.f32261b = ai.m(KsAdSDKImpl.get().getContext());
        iVar.f32262c = t.c(KsAdSDKImpl.get().getContext());
        iVar.f32263d = t.d(KsAdSDKImpl.get().getContext());
        return iVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "ip", this.f32260a);
        o.a(jSONObject, IAdRequestParam.MAC, this.f32261b);
        o.a(jSONObject, "connectionType", this.f32262c);
        o.a(jSONObject, "operatorType", this.f32263d);
        return jSONObject;
    }
}
