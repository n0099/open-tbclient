package com.kwad.sdk.crash;

import android.content.Context;
/* loaded from: classes7.dex */
public class b {
    public final com.kwad.sdk.crash.model.b a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.a f40148b;

    /* renamed from: c  reason: collision with root package name */
    public final f f40149c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f40150d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f40151e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f40152f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f40153g;

    /* renamed from: h  reason: collision with root package name */
    public final e f40154h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    /* loaded from: classes7.dex */
    public static class a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f40155b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f40156c = false;

        /* renamed from: d  reason: collision with root package name */
        public Context f40157d;

        /* renamed from: e  reason: collision with root package name */
        public e f40158e;

        /* renamed from: f  reason: collision with root package name */
        public String f40159f;

        /* renamed from: g  reason: collision with root package name */
        public String f40160g;

        /* renamed from: h  reason: collision with root package name */
        public String f40161h;
        public String i;
        public String j;
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

        public a a(int i) {
            this.n = i;
            return this;
        }

        public a a(Context context) {
            this.f40157d = context;
            return this;
        }

        public a a(e eVar) {
            this.f40158e = eVar;
            return this;
        }

        public a a(f fVar) {
            this.u = fVar;
            return this;
        }

        public a a(String str) {
            this.f40159f = str;
            return this;
        }

        public a a(String[] strArr) {
            this.v = strArr;
            return this;
        }

        public b a() {
            return new b(this);
        }

        public a b(int i) {
            this.p = i;
            return this;
        }

        public a b(String str) {
            this.f40161h = str;
            return this;
        }

        public a b(String[] strArr) {
            this.f40155b = strArr;
            return this;
        }

        public a c(int i) {
            this.a = i;
            return this;
        }

        public a c(String str) {
            this.i = str;
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
        this.f40148b = new com.kwad.sdk.crash.model.a();
        this.f40152f = aVar.f40156c;
        this.f40153g = aVar.f40157d;
        this.f40154h = aVar.f40158e;
        this.i = aVar.f40159f;
        this.j = aVar.f40160g;
        this.k = aVar.f40161h;
        this.l = aVar.i;
        this.m = aVar.j;
        this.n = aVar.k;
        this.f40148b.a = aVar.q;
        this.f40148b.f40180b = aVar.r;
        this.f40148b.f40182d = aVar.t;
        this.f40148b.f40181c = aVar.s;
        this.a.f40185d = aVar.o;
        this.a.f40186e = aVar.p;
        this.a.f40183b = aVar.m;
        this.a.f40184c = aVar.n;
        this.a.a = aVar.l;
        this.a.f40187f = aVar.a;
        this.f40149c = aVar.u;
        this.f40150d = aVar.v;
        this.f40151e = aVar.f40155b;
    }

    public e a() {
        return this.f40154h;
    }

    public boolean b() {
        return this.f40152f;
    }
}
