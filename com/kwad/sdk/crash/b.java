package com.kwad.sdk.crash;

import android.content.Context;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.b f34414a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.a f34415b;

    /* renamed from: c  reason: collision with root package name */
    public final f f34416c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f34417d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f34418e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f34419f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f34420g;

    /* renamed from: h  reason: collision with root package name */
    public final e f34421h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f34422a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f34423b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f34424c = false;

        /* renamed from: d  reason: collision with root package name */
        public Context f34425d;

        /* renamed from: e  reason: collision with root package name */
        public e f34426e;

        /* renamed from: f  reason: collision with root package name */
        public String f34427f;

        /* renamed from: g  reason: collision with root package name */
        public String f34428g;

        /* renamed from: h  reason: collision with root package name */
        public String f34429h;
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
            this.f34425d = context;
            return this;
        }

        public a a(e eVar) {
            this.f34426e = eVar;
            return this;
        }

        public a a(f fVar) {
            this.u = fVar;
            return this;
        }

        public a a(String str) {
            this.f34427f = str;
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
            this.f34429h = str;
            return this;
        }

        public a b(String[] strArr) {
            this.f34423b = strArr;
            return this;
        }

        public a c(int i) {
            this.f34422a = i;
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
        this.f34414a = new com.kwad.sdk.crash.model.b();
        this.f34415b = new com.kwad.sdk.crash.model.a();
        this.f34419f = aVar.f34424c;
        this.f34420g = aVar.f34425d;
        this.f34421h = aVar.f34426e;
        this.i = aVar.f34427f;
        this.j = aVar.f34428g;
        this.k = aVar.f34429h;
        this.l = aVar.i;
        this.m = aVar.j;
        this.n = aVar.k;
        this.f34415b.f34456a = aVar.q;
        this.f34415b.f34457b = aVar.r;
        this.f34415b.f34459d = aVar.t;
        this.f34415b.f34458c = aVar.s;
        this.f34414a.f34463d = aVar.o;
        this.f34414a.f34464e = aVar.p;
        this.f34414a.f34461b = aVar.m;
        this.f34414a.f34462c = aVar.n;
        this.f34414a.f34460a = aVar.l;
        this.f34414a.f34465f = aVar.f34422a;
        this.f34416c = aVar.u;
        this.f34417d = aVar.v;
        this.f34418e = aVar.f34423b;
    }

    public e a() {
        return this.f34421h;
    }

    public boolean b() {
        return this.f34419f;
    }
}
