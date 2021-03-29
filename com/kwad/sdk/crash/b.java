package com.kwad.sdk.crash;

import android.content.Context;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.b f34415a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.a f34416b;

    /* renamed from: c  reason: collision with root package name */
    public final f f34417c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f34418d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f34419e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f34420f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f34421g;

    /* renamed from: h  reason: collision with root package name */
    public final e f34422h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f34423a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f34424b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f34425c = false;

        /* renamed from: d  reason: collision with root package name */
        public Context f34426d;

        /* renamed from: e  reason: collision with root package name */
        public e f34427e;

        /* renamed from: f  reason: collision with root package name */
        public String f34428f;

        /* renamed from: g  reason: collision with root package name */
        public String f34429g;

        /* renamed from: h  reason: collision with root package name */
        public String f34430h;
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
            this.f34426d = context;
            return this;
        }

        public a a(e eVar) {
            this.f34427e = eVar;
            return this;
        }

        public a a(f fVar) {
            this.u = fVar;
            return this;
        }

        public a a(String str) {
            this.f34428f = str;
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
            this.f34430h = str;
            return this;
        }

        public a b(String[] strArr) {
            this.f34424b = strArr;
            return this;
        }

        public a c(int i) {
            this.f34423a = i;
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
        this.f34415a = new com.kwad.sdk.crash.model.b();
        this.f34416b = new com.kwad.sdk.crash.model.a();
        this.f34420f = aVar.f34425c;
        this.f34421g = aVar.f34426d;
        this.f34422h = aVar.f34427e;
        this.i = aVar.f34428f;
        this.j = aVar.f34429g;
        this.k = aVar.f34430h;
        this.l = aVar.i;
        this.m = aVar.j;
        this.n = aVar.k;
        this.f34416b.f34457a = aVar.q;
        this.f34416b.f34458b = aVar.r;
        this.f34416b.f34460d = aVar.t;
        this.f34416b.f34459c = aVar.s;
        this.f34415a.f34464d = aVar.o;
        this.f34415a.f34465e = aVar.p;
        this.f34415a.f34462b = aVar.m;
        this.f34415a.f34463c = aVar.n;
        this.f34415a.f34461a = aVar.l;
        this.f34415a.f34466f = aVar.f34423a;
        this.f34417c = aVar.u;
        this.f34418d = aVar.v;
        this.f34419e = aVar.f34424b;
    }

    public e a() {
        return this.f34422h;
    }

    public boolean b() {
        return this.f34420f;
    }
}
