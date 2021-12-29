package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.av;
/* loaded from: classes3.dex */
public class e implements com.kwad.sdk.core.webview.kwai.a {

    /* loaded from: classes3.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public String A;
        public int B;
        public int C;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public int f58576b;

        /* renamed from: c  reason: collision with root package name */
        public String f58577c;

        /* renamed from: d  reason: collision with root package name */
        public int f58578d;

        /* renamed from: e  reason: collision with root package name */
        public int f58579e;

        /* renamed from: f  reason: collision with root package name */
        public String f58580f;

        /* renamed from: g  reason: collision with root package name */
        public String f58581g;

        /* renamed from: h  reason: collision with root package name */
        public String f58582h;

        /* renamed from: i  reason: collision with root package name */
        public String f58583i;

        /* renamed from: j  reason: collision with root package name */
        public String f58584j;

        /* renamed from: k  reason: collision with root package name */
        public String f58585k;
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
            aVar.f58576b = 3031704;
            aVar.f58577c = KsAdSDKImpl.get().getApiVersion();
            aVar.f58578d = KsAdSDKImpl.get().getApiVersionCode();
            aVar.f58579e = KsAdSDKImpl.get().getSDKType();
            aVar.f58580f = av.w(KsAdSDKImpl.get().getContext());
            aVar.f58581g = KsAdSDKImpl.get().getAppName();
            aVar.f58582h = KsAdSDKImpl.get().getAppId();
            aVar.f58583i = "";
            aVar.f58584j = com.kwad.sdk.core.a.e.a();
            aVar.f58585k = com.kwad.sdk.core.a.e.b();
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
