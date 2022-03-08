package com.kwad.sdk.crash;

import android.content.Context;
/* loaded from: classes8.dex */
public class b {
    public final com.kwad.sdk.crash.model.b a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.a f55065b;

    /* renamed from: c  reason: collision with root package name */
    public final f f55066c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f55067d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f55068e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f55069f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f55070g;

    /* renamed from: h  reason: collision with root package name */
    public final e f55071h;

    /* renamed from: i  reason: collision with root package name */
    public final String f55072i;

    /* renamed from: j  reason: collision with root package name */
    public final String f55073j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    /* loaded from: classes8.dex */
    public static class a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f55074b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f55075c = false;

        /* renamed from: d  reason: collision with root package name */
        public Context f55076d;

        /* renamed from: e  reason: collision with root package name */
        public e f55077e;

        /* renamed from: f  reason: collision with root package name */
        public String f55078f;

        /* renamed from: g  reason: collision with root package name */
        public String f55079g;

        /* renamed from: h  reason: collision with root package name */
        public String f55080h;

        /* renamed from: i  reason: collision with root package name */
        public String f55081i;

        /* renamed from: j  reason: collision with root package name */
        public String f55082j;
        public String k;
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
            this.f55076d = context;
            return this;
        }

        public a a(e eVar) {
            this.f55077e = eVar;
            return this;
        }

        public a a(f fVar) {
            this.u = fVar;
            return this;
        }

        public a a(String str) {
            this.f55078f = str;
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
            this.f55080h = str;
            return this;
        }

        public a b(String[] strArr) {
            this.f55074b = strArr;
            return this;
        }

        public a c(int i2) {
            this.a = i2;
            return this;
        }

        public a c(String str) {
            this.f55081i = str;
            return this;
        }

        public a d(String str) {
            this.k = str;
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
        this.f55065b = new com.kwad.sdk.crash.model.a();
        this.f55069f = aVar.f55075c;
        this.f55070g = aVar.f55076d;
        this.f55071h = aVar.f55077e;
        this.f55072i = aVar.f55078f;
        this.f55073j = aVar.f55079g;
        this.k = aVar.f55080h;
        this.l = aVar.f55081i;
        this.m = aVar.f55082j;
        this.n = aVar.k;
        this.f55065b.a = aVar.q;
        this.f55065b.f55103b = aVar.r;
        this.f55065b.f55105d = aVar.t;
        this.f55065b.f55104c = aVar.s;
        this.a.f55108d = aVar.o;
        this.a.f55109e = aVar.p;
        this.a.f55106b = aVar.m;
        this.a.f55107c = aVar.n;
        this.a.a = aVar.l;
        this.a.f55110f = aVar.a;
        this.f55066c = aVar.u;
        this.f55067d = aVar.v;
        this.f55068e = aVar.f55074b;
    }

    public e a() {
        return this.f55071h;
    }

    public boolean b() {
        return this.f55069f;
    }
}
