package com.kwad.sdk.core.request.model;

import android.os.Build;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.av;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class d extends com.kwad.sdk.core.response.kwai.a {
    public String A;
    public String B;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f56195b;

    /* renamed from: c  reason: collision with root package name */
    public String f56196c;

    /* renamed from: d  reason: collision with root package name */
    public String f56197d;

    /* renamed from: e  reason: collision with root package name */
    public String f56198e;

    /* renamed from: f  reason: collision with root package name */
    public String f56199f;

    /* renamed from: g  reason: collision with root package name */
    public String f56200g;

    /* renamed from: h  reason: collision with root package name */
    public int f56201h;

    /* renamed from: i  reason: collision with root package name */
    public int f56202i;

    /* renamed from: j  reason: collision with root package name */
    public String f56203j;
    public String k;
    public int l;
    public int m;
    public int n;
    public int o;
    public String p;
    public String q;
    public String r;
    public int s;
    public String t;
    public String u;
    public String v;
    public String w;
    public JSONArray x;
    public String y;
    public int z = 0;
    public long C = 0;

    public static d a() {
        d dVar = new d();
        dVar.f56198e = com.kwad.sdk.core.f.a.a();
        dVar.q = av.u();
        dVar.t = av.e();
        dVar.f56201h = 1;
        dVar.f56202i = av.r();
        dVar.f56203j = av.q();
        dVar.w = com.kwad.sdk.core.a.e.a();
        dVar.v = com.kwad.sdk.core.a.e.b();
        return dVar;
    }

    public static d a(boolean z) {
        return a(z, 0);
    }

    public static d a(boolean z, int i2) {
        d dVar = new d();
        dVar.a = av.d(KsAdSDKImpl.get().getContext());
        String[] g2 = av.g(KsAdSDKImpl.get().getContext());
        dVar.f56195b = g2[0];
        dVar.f56196c = g2[1];
        dVar.f56197d = av.f(KsAdSDKImpl.get().getContext());
        dVar.f56198e = com.kwad.sdk.core.f.a.a();
        dVar.t = av.e();
        dVar.u = av.g();
        dVar.f56201h = 1;
        dVar.f56202i = av.r();
        dVar.f56203j = av.q();
        dVar.k = av.s();
        dVar.m = av.o(KsAdSDKImpl.get().getContext());
        dVar.l = av.n(KsAdSDKImpl.get().getContext());
        dVar.n = av.p(KsAdSDKImpl.get().getContext());
        dVar.o = av.q(KsAdSDKImpl.get().getContext());
        dVar.p = av.t(KsAdSDKImpl.get().getContext());
        if (z) {
            dVar.x = InstalledAppInfoManager.a(KsAdSDKImpl.get().getContext());
        }
        dVar.q = av.u();
        dVar.C = av.f();
        dVar.r = av.n();
        dVar.w = com.kwad.sdk.core.a.e.a();
        dVar.v = com.kwad.sdk.core.a.e.b();
        dVar.s = av.o();
        StringBuilder sb = new StringBuilder();
        sb.append("DeviceInfo i=");
        sb.append(KsAdSDKImpl.get().getAppId());
        sb.append(",n=");
        sb.append(KsAdSDKImpl.get().getAppName());
        sb.append(",external:");
        sb.append(KsAdSDKImpl.get().getIsExternal());
        sb.append(",v1:");
        sb.append(KsAdSDKImpl.get().getApiVersion());
        sb.append(",v2:");
        sb.append("3.3.17.4");
        sb.append(",d:");
        sb.append(dVar.q);
        sb.append(",dh:");
        String str = dVar.q;
        sb.append(str != null ? Integer.valueOf(str.hashCode()) : "");
        sb.append(",o:");
        sb.append(dVar.f56198e);
        com.kwad.sdk.core.d.a.a(sb.toString());
        dVar.y = av.p();
        dVar.z = i2;
        if (com.kwad.sdk.core.config.b.ar()) {
            dVar.A = av.b(KsAdSDKImpl.get().getContext(), "com.smile.gifmaker");
            dVar.B = av.b(KsAdSDKImpl.get().getContext(), "com.kuaishou.nebula");
        }
        dVar.f56199f = Build.BRAND;
        dVar.f56200g = com.kwad.sdk.core.download.a.g.a(KsAdSDKImpl.get().getContext());
        return dVar;
    }
}
