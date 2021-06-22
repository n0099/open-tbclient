package com.kwad.sdk.crash;

import android.content.Context;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.b f35159a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.a f35160b;

    /* renamed from: c  reason: collision with root package name */
    public final f f35161c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f35162d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f35163e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f35164f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f35165g;

    /* renamed from: h  reason: collision with root package name */
    public final e f35166h;

    /* renamed from: i  reason: collision with root package name */
    public final String f35167i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f35168a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f35169b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f35170c = false;

        /* renamed from: d  reason: collision with root package name */
        public Context f35171d;

        /* renamed from: e  reason: collision with root package name */
        public e f35172e;

        /* renamed from: f  reason: collision with root package name */
        public String f35173f;

        /* renamed from: g  reason: collision with root package name */
        public String f35174g;

        /* renamed from: h  reason: collision with root package name */
        public String f35175h;

        /* renamed from: i  reason: collision with root package name */
        public String f35176i;
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
            this.f35171d = context;
            return this;
        }

        public a a(e eVar) {
            this.f35172e = eVar;
            return this;
        }

        public a a(f fVar) {
            this.u = fVar;
            return this;
        }

        public a a(String str) {
            this.f35173f = str;
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
            this.f35175h = str;
            return this;
        }

        public a b(String[] strArr) {
            this.f35169b = strArr;
            return this;
        }

        public a c(int i2) {
            this.f35168a = i2;
            return this;
        }

        public a c(String str) {
            this.f35176i = str;
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
        this.f35159a = new com.kwad.sdk.crash.model.b();
        this.f35160b = new com.kwad.sdk.crash.model.a();
        this.f35164f = aVar.f35170c;
        this.f35165g = aVar.f35171d;
        this.f35166h = aVar.f35172e;
        this.f35167i = aVar.f35173f;
        this.j = aVar.f35174g;
        this.k = aVar.f35175h;
        this.l = aVar.f35176i;
        this.m = aVar.j;
        this.n = aVar.k;
        this.f35160b.f35204a = aVar.q;
        this.f35160b.f35205b = aVar.r;
        this.f35160b.f35207d = aVar.t;
        this.f35160b.f35206c = aVar.s;
        this.f35159a.f35211d = aVar.o;
        this.f35159a.f35212e = aVar.p;
        this.f35159a.f35209b = aVar.m;
        this.f35159a.f35210c = aVar.n;
        this.f35159a.f35208a = aVar.l;
        this.f35159a.f35213f = aVar.f35168a;
        this.f35161c = aVar.u;
        this.f35162d = aVar.v;
        this.f35163e = aVar.f35169b;
    }

    public e a() {
        return this.f35166h;
    }

    public boolean b() {
        return this.f35164f;
    }
}
