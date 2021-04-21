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
    public String f34048a;

    /* renamed from: b  reason: collision with root package name */
    public String f34049b;

    /* renamed from: c  reason: collision with root package name */
    public int f34050c;

    /* renamed from: d  reason: collision with root package name */
    public int f34051d;

    public static i a() {
        i iVar = new i();
        iVar.f34048a = ah.l();
        iVar.f34049b = ah.k(KsAdSDKImpl.get().getContext());
        iVar.f34050c = v.d(KsAdSDKImpl.get().getContext());
        iVar.f34051d = v.e(KsAdSDKImpl.get().getContext());
        return iVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "ip", this.f34048a);
        o.a(jSONObject, IAdRequestParam.MAC, this.f34049b);
        o.a(jSONObject, "connectionType", this.f34050c);
        o.a(jSONObject, "operatorType", this.f34051d);
        return jSONObject;
    }
}
