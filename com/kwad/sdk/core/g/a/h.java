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
    public int f34040a;

    /* renamed from: b  reason: collision with root package name */
    public String f34041b;

    /* renamed from: c  reason: collision with root package name */
    public int f34042c;

    /* renamed from: d  reason: collision with root package name */
    public Long f34043d;

    /* renamed from: e  reason: collision with root package name */
    public Long f34044e;

    /* renamed from: f  reason: collision with root package name */
    public Long f34045f;

    /* renamed from: g  reason: collision with root package name */
    public Long f34046g;

    /* renamed from: h  reason: collision with root package name */
    public String f34047h;
    public String i;
    public List<a> j = new ArrayList();

    public static h a() {
        h hVar = new h();
        hVar.f34040a = ah.c();
        hVar.f34041b = AbiUtil.a();
        hVar.f34042c = ah.a(KsAdSDKImpl.get().getContext());
        hVar.f34043d = Long.valueOf(ah.b(KsAdSDKImpl.get().getContext()));
        hVar.f34044e = Long.valueOf(ah.c(KsAdSDKImpl.get().getContext()));
        hVar.f34045f = Long.valueOf(ah.a());
        hVar.f34046g = Long.valueOf(ah.b());
        hVar.f34047h = ah.e(KsAdSDKImpl.get().getContext());
        hVar.i = ah.f(KsAdSDKImpl.get().getContext());
        hVar.j = at.a(KsAdSDKImpl.get().getContext(), 15);
        return hVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "cpuCount", this.f34040a);
        o.a(jSONObject, "cpuAbi", this.f34041b);
        o.a(jSONObject, "batteryPercent", this.f34042c);
        o.a(jSONObject, "totalMemorySize", this.f34043d.longValue());
        o.a(jSONObject, "availableMemorySize", this.f34044e.longValue());
        o.a(jSONObject, "totalDiskSize", this.f34045f.longValue());
        o.a(jSONObject, "availableDiskSize", this.f34046g.longValue());
        o.a(jSONObject, "imsi", this.f34047h);
        o.a(jSONObject, "iccid", this.i);
        o.a(jSONObject, "wifiList", this.j);
        return jSONObject;
    }
}
