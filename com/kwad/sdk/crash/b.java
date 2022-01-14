package com.kwad.sdk.crash;

import android.content.Context;
/* loaded from: classes3.dex */
public class b {
    public final com.kwad.sdk.crash.model.b a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.a f56503b;

    /* renamed from: c  reason: collision with root package name */
    public final f f56504c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f56505d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f56506e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f56507f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f56508g;

    /* renamed from: h  reason: collision with root package name */
    public final e f56509h;

    /* renamed from: i  reason: collision with root package name */
    public final String f56510i;

    /* renamed from: j  reason: collision with root package name */
    public final String f56511j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    /* loaded from: classes3.dex */
    public static class a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f56512b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f56513c = false;

        /* renamed from: d  reason: collision with root package name */
        public Context f56514d;

        /* renamed from: e  reason: collision with root package name */
        public e f56515e;

        /* renamed from: f  reason: collision with root package name */
        public String f56516f;

        /* renamed from: g  reason: collision with root package name */
        public String f56517g;

        /* renamed from: h  reason: collision with root package name */
        public String f56518h;

        /* renamed from: i  reason: collision with root package name */
        public String f56519i;

        /* renamed from: j  reason: collision with root package name */
        public String f56520j;
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
            this.f56514d = context;
            return this;
        }

        public a a(e eVar) {
            this.f56515e = eVar;
            return this;
        }

        public a a(f fVar) {
            this.u = fVar;
            return this;
        }

        public a a(String str) {
            this.f56516f = str;
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
            this.f56518h = str;
            return this;
        }

        public a b(String[] strArr) {
            this.f56512b = strArr;
            return this;
        }

        public a c(int i2) {
            this.a = i2;
            return this;
        }

        public a c(String str) {
            this.f56519i = str;
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
        this.f56503b = new com.kwad.sdk.crash.model.a();
        this.f56507f = aVar.f56513c;
        this.f56508g = aVar.f56514d;
        this.f56509h = aVar.f56515e;
        this.f56510i = aVar.f56516f;
        this.f56511j = aVar.f56517g;
        this.k = aVar.f56518h;
        this.l = aVar.f56519i;
        this.m = aVar.f56520j;
        this.n = aVar.k;
        this.f56503b.a = aVar.q;
        this.f56503b.f56541b = aVar.r;
        this.f56503b.f56543d = aVar.t;
        this.f56503b.f56542c = aVar.s;
        this.a.f56546d = aVar.o;
        this.a.f56547e = aVar.p;
        this.a.f56544b = aVar.m;
        this.a.f56545c = aVar.n;
        this.a.a = aVar.l;
        this.a.f56548f = aVar.a;
        this.f56504c = aVar.u;
        this.f56505d = aVar.v;
        this.f56506e = aVar.f56512b;
    }

    public e a() {
        return this.f56509h;
    }

    public boolean b() {
        return this.f56507f;
    }
}
