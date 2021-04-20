package com.kwad.sdk.crash;

import android.content.Context;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.b f34704a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.a f34705b;

    /* renamed from: c  reason: collision with root package name */
    public final f f34706c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f34707d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f34708e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f34709f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f34710g;

    /* renamed from: h  reason: collision with root package name */
    public final e f34711h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f34712a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f34713b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f34714c = false;

        /* renamed from: d  reason: collision with root package name */
        public Context f34715d;

        /* renamed from: e  reason: collision with root package name */
        public e f34716e;

        /* renamed from: f  reason: collision with root package name */
        public String f34717f;

        /* renamed from: g  reason: collision with root package name */
        public String f34718g;

        /* renamed from: h  reason: collision with root package name */
        public String f34719h;
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
            this.f34715d = context;
            return this;
        }

        public a a(e eVar) {
            this.f34716e = eVar;
            return this;
        }

        public a a(f fVar) {
            this.u = fVar;
            return this;
        }

        public a a(String str) {
            this.f34717f = str;
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
            this.f34719h = str;
            return this;
        }

        public a b(String[] strArr) {
            this.f34713b = strArr;
            return this;
        }

        public a c(int i) {
            this.f34712a = i;
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
        this.f34704a = new com.kwad.sdk.crash.model.b();
        this.f34705b = new com.kwad.sdk.crash.model.a();
        this.f34709f = aVar.f34714c;
        this.f34710g = aVar.f34715d;
        this.f34711h = aVar.f34716e;
        this.i = aVar.f34717f;
        this.j = aVar.f34718g;
        this.k = aVar.f34719h;
        this.l = aVar.i;
        this.m = aVar.j;
        this.n = aVar.k;
        this.f34705b.f34746a = aVar.q;
        this.f34705b.f34747b = aVar.r;
        this.f34705b.f34749d = aVar.t;
        this.f34705b.f34748c = aVar.s;
        this.f34704a.f34753d = aVar.o;
        this.f34704a.f34754e = aVar.p;
        this.f34704a.f34751b = aVar.m;
        this.f34704a.f34752c = aVar.n;
        this.f34704a.f34750a = aVar.l;
        this.f34704a.f34755f = aVar.f34712a;
        this.f34706c = aVar.u;
        this.f34707d = aVar.v;
        this.f34708e = aVar.f34713b;
    }

    public e a() {
        return this.f34711h;
    }

    public boolean b() {
        return this.f34709f;
    }
}
