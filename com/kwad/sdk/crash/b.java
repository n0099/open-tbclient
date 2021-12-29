package com.kwad.sdk.crash;

import android.content.Context;
/* loaded from: classes3.dex */
public class b {
    public final com.kwad.sdk.crash.model.b a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.a f58715b;

    /* renamed from: c  reason: collision with root package name */
    public final f f58716c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f58717d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f58718e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f58719f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f58720g;

    /* renamed from: h  reason: collision with root package name */
    public final e f58721h;

    /* renamed from: i  reason: collision with root package name */
    public final String f58722i;

    /* renamed from: j  reason: collision with root package name */
    public final String f58723j;

    /* renamed from: k  reason: collision with root package name */
    public final String f58724k;
    public final String l;
    public final String m;
    public final String n;

    /* loaded from: classes3.dex */
    public static class a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f58725b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f58726c = false;

        /* renamed from: d  reason: collision with root package name */
        public Context f58727d;

        /* renamed from: e  reason: collision with root package name */
        public e f58728e;

        /* renamed from: f  reason: collision with root package name */
        public String f58729f;

        /* renamed from: g  reason: collision with root package name */
        public String f58730g;

        /* renamed from: h  reason: collision with root package name */
        public String f58731h;

        /* renamed from: i  reason: collision with root package name */
        public String f58732i;

        /* renamed from: j  reason: collision with root package name */
        public String f58733j;

        /* renamed from: k  reason: collision with root package name */
        public String f58734k;
        public String l;
        public String m;
        public int n;
        public String o;
        public int p;
        public String q;
        public String r;
        public String s;
        public String t;
        public f u;
        public String[] v;

        public a a(int i2) {
            this.n = i2;
            return this;
        }

        public a a(Context context) {
            this.f58727d = context;
            return this;
        }

        public a a(e eVar) {
            this.f58728e = eVar;
            return this;
        }

        public a a(f fVar) {
            this.u = fVar;
            return this;
        }

        public a a(String str) {
            this.f58729f = str;
            return this;
        }

        public a a(String[] strArr) {
            this.v = strArr;
            return this;
        }

        public b a() {
            return new b(this);
        }

        public a b(int i2) {
            this.p = i2;
            return this;
        }

        public a b(String str) {
            this.f58731h = str;
            return this;
        }

        public a b(String[] strArr) {
            this.f58725b = strArr;
            return this;
        }

        public a c(int i2) {
            this.a = i2;
            return this;
        }

        public a c(String str) {
            this.f58732i = str;
            return this;
        }

        public a d(String str) {
            this.f58734k = str;
            return this;
        }

        public a e(String str) {
            this.l = str;
            return this;
        }

        public a f(String str) {
            this.m = str;
            return this;
        }

        public a g(String str) {
            this.o = str;
            return this;
        }

        public a h(String str) {
            this.q = str;
            return this;
        }

        public a i(String str) {
            this.r = str;
            return this;
        }

        public a j(String str) {
            this.s = str;
            return this;
        }

        public a k(String str) {
            this.t = str;
            return this;
        }
    }

    public b(a aVar) {
        this.a = new com.kwad.sdk.crash.model.b();
        this.f58715b = new com.kwad.sdk.crash.model.a();
        this.f58719f = aVar.f58726c;
        this.f58720g = aVar.f58727d;
        this.f58721h = aVar.f58728e;
        this.f58722i = aVar.f58729f;
        this.f58723j = aVar.f58730g;
        this.f58724k = aVar.f58731h;
        this.l = aVar.f58732i;
        this.m = aVar.f58733j;
        this.n = aVar.f58734k;
        this.f58715b.a = aVar.q;
        this.f58715b.f58755b = aVar.r;
        this.f58715b.f58757d = aVar.t;
        this.f58715b.f58756c = aVar.s;
        this.a.f58760d = aVar.o;
        this.a.f58761e = aVar.p;
        this.a.f58758b = aVar.m;
        this.a.f58759c = aVar.n;
        this.a.a = aVar.l;
        this.a.f58762f = aVar.a;
        this.f58716c = aVar.u;
        this.f58717d = aVar.v;
        this.f58718e = aVar.f58725b;
    }

    public e a() {
        return this.f58721h;
    }

    public boolean b() {
        return this.f58719f;
    }
}
