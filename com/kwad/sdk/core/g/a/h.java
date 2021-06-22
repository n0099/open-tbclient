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
/* loaded from: classes7.dex */
public class h implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public int f34380a;

    /* renamed from: b  reason: collision with root package name */
    public String f34381b;

    /* renamed from: c  reason: collision with root package name */
    public int f34382c;

    /* renamed from: d  reason: collision with root package name */
    public Long f34383d;

    /* renamed from: e  reason: collision with root package name */
    public Long f34384e;

    /* renamed from: f  reason: collision with root package name */
    public Long f34385f;

    /* renamed from: g  reason: collision with root package name */
    public Long f34386g;

    /* renamed from: h  reason: collision with root package name */
    public String f34387h;

    /* renamed from: i  reason: collision with root package name */
    public String f34388i;
    public List<a> j = new ArrayList();

    public static h a() {
        h hVar = new h();
        hVar.f34380a = ah.c();
        hVar.f34381b = AbiUtil.a();
        hVar.f34382c = ah.a(KsAdSDKImpl.get().getContext());
        hVar.f34383d = Long.valueOf(ah.b(KsAdSDKImpl.get().getContext()));
        hVar.f34384e = Long.valueOf(ah.c(KsAdSDKImpl.get().getContext()));
        hVar.f34385f = Long.valueOf(ah.a());
        hVar.f34386g = Long.valueOf(ah.b());
        hVar.f34387h = ah.e(KsAdSDKImpl.get().getContext());
        hVar.f34388i = ah.f(KsAdSDKImpl.get().getContext());
        hVar.j = at.a(KsAdSDKImpl.get().getContext(), 15);
        return hVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "cpuCount", this.f34380a);
        o.a(jSONObject, "cpuAbi", this.f34381b);
        o.a(jSONObject, "batteryPercent", this.f34382c);
        o.a(jSONObject, "totalMemorySize", this.f34383d.longValue());
        o.a(jSONObject, "availableMemorySize", this.f34384e.longValue());
        o.a(jSONObject, "totalDiskSize", this.f34385f.longValue());
        o.a(jSONObject, "availableDiskSize", this.f34386g.longValue());
        o.a(jSONObject, BaseStatisContent.IMSI, this.f34387h);
        o.a(jSONObject, "iccid", this.f34388i);
        o.a(jSONObject, "wifiList", this.j);
        return jSONObject;
    }
}
