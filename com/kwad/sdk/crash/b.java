package com.kwad.sdk.crash;

import android.content.Context;
/* loaded from: classes4.dex */
public class b {
    public final com.kwad.sdk.crash.model.b a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.a f56715b;

    /* renamed from: c  reason: collision with root package name */
    public final f f56716c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f56717d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f56718e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f56719f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f56720g;

    /* renamed from: h  reason: collision with root package name */
    public final e f56721h;

    /* renamed from: i  reason: collision with root package name */
    public final String f56722i;

    /* renamed from: j  reason: collision with root package name */
    public final String f56723j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    /* loaded from: classes4.dex */
    public static class a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f56724b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f56725c = false;

        /* renamed from: d  reason: collision with root package name */
        public Context f56726d;

        /* renamed from: e  reason: collision with root package name */
        public e f56727e;

        /* renamed from: f  reason: collision with root package name */
        public String f56728f;

        /* renamed from: g  reason: collision with root package name */
        public String f56729g;

        /* renamed from: h  reason: collision with root package name */
        public String f56730h;

        /* renamed from: i  reason: collision with root package name */
        public String f56731i;

        /* renamed from: j  reason: collision with root package name */
        public String f56732j;
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
            this.f56726d = context;
            return this;
        }

        public a a(e eVar) {
            this.f56727e = eVar;
            return this;
        }

        public a a(f fVar) {
            this.u = fVar;
            return this;
        }

        public a a(String str) {
            this.f56728f = str;
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
            this.f56730h = str;
            return this;
        }

        public a b(String[] strArr) {
            this.f56724b = strArr;
            return this;
        }

        public a c(int i2) {
            this.a = i2;
            return this;
        }

        public a c(String str) {
            this.f56731i = str;
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
        this.f56715b = new com.kwad.sdk.crash.model.a();
        this.f56719f = aVar.f56725c;
        this.f56720g = aVar.f56726d;
        this.f56721h = aVar.f56727e;
        this.f56722i = aVar.f56728f;
        this.f56723j = aVar.f56729g;
        this.k = aVar.f56730h;
        this.l = aVar.f56731i;
        this.m = aVar.f56732j;
        this.n = aVar.k;
        this.f56715b.a = aVar.q;
        this.f56715b.f56753b = aVar.r;
        this.f56715b.f56755d = aVar.t;
        this.f56715b.f56754c = aVar.s;
        this.a.f56758d = aVar.o;
        this.a.f56759e = aVar.p;
        this.a.f56756b = aVar.m;
        this.a.f56757c = aVar.n;
        this.a.a = aVar.l;
        this.a.f56760f = aVar.a;
        this.f56716c = aVar.u;
        this.f56717d = aVar.v;
        this.f56718e = aVar.f56724b;
    }

    public e a() {
        return this.f56721h;
    }

    public boolean b() {
        return this.f56719f;
    }
}
