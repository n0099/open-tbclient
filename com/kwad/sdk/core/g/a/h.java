package com.kwad.sdk.core.g.a;

import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.crash.utils.AbiUtil;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.o;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    private int f9169a;

    /* renamed from: b  reason: collision with root package name */
    private String f9170b;
    private int c;
    private Long d;
    private Long e;
    private Long f;
    private Long g;
    private String h;
    private String i;
    private List<a> j = new ArrayList();

    public static h a() {
        h hVar = new h();
        hVar.f9169a = ah.c();
        hVar.f9170b = AbiUtil.a();
        hVar.c = ah.a(KsAdSDKImpl.get().getContext());
        hVar.d = Long.valueOf(ah.b(KsAdSDKImpl.get().getContext()));
        hVar.e = Long.valueOf(ah.c(KsAdSDKImpl.get().getContext()));
        hVar.f = Long.valueOf(ah.a());
        hVar.g = Long.valueOf(ah.b());
        hVar.h = ah.e(KsAdSDKImpl.get().getContext());
        hVar.i = ah.f(KsAdSDKImpl.get().getContext());
        hVar.j = at.a(KsAdSDKImpl.get().getContext(), 15);
        return hVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "cpuCount", this.f9169a);
        o.a(jSONObject, "cpuAbi", this.f9170b);
        o.a(jSONObject, "batteryPercent", this.c);
        o.a(jSONObject, "totalMemorySize", this.d.longValue());
        o.a(jSONObject, "availableMemorySize", this.e.longValue());
        o.a(jSONObject, "totalDiskSize", this.f.longValue());
        o.a(jSONObject, "availableDiskSize", this.g.longValue());
        o.a(jSONObject, "imsi", this.h);
        o.a(jSONObject, "iccid", this.i);
        o.a(jSONObject, "wifiList", this.j);
        return jSONObject;
    }
}
