package com.kwad.sdk.crash;

import android.content.Context;
/* loaded from: classes3.dex */
public class b {
    public final com.kwad.sdk.crash.model.b a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.a f56548b;

    /* renamed from: c  reason: collision with root package name */
    public final f f56549c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f56550d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f56551e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f56552f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f56553g;

    /* renamed from: h  reason: collision with root package name */
    public final e f56554h;

    /* renamed from: i  reason: collision with root package name */
    public final String f56555i;

    /* renamed from: j  reason: collision with root package name */
    public final String f56556j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    /* loaded from: classes3.dex */
    public static class a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f56557b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f56558c = false;

        /* renamed from: d  reason: collision with root package name */
        public Context f56559d;

        /* renamed from: e  reason: collision with root package name */
        public e f56560e;

        /* renamed from: f  reason: collision with root package name */
        public String f56561f;

        /* renamed from: g  reason: collision with root package name */
        public String f56562g;

        /* renamed from: h  reason: collision with root package name */
        public String f56563h;

        /* renamed from: i  reason: collision with root package name */
        public String f56564i;

        /* renamed from: j  reason: collision with root package name */
        public String f56565j;
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
            this.f56559d = context;
            return this;
        }

        public a a(e eVar) {
            this.f56560e = eVar;
            return this;
        }

        public a a(f fVar) {
            this.u = fVar;
            return this;
        }

        public a a(String str) {
            this.f56561f = str;
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
            this.f56563h = str;
            return this;
        }

        public a b(String[] strArr) {
            this.f56557b = strArr;
            return this;
        }

        public a c(int i2) {
            this.a = i2;
            return this;
        }

        public a c(String str) {
            this.f56564i = str;
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
        this.f56548b = new com.kwad.sdk.crash.model.a();
        this.f56552f = aVar.f56558c;
        this.f56553g = aVar.f56559d;
        this.f56554h = aVar.f56560e;
        this.f56555i = aVar.f56561f;
        this.f56556j = aVar.f56562g;
        this.k = aVar.f56563h;
        this.l = aVar.f56564i;
        this.m = aVar.f56565j;
        this.n = aVar.k;
        this.f56548b.a = aVar.q;
        this.f56548b.f56586b = aVar.r;
        this.f56548b.f56588d = aVar.t;
        this.f56548b.f56587c = aVar.s;
        this.a.f56591d = aVar.o;
        this.a.f56592e = aVar.p;
        this.a.f56589b = aVar.m;
        this.a.f56590c = aVar.n;
        this.a.a = aVar.l;
        this.a.f56593f = aVar.a;
        this.f56549c = aVar.u;
        this.f56550d = aVar.v;
        this.f56551e = aVar.f56557b;
    }

    public e a() {
        return this.f56554h;
    }

    public boolean b() {
        return this.f56552f;
    }
}
