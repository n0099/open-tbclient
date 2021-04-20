package com.kwad.sdk.core.g.a;

import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.crash.utils.AbiUtil;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.o;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public int f33945a;

    /* renamed from: b  reason: collision with root package name */
    public String f33946b;

    /* renamed from: c  reason: collision with root package name */
    public int f33947c;

    /* renamed from: d  reason: collision with root package name */
    public Long f33948d;

    /* renamed from: e  reason: collision with root package name */
    public Long f33949e;

    /* renamed from: f  reason: collision with root package name */
    public Long f33950f;

    /* renamed from: g  reason: collision with root package name */
    public Long f33951g;

    /* renamed from: h  reason: collision with root package name */
    public String f33952h;
    public String i;
    public List<a> j = new ArrayList();

    public static h a() {
        h hVar = new h();
        hVar.f33945a = ah.c();
        hVar.f33946b = AbiUtil.a();
        hVar.f33947c = ah.a(KsAdSDKImpl.get().getContext());
        hVar.f33948d = Long.valueOf(ah.b(KsAdSDKImpl.get().getContext()));
        hVar.f33949e = Long.valueOf(ah.c(KsAdSDKImpl.get().getContext()));
        hVar.f33950f = Long.valueOf(ah.a());
        hVar.f33951g = Long.valueOf(ah.b());
        hVar.f33952h = ah.e(KsAdSDKImpl.get().getContext());
        hVar.i = ah.f(KsAdSDKImpl.get().getContext());
        hVar.j = at.a(KsAdSDKImpl.get().getContext(), 15);
        return hVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "cpuCount", this.f33945a);
        o.a(jSONObject, "cpuAbi", this.f33946b);
        o.a(jSONObject, "batteryPercent", this.f33947c);
        o.a(jSONObject, "totalMemorySize", this.f33948d.longValue());
        o.a(jSONObject, "availableMemorySize", this.f33949e.longValue());
        o.a(jSONObject, "totalDiskSize", this.f33950f.longValue());
        o.a(jSONObject, "availableDiskSize", this.f33951g.longValue());
        o.a(jSONObject, "imsi", this.f33952h);
        o.a(jSONObject, "iccid", this.i);
        o.a(jSONObject, "wifiList", this.j);
        return jSONObject;
    }
}
