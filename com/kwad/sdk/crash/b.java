package com.kwad.sdk.crash;

import android.content.Context;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.b f32937a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.a f32938b;

    /* renamed from: c  reason: collision with root package name */
    public final f f32939c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f32940d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f32941e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f32942f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f32943g;

    /* renamed from: h  reason: collision with root package name */
    public final e f32944h;

    /* renamed from: i  reason: collision with root package name */
    public final String f32945i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f32946a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f32947b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f32948c = false;

        /* renamed from: d  reason: collision with root package name */
        public Context f32949d;

        /* renamed from: e  reason: collision with root package name */
        public e f32950e;

        /* renamed from: f  reason: collision with root package name */
        public String f32951f;

        /* renamed from: g  reason: collision with root package name */
        public String f32952g;

        /* renamed from: h  reason: collision with root package name */
        public String f32953h;

        /* renamed from: i  reason: collision with root package name */
        public String f32954i;
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
            this.f32949d = context;
            return this;
        }

        public a a(e eVar) {
            this.f32950e = eVar;
            return this;
        }

        public a a(f fVar) {
            this.u = fVar;
            return this;
        }

        public a a(String str) {
            this.f32951f = str;
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
            this.f32953h = str;
            return this;
        }

        public a b(String[] strArr) {
            this.f32947b = strArr;
            return this;
        }

        public a c(int i2) {
            this.f32946a = i2;
            return this;
        }

        public a c(String str) {
            this.f32954i = str;
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
        this.f32937a = new com.kwad.sdk.crash.model.b();
        this.f32938b = new com.kwad.sdk.crash.model.a();
        this.f32942f = aVar.f32948c;
        this.f32943g = aVar.f32949d;
        this.f32944h = aVar.f32950e;
        this.f32945i = aVar.f32951f;
        this.j = aVar.f32952g;
        this.k = aVar.f32953h;
        this.l = aVar.f32954i;
        this.m = aVar.j;
        this.n = aVar.k;
        this.f32938b.f32982a = aVar.q;
        this.f32938b.f32983b = aVar.r;
        this.f32938b.f32985d = aVar.t;
        this.f32938b.f32984c = aVar.s;
        this.f32937a.f32989d = aVar.o;
        this.f32937a.f32990e = aVar.p;
        this.f32937a.f32987b = aVar.m;
        this.f32937a.f32988c = aVar.n;
        this.f32937a.f32986a = aVar.l;
        this.f32937a.f32991f = aVar.f32946a;
        this.f32939c = aVar.u;
        this.f32940d = aVar.v;
        this.f32941e = aVar.f32947b;
    }

    public e a() {
        return this.f32944h;
    }

    public boolean b() {
        return this.f32942f;
    }
}
