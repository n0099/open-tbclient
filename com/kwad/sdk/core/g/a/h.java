package com.kwad.sdk.core.g.a;

import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.crash.utils.AbiUtil;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.o;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public int f34282a;

    /* renamed from: b  reason: collision with root package name */
    public String f34283b;

    /* renamed from: c  reason: collision with root package name */
    public int f34284c;

    /* renamed from: d  reason: collision with root package name */
    public Long f34285d;

    /* renamed from: e  reason: collision with root package name */
    public Long f34286e;

    /* renamed from: f  reason: collision with root package name */
    public Long f34287f;

    /* renamed from: g  reason: collision with root package name */
    public Long f34288g;

    /* renamed from: h  reason: collision with root package name */
    public String f34289h;

    /* renamed from: i  reason: collision with root package name */
    public String f34290i;
    public List<a> j = new ArrayList();

    public static h a() {
        h hVar = new h();
        hVar.f34282a = ah.c();
        hVar.f34283b = AbiUtil.a();
        hVar.f34284c = ah.a(KsAdSDKImpl.get().getContext());
        hVar.f34285d = Long.valueOf(ah.b(KsAdSDKImpl.get().getContext()));
        hVar.f34286e = Long.valueOf(ah.c(KsAdSDKImpl.get().getContext()));
        hVar.f34287f = Long.valueOf(ah.a());
        hVar.f34288g = Long.valueOf(ah.b());
        hVar.f34289h = ah.e(KsAdSDKImpl.get().getContext());
        hVar.f34290i = ah.f(KsAdSDKImpl.get().getContext());
        hVar.j = at.a(KsAdSDKImpl.get().getContext(), 15);
        return hVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "cpuCount", this.f34282a);
        o.a(jSONObject, "cpuAbi", this.f34283b);
        o.a(jSONObject, "batteryPercent", this.f34284c);
        o.a(jSONObject, "totalMemorySize", this.f34285d.longValue());
        o.a(jSONObject, "availableMemorySize", this.f34286e.longValue());
        o.a(jSONObject, "totalDiskSize", this.f34287f.longValue());
        o.a(jSONObject, "availableDiskSize", this.f34288g.longValue());
        o.a(jSONObject, BaseStatisContent.IMSI, this.f34289h);
        o.a(jSONObject, "iccid", this.f34290i);
        o.a(jSONObject, "wifiList", this.j);
        return jSONObject;
    }
}
