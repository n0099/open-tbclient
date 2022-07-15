package com.kwad.sdk.core.request.model;

import android.content.Context;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.j;
import org.json.JSONArray;
@KsJson
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.core.response.kwai.a {
    public String B;
    public String C;
    public String D;
    public String F;
    public String G;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public int i;
    public int j;
    public String k;
    public String l;
    public int m;
    public int n;
    public int o;
    public int p;
    public String q;
    public String r;
    public String s;
    public int t;
    public String u;
    public String v;
    public String w;
    public String x;
    public JSONArray y;
    public String z;
    public int A = 0;
    public long E = 0;

    public static b a() {
        b bVar = new b();
        bVar.e = ao.a();
        bVar.r = ao.e();
        bVar.u = av.e();
        bVar.i = 1;
        bVar.j = av.r();
        bVar.k = av.q();
        bVar.x = as.f();
        com.kwad.sdk.components.f fVar = (com.kwad.sdk.components.f) com.kwad.sdk.components.c.a(com.kwad.sdk.components.f.class);
        if (fVar != null) {
            bVar.w = fVar.a();
        }
        return bVar;
    }

    public static b a(boolean z) {
        return a(false, 0);
    }

    public static b a(boolean z, int i) {
        b bVar = new b();
        com.kwad.sdk.service.kwai.d dVar = (com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class);
        Context a = dVar.a();
        bVar.a = ao.b(a);
        bVar.b = ao.e(a);
        bVar.c = ao.f(a);
        bVar.d = av.d(a);
        bVar.e = ao.a();
        bVar.u = av.e();
        bVar.v = av.g();
        bVar.i = 1;
        bVar.j = av.r();
        bVar.k = av.q();
        bVar.l = j.a();
        bVar.n = j.c(a);
        bVar.m = j.b(a);
        bVar.o = j.e(a);
        bVar.p = j.f(a);
        bVar.q = ao.c(a);
        if (z) {
            bVar.y = InstalledAppInfoManager.a(a);
        }
        bVar.r = ao.e();
        bVar.E = av.f();
        bVar.s = av.n();
        bVar.x = as.f();
        com.kwad.sdk.components.f fVar = (com.kwad.sdk.components.f) com.kwad.sdk.components.c.a(com.kwad.sdk.components.f.class);
        if (fVar != null) {
            bVar.w = fVar.a();
        }
        bVar.t = av.o();
        StringBuilder sb = new StringBuilder("DeviceInfo i=");
        sb.append(dVar.b());
        sb.append(",n=");
        sb.append(dVar.c());
        sb.append(",external:");
        sb.append(dVar.d());
        sb.append(",v1:");
        sb.append(dVar.e());
        sb.append(",v2:3.3.24");
        sb.append(",d:");
        sb.append(bVar.r);
        sb.append(",dh:");
        String str = bVar.r;
        sb.append(str != null ? Integer.valueOf(str.hashCode()) : "");
        sb.append(",o:");
        sb.append(bVar.e);
        com.kwad.sdk.core.d.b.a(sb.toString());
        bVar.z = av.p();
        bVar.A = i;
        if (b()) {
            bVar.B = j.a(a, "com.smile.gifmaker");
            bVar.C = j.a(a, "com.kuaishou.nebula");
            bVar.D = j.a(a, "com.tencent.mm");
        }
        bVar.h = av.l();
        bVar.g = aa.a(a);
        bVar.F = av.v();
        bVar.G = av.a("/data/data");
        return bVar;
    }

    public static boolean b() {
        return ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).i();
    }
}
