package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.av;
/* loaded from: classes8.dex */
public class e implements com.kwad.sdk.core.webview.kwai.a {

    /* loaded from: classes8.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public String A;
        public int B;
        public int C;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public int f54929b;

        /* renamed from: c  reason: collision with root package name */
        public String f54930c;

        /* renamed from: d  reason: collision with root package name */
        public int f54931d;

        /* renamed from: e  reason: collision with root package name */
        public int f54932e;

        /* renamed from: f  reason: collision with root package name */
        public String f54933f;

        /* renamed from: g  reason: collision with root package name */
        public String f54934g;

        /* renamed from: h  reason: collision with root package name */
        public String f54935h;

        /* renamed from: i  reason: collision with root package name */
        public String f54936i;

        /* renamed from: j  reason: collision with root package name */
        public String f54937j;
        public String k;
        public String l;
        public String m;
        public String n;
        public String o;
        public int p;
        public String q;
        public int r;
        public String s;
        public String t;
        public String u;
        public int v;
        public int w;
        public String x;
        public String y;
        public String z;

        public static a a() {
            a aVar = new a();
            aVar.a = "3.3.17.4";
            aVar.f54929b = 3031704;
            aVar.f54930c = KsAdSDKImpl.get().getApiVersion();
            aVar.f54931d = KsAdSDKImpl.get().getApiVersionCode();
            aVar.f54932e = KsAdSDKImpl.get().getSDKType();
            aVar.f54933f = av.w(KsAdSDKImpl.get().getContext());
            aVar.f54934g = KsAdSDKImpl.get().getAppName();
            aVar.f54935h = KsAdSDKImpl.get().getAppId();
            aVar.f54936i = "";
            aVar.f54937j = com.kwad.sdk.core.a.e.a();
            aVar.k = com.kwad.sdk.core.a.e.b();
            aVar.l = String.valueOf(ad.c(KsAdSDKImpl.get().getContext()));
            aVar.m = av.n();
            aVar.n = av.e();
            aVar.o = av.g();
            aVar.p = 1;
            aVar.q = av.q();
            aVar.r = av.r();
            aVar.s = av.s();
            aVar.t = av.d();
            aVar.u = av.u();
            aVar.v = av.n(KsAdSDKImpl.get().getContext());
            aVar.w = av.o(KsAdSDKImpl.get().getContext());
            aVar.x = av.d(KsAdSDKImpl.get().getContext());
            aVar.y = com.kwad.sdk.core.f.a.a();
            aVar.z = av.t(KsAdSDKImpl.get().getContext());
            aVar.A = av.v(KsAdSDKImpl.get().getContext());
            aVar.B = com.kwad.sdk.a.kwai.a.a(KsAdSDKImpl.get().getContext());
            aVar.C = com.kwad.sdk.a.kwai.a.a(KsAdSDKImpl.get().getContext(), 50.0f);
            return aVar;
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "getDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        cVar.a(a.a());
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
    }
}
