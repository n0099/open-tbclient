package com.kwad.sdk.crash;

import android.content.Context;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.b f33763a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.a f33764b;

    /* renamed from: c  reason: collision with root package name */
    public final f f33765c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f33766d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f33767e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f33768f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f33769g;

    /* renamed from: h  reason: collision with root package name */
    public final e f33770h;

    /* renamed from: i  reason: collision with root package name */
    public final String f33771i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f33772a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f33773b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f33774c = false;

        /* renamed from: d  reason: collision with root package name */
        public Context f33775d;

        /* renamed from: e  reason: collision with root package name */
        public e f33776e;

        /* renamed from: f  reason: collision with root package name */
        public String f33777f;

        /* renamed from: g  reason: collision with root package name */
        public String f33778g;

        /* renamed from: h  reason: collision with root package name */
        public String f33779h;

        /* renamed from: i  reason: collision with root package name */
        public String f33780i;
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

        public a a(int i2) {
            this.n = i2;
            return this;
        }

        public a a(Context context) {
            this.f33775d = context;
            return this;
        }

        public a a(e eVar) {
            this.f33776e = eVar;
            return this;
        }

        public a a(f fVar) {
            this.u = fVar;
            return this;
        }

        public a a(String str) {
            this.f33777f = str;
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
            this.f33779h = str;
            return this;
        }

        public a b(String[] strArr) {
            this.f33773b = strArr;
            return this;
        }

        public a c(int i2) {
            this.f33772a = i2;
            return this;
        }

        public a c(String str) {
            this.f33780i = str;
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
        this.f33763a = new com.kwad.sdk.crash.model.b();
        this.f33764b = new com.kwad.sdk.crash.model.a();
        this.f33768f = aVar.f33774c;
        this.f33769g = aVar.f33775d;
        this.f33770h = aVar.f33776e;
        this.f33771i = aVar.f33777f;
        this.j = aVar.f33778g;
        this.k = aVar.f33779h;
        this.l = aVar.f33780i;
        this.m = aVar.j;
        this.n = aVar.k;
        this.f33764b.f33808a = aVar.q;
        this.f33764b.f33809b = aVar.r;
        this.f33764b.f33811d = aVar.t;
        this.f33764b.f33810c = aVar.s;
        this.f33763a.f33815d = aVar.o;
        this.f33763a.f33816e = aVar.p;
        this.f33763a.f33813b = aVar.m;
        this.f33763a.f33814c = aVar.n;
        this.f33763a.f33812a = aVar.l;
        this.f33763a.f33817f = aVar.f33772a;
        this.f33765c = aVar.u;
        this.f33766d = aVar.v;
        this.f33767e = aVar.f33773b;
    }

    public e a() {
        return this.f33770h;
    }

    public boolean b() {
        return this.f33768f;
    }
}
