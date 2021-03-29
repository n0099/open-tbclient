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
    public int f33656a;

    /* renamed from: b  reason: collision with root package name */
    public String f33657b;

    /* renamed from: c  reason: collision with root package name */
    public int f33658c;

    /* renamed from: d  reason: collision with root package name */
    public Long f33659d;

    /* renamed from: e  reason: collision with root package name */
    public Long f33660e;

    /* renamed from: f  reason: collision with root package name */
    public Long f33661f;

    /* renamed from: g  reason: collision with root package name */
    public Long f33662g;

    /* renamed from: h  reason: collision with root package name */
    public String f33663h;
    public String i;
    public List<a> j = new ArrayList();

    public static h a() {
        h hVar = new h();
        hVar.f33656a = ah.c();
        hVar.f33657b = AbiUtil.a();
        hVar.f33658c = ah.a(KsAdSDKImpl.get().getContext());
        hVar.f33659d = Long.valueOf(ah.b(KsAdSDKImpl.get().getContext()));
        hVar.f33660e = Long.valueOf(ah.c(KsAdSDKImpl.get().getContext()));
        hVar.f33661f = Long.valueOf(ah.a());
        hVar.f33662g = Long.valueOf(ah.b());
        hVar.f33663h = ah.e(KsAdSDKImpl.get().getContext());
        hVar.i = ah.f(KsAdSDKImpl.get().getContext());
        hVar.j = at.a(KsAdSDKImpl.get().getContext(), 15);
        return hVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "cpuCount", this.f33656a);
        o.a(jSONObject, "cpuAbi", this.f33657b);
        o.a(jSONObject, "batteryPercent", this.f33658c);
        o.a(jSONObject, "totalMemorySize", this.f33659d.longValue());
        o.a(jSONObject, "availableMemorySize", this.f33660e.longValue());
        o.a(jSONObject, "totalDiskSize", this.f33661f.longValue());
        o.a(jSONObject, "availableDiskSize", this.f33662g.longValue());
        o.a(jSONObject, "imsi", this.f33663h);
        o.a(jSONObject, "iccid", this.i);
        o.a(jSONObject, "wifiList", this.j);
        return jSONObject;
    }
}
