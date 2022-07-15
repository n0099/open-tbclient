package com.kwad.sdk.core.webview.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.components.c;
import com.kwad.sdk.components.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.d;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.j;
/* loaded from: classes5.dex */
public final class a implements com.kwad.sdk.core.webview.kwai.a {

    @KsJson
    /* renamed from: com.kwad.sdk.core.webview.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0549a extends com.kwad.sdk.core.response.kwai.a {
        public String A;
        public String B;
        public int C;
        public int D;
        public String a;
        public int b;
        public String c;
        public String d;
        public int e;
        public int f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;
        public String n;
        public String o;
        public String p;
        public int q;
        public String r;
        public int s;
        public String t;
        public String u;
        public String v;
        public int w;
        public int x;
        public String y;
        public String z;

        public static C0549a a() {
            C0549a c0549a = new C0549a();
            c0549a.a = BuildConfig.VERSION_NAME;
            c0549a.b = BuildConfig.VERSION_CODE;
            c0549a.c = "4.0.0";
            c0549a.d = ((d) ServiceProvider.a(d.class)).e();
            c0549a.e = ((d) ServiceProvider.a(d.class)).f();
            c0549a.f = 1;
            Context a = ((d) ServiceProvider.a(d.class)).a();
            c0549a.g = j.a(a);
            c0549a.h = ((d) ServiceProvider.a(d.class)).c();
            c0549a.i = ((d) ServiceProvider.a(d.class)).b();
            c0549a.j = "";
            c0549a.k = as.f();
            f fVar = (f) c.a(f.class);
            if (fVar != null) {
                c0549a.l = fVar.a();
            }
            c0549a.m = String.valueOf(ac.f(a));
            c0549a.n = av.n();
            c0549a.o = av.e();
            c0549a.p = av.g();
            c0549a.q = 1;
            c0549a.r = av.q();
            c0549a.s = av.r();
            c0549a.t = av.s();
            c0549a.u = av.d();
            c0549a.v = ao.e();
            c0549a.w = av.k(a);
            c0549a.x = av.l(a);
            c0549a.y = ao.b(a);
            c0549a.z = ao.a();
            c0549a.A = ao.c(a);
            c0549a.B = ao.d(a);
            c0549a.C = com.kwad.sdk.b.kwai.a.a(a);
            c0549a.D = com.kwad.sdk.b.kwai.a.a(a, 50.0f);
            return c0549a;
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String a() {
        return CommonTbJsBridge.GET_DEVICE_INFO;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        cVar.a(C0549a.a());
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void b() {
    }
}
