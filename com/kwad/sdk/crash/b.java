package com.kwad.sdk.crash;

import android.content.Context;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.b f34799a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.a f34800b;

    /* renamed from: c  reason: collision with root package name */
    public final f f34801c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f34802d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f34803e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f34804f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f34805g;

    /* renamed from: h  reason: collision with root package name */
    public final e f34806h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f34807a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f34808b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f34809c = false;

        /* renamed from: d  reason: collision with root package name */
        public Context f34810d;

        /* renamed from: e  reason: collision with root package name */
        public e f34811e;

        /* renamed from: f  reason: collision with root package name */
        public String f34812f;

        /* renamed from: g  reason: collision with root package name */
        public String f34813g;

        /* renamed from: h  reason: collision with root package name */
        public String f34814h;
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
            this.f34810d = context;
            return this;
        }

        public a a(e eVar) {
            this.f34811e = eVar;
            return this;
        }

        public a a(f fVar) {
            this.u = fVar;
            return this;
        }

        public a a(String str) {
            this.f34812f = str;
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
            this.f34814h = str;
            return this;
        }

        public a b(String[] strArr) {
            this.f34808b = strArr;
            return this;
        }

        public a c(int i) {
            this.f34807a = i;
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
        this.f34799a = new com.kwad.sdk.crash.model.b();
        this.f34800b = new com.kwad.sdk.crash.model.a();
        this.f34804f = aVar.f34809c;
        this.f34805g = aVar.f34810d;
        this.f34806h = aVar.f34811e;
        this.i = aVar.f34812f;
        this.j = aVar.f34813g;
        this.k = aVar.f34814h;
        this.l = aVar.i;
        this.m = aVar.j;
        this.n = aVar.k;
        this.f34800b.f34841a = aVar.q;
        this.f34800b.f34842b = aVar.r;
        this.f34800b.f34844d = aVar.t;
        this.f34800b.f34843c = aVar.s;
        this.f34799a.f34848d = aVar.o;
        this.f34799a.f34849e = aVar.p;
        this.f34799a.f34846b = aVar.m;
        this.f34799a.f34847c = aVar.n;
        this.f34799a.f34845a = aVar.l;
        this.f34799a.f34850f = aVar.f34807a;
        this.f34801c = aVar.u;
        this.f34802d = aVar.v;
        this.f34803e = aVar.f34808b;
    }

    public e a() {
        return this.f34806h;
    }

    public boolean b() {
        return this.f34804f;
    }
}
