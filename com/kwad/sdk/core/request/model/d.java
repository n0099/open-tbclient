package com.kwad.sdk.core.request.model;

import android.os.Build;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.av;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class d extends com.kwad.sdk.core.response.kwai.a {
    public String A;
    public String B;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public int h;
    public int i;
    public String j;
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
        dVar.e = com.kwad.sdk.core.f.a.a();
        dVar.q = av.u();
        dVar.t = av.e();
        dVar.h = 1;
        dVar.i = av.r();
        dVar.j = av.q();
        dVar.w = com.kwad.sdk.core.a.e.a();
        dVar.v = com.kwad.sdk.core.a.e.b();
        return dVar;
    }

    public static d a(boolean z) {
        return a(z, 0);
    }

    public static d a(boolean z, int i) {
        d dVar = new d();
        dVar.a = av.d(KsAdSDKImpl.get().getContext());
        String[] g = av.g(KsAdSDKImpl.get().getContext());
        dVar.b = g[0];
        dVar.c = g[1];
        dVar.d = av.f(KsAdSDKImpl.get().getContext());
        dVar.e = com.kwad.sdk.core.f.a.a();
        dVar.t = av.e();
        dVar.u = av.g();
        dVar.h = 1;
        dVar.i = av.r();
        dVar.j = av.q();
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
        sb.append(dVar.e);
        com.kwad.sdk.core.d.a.a(sb.toString());
        dVar.y = av.p();
        dVar.z = i;
        if (com.kwad.sdk.core.config.b.ar()) {
            dVar.A = av.b(KsAdSDKImpl.get().getContext(), "com.smile.gifmaker");
            dVar.B = av.b(KsAdSDKImpl.get().getContext(), "com.kuaishou.nebula");
        }
        dVar.f = Build.BRAND;
        dVar.g = com.kwad.sdk.core.download.a.g.a(KsAdSDKImpl.get().getContext());
        return dVar;
    }
}
