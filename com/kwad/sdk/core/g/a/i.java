package com.kwad.sdk.core.g.a;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.v;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f33953a;

    /* renamed from: b  reason: collision with root package name */
    public String f33954b;

    /* renamed from: c  reason: collision with root package name */
    public int f33955c;

    /* renamed from: d  reason: collision with root package name */
    public int f33956d;

    public static i a() {
        i iVar = new i();
        iVar.f33953a = ah.l();
        iVar.f33954b = ah.k(KsAdSDKImpl.get().getContext());
        iVar.f33955c = v.d(KsAdSDKImpl.get().getContext());
        iVar.f33956d = v.e(KsAdSDKImpl.get().getContext());
        return iVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "ip", this.f33953a);
        o.a(jSONObject, IAdRequestParam.MAC, this.f33954b);
        o.a(jSONObject, "connectionType", this.f33955c);
        o.a(jSONObject, "operatorType", this.f33956d);
        return jSONObject;
    }
}
