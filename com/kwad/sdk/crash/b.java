package com.kwad.sdk.crash;

import android.content.Context;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.b f35061a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.a f35062b;

    /* renamed from: c  reason: collision with root package name */
    public final f f35063c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f35064d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f35065e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f35066f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f35067g;

    /* renamed from: h  reason: collision with root package name */
    public final e f35068h;

    /* renamed from: i  reason: collision with root package name */
    public final String f35069i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f35070a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f35071b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f35072c = false;

        /* renamed from: d  reason: collision with root package name */
        public Context f35073d;

        /* renamed from: e  reason: collision with root package name */
        public e f35074e;

        /* renamed from: f  reason: collision with root package name */
        public String f35075f;

        /* renamed from: g  reason: collision with root package name */
        public String f35076g;

        /* renamed from: h  reason: collision with root package name */
        public String f35077h;

        /* renamed from: i  reason: collision with root package name */
        public String f35078i;
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
            this.f35073d = context;
            return this;
        }

        public a a(e eVar) {
            this.f35074e = eVar;
            return this;
        }

        public a a(f fVar) {
            this.u = fVar;
            return this;
        }

        public a a(String str) {
            this.f35075f = str;
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
            this.f35077h = str;
            return this;
        }

        public a b(String[] strArr) {
            this.f35071b = strArr;
            return this;
        }

        public a c(int i2) {
            this.f35070a = i2;
            return this;
        }

        public a c(String str) {
            this.f35078i = str;
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
        this.f35061a = new com.kwad.sdk.crash.model.b();
        this.f35062b = new com.kwad.sdk.crash.model.a();
        this.f35066f = aVar.f35072c;
        this.f35067g = aVar.f35073d;
        this.f35068h = aVar.f35074e;
        this.f35069i = aVar.f35075f;
        this.j = aVar.f35076g;
        this.k = aVar.f35077h;
        this.l = aVar.f35078i;
        this.m = aVar.j;
        this.n = aVar.k;
        this.f35062b.f35106a = aVar.q;
        this.f35062b.f35107b = aVar.r;
        this.f35062b.f35109d = aVar.t;
        this.f35062b.f35108c = aVar.s;
        this.f35061a.f35113d = aVar.o;
        this.f35061a.f35114e = aVar.p;
        this.f35061a.f35111b = aVar.m;
        this.f35061a.f35112c = aVar.n;
        this.f35061a.f35110a = aVar.l;
        this.f35061a.f35115f = aVar.f35070a;
        this.f35063c = aVar.u;
        this.f35064d = aVar.v;
        this.f35065e = aVar.f35071b;
    }

    public e a() {
        return this.f35068h;
    }

    public boolean b() {
        return this.f35066f;
    }
}
